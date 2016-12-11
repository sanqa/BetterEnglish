package com.bionic.sasha.betterenglish.traineeModes;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;

import butterknife.BindView;

public class TranslateWordActivity extends AppCompatActivity {

    public int allCount;
    private int correctAnswers = 0;
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

        layout.setBackgroundResource(R.color.mode2);
        buttonOne.setBackgroundResource(R.color.mode2);
        buttonTwo.setBackgroundResource(R.color.mode2);
        buttonThree.setBackgroundResource(R.color.mode2);
        buttonFour.setBackgroundResource(R.color.mode2);


    }
}
