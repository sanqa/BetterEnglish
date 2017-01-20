package com.bionic.sasha.betterenglish.traineeModes;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.OurDictionaryActivity;
import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.customViews.RightNotification;
import com.bionic.sasha.betterenglish.customViews.WrongNotif;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.bionic.sasha.betterenglish.R.id.btnSubmit;

public class DirectlyModeActivity extends AppCompatActivity {

    private static final String SAVED_TEXT = "saved_count_settings";
    TranslateDBHelper dbHelper;


    public int allCount;
    private int correctAnswers = 0;
    public int currentCount = 1;
    private String word = "";
    public String answer = "";

    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @BindView(R.id.seeWord)
    TextView seeWord;

    @BindView(R.id.giveTheAnswer)
    EditText giveTheAnswer;

    @BindView(R.id.current_mode_3)
    TextView traineeWords3;

    @BindView(R.id.all_mode_3)
    TextView allWords3;

    SharedPreferences sp;

    String[] settingsCount = {"10", "15", "20"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directly_mode);

        ButterKnife.bind(this);

        dbHelper = new TranslateDBHelper(this);

        allCount = Integer.parseInt(settingsCount[loadCount()]);

        traineeWords3.setText(" " + currentCount);
        allWords3.setText(" " + allCount);

        answer = workingWithDB();
    }

    private int loadCount(){
        int position = 0;
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        String savedText = sp.getString(SAVED_TEXT, "");
        for (int i = 0; i < settingsCount.length; i++){
            if (savedText.equals(settingsCount[i])) position = i;
        }
        return position;
    }

    public String workingWithDB() {
        Random random = new Random();
        String answer = "";
        String selection3 = " mode3 < 3 ";
        int count = 0;
        int position;

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,null, selection3, null, null, null, null);
        if (c != null){
            if (c.moveToFirst()){
                do {
                    count++;
                } while (c.moveToNext());
            }

            c.moveToFirst();


        }




        if (c != null) {
            position = random.nextInt(count);
            Log.d("pos", String.valueOf(position));
            c.moveToPosition(position);
            Log.d("used", String.valueOf(position));
            seeWord.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            word = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));
            answer = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));

        }
        database.close();
        return answer;

    }

    public void onClick(View view){
        String correct = giveTheAnswer.getText().toString();

        if (currentCount < allCount){


            if (correct.equals(answer)){
                correctAnswers++;
                changeModeCorrectResult(answer);

                answer =  workingWithDB();
                currentCount++;
                traineeWords3.setText("" + currentCount);
                giveTheAnswer.setText("");
            } else {



                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle(R.string.wrong).setMessage(word + "  -  " + answer).setCancelable(false)
                        .setIcon(R.drawable.wrong).setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        changeModeWrongResult(answer); // для неправильнного ответа


                        answer =  workingWithDB();
                        currentCount++;
                        traineeWords3.setText("" + currentCount);
                        giveTheAnswer.setText("");

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        } else {


            if (correct.equals(answer)) { //если пользователь нажал правильно

                correctAnswers++;
                changeModeCorrectResult(answer); //запускаю метод работы с БД для правильного ответа

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                String str =  getString(R.string.you_have) + correctAnswers + getString(R.string.correct_answers);
                //запускааю окно с разными параметрами и правильным кол-вом ответов
                builder.setTitle(R.string.result)
                        .setCancelable(false)
                        .setIcon(R.drawable.correct)
                        .setMessage(str)
                        .setNegativeButton(R.string.change_mode, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                Intent intent = new Intent(DirectlyModeActivity.this, OurDictionaryActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton(R.string.this_mode, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                Intent intent = new Intent(DirectlyModeActivity.this, DirectlyModeActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();


            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle(R.string.wrong).setMessage(word + "  -  " + answer).setCancelable(false)
                        .setIcon(R.drawable.wrong).setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        changeModeWrongResult(answer); // для неправильнного ответа

                        AlertDialog.Builder builder = new AlertDialog.Builder(DirectlyModeActivity.this);
                        String str =  getString(R.string.you_have) + correctAnswers + getString(R.string.correct_answers);
                        //запускааю окно с разными параметрами и правильным кол-вом ответов
                        builder.setTitle(R.string.result)
                                .setCancelable(false)
                                .setIcon(R.drawable.correct)
                                .setMessage(str)
                                .setNegativeButton(R.string.change_mode, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                        Intent intent = new Intent(DirectlyModeActivity.this, OurDictionaryActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .setPositiveButton(R.string.this_mode, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                        Intent intent = new Intent(DirectlyModeActivity.this, DirectlyModeActivity.class);
                                        startActivity(intent);
                                    }
                                });
                        AlertDialog alert = builder.create();
                        alert.show();

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }

        }
    }

    public void changeModeCorrectResult(String wordEn){
        int c1 = 0;
        int allModes = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                null,
                TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN + " = '" + wordEn + "' ",
                null,
                null,
                null,
                null);

        if (cursor != null) {
            if (cursor.moveToFirst()){
                c1 = cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE3)) + 1;
                allModes = c1 + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE1))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE2))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE4));
            }
        }

        ContentValues cv = new ContentValues();
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE3, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN + " = '" + wordEn + "' ", null);

        if (allModes >= 9) {
            ContentValues contentValues = new ContentValues();
            String str;
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_EN, wordEn);
            str = cursor.getString(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_RU, str);
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_DATE, System.currentTimeMillis());

            database.insert(TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME, null , contentValues);
        }


        database.close();

    }

    public void changeModeWrongResult(String wordEn){
        int c1 = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE3, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN + " = '" + wordEn + "' ", null);



        database.close();

    }

}




