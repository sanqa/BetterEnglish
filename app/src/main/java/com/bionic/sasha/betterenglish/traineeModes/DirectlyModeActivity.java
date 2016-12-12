package com.bionic.sasha.betterenglish.traineeModes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.bionic.sasha.betterenglish.R.id.btnSubmit;

public class DirectlyModeActivity extends AppCompatActivity {

    TranslateDBHelper dbHelper;

    public int allCount;
    private int correctAnswers = 0;
    public int currentCount = 1;
    public String answerM3 = "";

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directly_mode);

        ButterKnife.bind(this);

        dbHelper = new TranslateDBHelper(this);

        allCount = 10;

        traineeWords3.setText(" " + currentCount);
        allWords3.setText(" " + allCount);

        answerM3 = workingWithDB();
    }

    public String workingWithDB() {
        Random random = new Random();
        String answerM3 = "";

        String selection3 = "mode3 < 4";
        int count = 0;
        int position;


        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, selection3, null, null, null, null);

        if (c != null){
            if (c.moveToFirst()){
                do {
                    count++;
                   }while (c.moveToFirst()) ;
                }
                 c.moveToFirst();
                }
                if (c != null);{
            position = random.nextInt(count);
            Log.d("pos",String.valueOf(position));
            c.moveToPosition(position);
            Log.d("used",String.valueOf(position));

            seeWord.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            answerM3 = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
            }
            database.close();
        return answerM3;

    }
        public void Onclick(View view){
            Button b  = (Button) view;


        }

}




