package com.bionic.sasha.betterenglish.traineeModes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class WordTranslateActivity extends AppCompatActivity {

    public int allCount;
    public int currentCount = 1;
    public String answer = "";

    final String SAVED_TEXT = "saved_text";

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

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_translate);

        ButterKnife.bind(this);

        dbHelper = new TranslateDBHelper(this);

        sp = getPreferences(MODE_PRIVATE);
        String savedText = sp.getString(SAVED_TEXT, "");

        allCount = 10;

        traineeWords.setText("" + currentCount);
        allWords.setText("" + allCount);

        answer = workingWithDB();
    }

    public String workingWithDB(){
        Random random = new Random();
        ArrayList<String> variants = new ArrayList<>();
        String answer = "";
        String selection1 = " mode1 < 3 ";
        ArrayList<Integer> used = new ArrayList<>();
        int count = 0;
        int position;

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,null, selection1, null, null, null, null);
        if (c != null){
            if (c.moveToFirst()){
                do {
                    count++;
                } while (c.moveToNext());
            }

            c.moveToFirst();

            do {
                Log.d("my DB", "id = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts._ID))
                        + " , ru = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU))
                        + " , en = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN)));
            } while (c.moveToNext());
        }




        if (c != null) {
            position = random.nextInt(count);
            Log.d("pos", String.valueOf(position));
            c.moveToPosition(position);
            used.add(position);
            Log.d("used", String.valueOf(position));
            wordTrainee.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN)));
            answer = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));

            variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));

            for (int i = 0; i < 3; i++) {
                do {
                    position = random.nextInt(count);
                }  while (used.contains(position));
                used.add(position);
                Log.d("used", String.valueOf(position));

                c.moveToPosition(position);
                variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            }

            Collections.shuffle(variants);
            buttonOne.setText(variants.get(0));
            buttonTwo.setText(variants.get(1));
            buttonThree.setText(variants.get(2));
            buttonFour.setText(variants.get(3));
        }

        return answer;
    }

    public void onClick(View view) {
        Log.d("current", "current count = " + currentCount + ", all = " + allCount);
        if (currentCount < allCount){
            Button b = (Button) view;
            String correct = (String) b.getText();

            if (correct.equals(answer)){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            }
           answer =  workingWithDB();


            currentCount++;
            traineeWords.setText("" + currentCount);
        } else {
            Intent intent = new Intent(this, OurDictionaryActivity.class);
            startActivity(intent);
        }
    }
}
