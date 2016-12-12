package com.bionic.sasha.betterenglish.traineeModes;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bionic.sasha.betterenglish.OurDictionaryActivity;
import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TranslateWordActivity extends AppCompatActivity {

    public int allCount;
    private int correctAnswers = 0;
    public int currentCount = 1;
    public String answer = "";


    @BindView(R.id.trainee_card_layout)
    LinearLayout layout;

    @BindView(R.id.traine_mode_word)
    TextView wordTrainee;

    @BindView(R.id.button_one)
    Button buttonOne;

    @BindView(R.id.button_two)
    Button buttonTwo;

    @BindView(R.id.button_three)
    Button buttonThree;

    @BindView(R.id.button_four)
    Button buttonFour;

    @BindView(R.id.current_trainee)
    TextView traineeWords;

    @BindView(R.id.all_trainee)
    TextView allWords;

    private TranslateDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_translate);

        ButterKnife.bind(this);

        layout.setBackgroundResource(R.color.mode2);
        buttonOne.setBackgroundResource(R.color.mode2);
        buttonTwo.setBackgroundResource(R.color.mode2);
        buttonThree.setBackgroundResource(R.color.mode2);
        buttonFour.setBackgroundResource(R.color.mode2);

        dbHelper = new TranslateDBHelper(this);

        allCount = 10;

        traineeWords.setText("" + currentCount);
        allWords.setText("" + allCount);

        answer = workingWithDB();
    }


    public String workingWithDB(){
        Random random = new Random();
        ArrayList<String> variants = new ArrayList<>();
        String answer = "";
        String selection2 = " mode2 < 3 ";
        ArrayList<Integer> used = new ArrayList<>();
        int count = 0;
        int position;

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,null, selection2, null, null, null, null);
        if (c != null){
            if (c.moveToFirst()){
                do {
                    count++;
                } while (c.moveToNext());
            }

            c.moveToFirst();

           /* do {
                Log.d("my DB", "id = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts._ID))
                        + " , ru = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU))
                        + " , en = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN))
                        + " , mode1 = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE1)));
            } while (c.moveToNext());*/
        }




        if (c != null) {
            position = random.nextInt(count);
            Log.d("pos", String.valueOf(position));
            c.moveToPosition(position);
            used.add(position);
            Log.d("used", String.valueOf(position));
            wordTrainee.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            answer = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));

            variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN)));

            for (int i = 0; i < 3; i++) {
                do {
                    position = random.nextInt(count);
                }  while (used.contains(position));
                used.add(position);
                Log.d("used", String.valueOf(position));

                c.moveToPosition(position);
                variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN)));
            }

            Collections.shuffle(variants);
            buttonOne.setText(variants.get(0));
            buttonTwo.setText(variants.get(1));
            buttonThree.setText(variants.get(2));
            buttonFour.setText(variants.get(3));
        }
        database.close();
        return answer;
    }


    public void onClick(View view) {
        Log.d("current", "current count = " + currentCount + ", all = " + allCount);

        Button b = (Button) view;
        String correct = (String) b.getText();

        if (currentCount < allCount){


            if (correct.equals(answer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                correctAnswers++;
                changeModeCorrectResult(answer);
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
                changeModeWrongResult(answer);
            }
            answer =  workingWithDB();


            currentCount++;
            traineeWords.setText("" + currentCount);
        } else {
            if (correct.equals(answer)){
                correctAnswers++;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Result!")
                    .setCancelable(false)
                    .setMessage("You have " + correctAnswers + " correct answers.")
                    .setNegativeButton("Change Mode", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                            Intent intent = new Intent(TranslateWordActivity.this, OurDictionaryActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setPositiveButton("This Mode", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                            Intent intent = new Intent(TranslateWordActivity.this, TranslateWordActivity.class);
                            startActivity(intent);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

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
                c1 = cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE2)) + 1;
                allModes = c1 + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE1))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE3))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE4));
            }
        }

        ContentValues cv = new ContentValues();
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE2, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN + " = '" + wordEn + "' ", null);

        if (allModes >= 11) {
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
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE2, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN + " = '" + wordEn + "' ", null);



        database.close();

    }
}
