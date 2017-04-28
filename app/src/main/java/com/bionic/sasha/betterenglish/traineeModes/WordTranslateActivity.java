package com.bionic.sasha.betterenglish.traineeModes;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bionic.sasha.betterenglish.AddNewWordActivity;
import com.bionic.sasha.betterenglish.OurDictionaryActivity;
import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.api.Translate;
import com.bionic.sasha.betterenglish.customViews.RightNotification;
import com.bionic.sasha.betterenglish.customViews.WrongNotif;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordTranslateActivity extends AppCompatActivity {

    private static final String SAVED_TEXT = "saved_count_settings";
    public int allCount;
    private int correctAnswers = 0;
    public int currentCount = 1;
    SharedPreferences sp;
    public String[] settingsCount = {"10", "15", "20"};

    ArrayList<String> answers;
    ArrayList<String> variants;
    ArrayList<String> words;
    ArrayList<String> help;


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

    @BindView(R.id.btnSpeech)
    Button btnSpeech;


    private TranslateDBHelper dbHelper;

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_translate);

        ButterKnife.bind(this);

        answers = new ArrayList<>();
        words = new ArrayList<>();
        help = new ArrayList<>();
        variants = new ArrayList<>(4);


        dbHelper = new TranslateDBHelper(this);

        allCount = Integer.parseInt(settingsCount[loadCount()]); //количество изучений за один проход тренировки

        traineeWords.setText("" + currentCount); // заполняю №текущего слова и предыдущий параметр
        allWords.setText("" + allCount);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });


        help = workingWithDB();
        Log.d("Help: ", help.toString());
        for (int i = 0; i < allCount; i++) {
            answers.add(help.get(i));
        }
        Log.d("Answers: ", answers.toString());
        for (int k = allCount; k < allCount + 4; k++) {
            variants.add(help.get(k));
        }
        Log.d("Variants: ", variants.toString());
        for (int l = 5 * allCount; l < 6 * allCount; l++) {
            words.add(help.get(l));
        }
        Log.d("Words", words.toString());

        wordTrainee.setText(words.get(0));

        Collections.shuffle(variants);
        buttonOne.setText(variants.get(0));
        buttonTwo.setText(variants.get(1));
        buttonThree.setText(variants.get(2));
        buttonFour.setText(variants.get(3));

        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = wordTrainee.getText().toString();
                textToSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    private int loadCount() {
        int position = 0;
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        String savedText = sp.getString(SAVED_TEXT, "");
        for (int i = 0; i < settingsCount.length; i++) {
            if (savedText.equals(settingsCount[i])) position = i;
        }
        return position;
    }

    /**
     * Метод для необходимой работы с БД
     *
     * @return ответ, который должен ввести пользователь.
     */
    public ArrayList<String> workingWithDB() {
        Random random = new Random(); //создаем экземпляр рандома для получения рандомной строки таблицы
        ArrayList<String> variants = new ArrayList<>(); //сюда передадим возможные варианты ответов на кнопках. Всего будет 4.
        ArrayList<String> answer = new ArrayList<>(); //строка, с которой будем сравнивать
        ArrayList<String> wordsDB = new ArrayList<>();
        String selection1 = " mode1 < 3 "; //условие для БД, необходимое для получения нужных слов для изучения
        ArrayList<Integer> used = new ArrayList<>(); //вспомогательный Лист для того, чтобы варианты на кнопках не повторялись
        int count = 0; //счетчик количества строк, удовлетворяющих условие выше
        int position; //текущяя позиция курсора

        SQLiteDatabase database = dbHelper.getWritableDatabase(); //Создаем экземпляр БД и соединяем с нашим помощником.
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, selection1, null, null, null, null);
        //Это был прямой запрос к таблице New Word Name с некоторым требованием.
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    count++; //считаем количество удовлетв. строк табицы
                } while (c.moveToNext());
            }
        }


        // Дальше, если есть записи в таблице, переходим
        if (c != null) {
            ArrayList<Integer> use = new ArrayList<>();

            for (int k = 0; k < allCount; k++) {

                do {
                    position = random.nextInt(count); //генерируем случайную позицию в таблице для выыбора слова
                } while (use.contains(position));
                use.add(position);
                Log.d("pos", use.toString());
                c.moveToPosition(position); //переходим к этой строке в таблице
                used.add(position); //добавляем в использованные
                Log.d("used", String.valueOf(position));
//                word = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
//                wordTrainee.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN))); //записываем в карточку

                wordsDB.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN)));

                answer.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
                // записываем ожидаемый ответ пользователя

                variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
                //добавляем в лист правильный вариант


                for (int i = 0; i < 3; i++) { //тут генерируем еще 3 позиции чтобы не повторялись и добавляем в Лист возможных ответов
                    do {
                        position = random.nextInt(count);
                    } while (used.contains(position));
                    used.add(position);
                    Log.d("used", String.valueOf(position));

                    c.moveToPosition(position);
                    variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
                }
            }

        }
        database.close(); //закрываем БД

        ArrayList<String> result = new ArrayList<>();
        result.addAll(answer);
        result.addAll(variants);
        result.addAll(wordsDB);
        Log.d("Result: ", result.toString());
        return result; //передаем ожидаемый ответ
    }

    /**
     * Метод отклика на кнопочке
     *
     * @param view
     */
    public void onClick(View view) {

        Button b = (Button) view;
        String correct = (String) b.getText(); //считываю значение с нажатой кнопки

        variants.clear();


        if (correct.compareTo(answers.get(currentCount-1)) == 0) {
            correctAnswers++;
            changeModeCorrectResult(answers.get(currentCount-1)); //запускаю метод работы с БД для правильного ответа

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle(R.string.wrong).setMessage(words.get(currentCount - 1) + "  -  " + answers.get(currentCount - 1)).setCancelable(false)
                    .setIcon(R.drawable.wrong).setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    changeModeWrongResult(answers.get(currentCount-1)); // для неправильнного ответа
                }
            });

            AlertDialog alert = builder.create();
            alert.show();
        }
        if (currentCount < allCount) {

            wordTrainee.setText(words.get(currentCount));
            for (int k = (allCount + 4 * currentCount); k < (allCount + 4 * (currentCount + 1)); k++) {
                variants.add(help.get(k));
            }
            Collections.shuffle(variants);
            buttonOne.setText(variants.get(0));
            buttonTwo.setText(variants.get(1));
            buttonThree.setText(variants.get(2));
            buttonFour.setText(variants.get(3));
            currentCount++; //изменяю счетчик текущего слова
            traineeWords.setText("" + currentCount); //записываю слово в карточку для пользователя
        } else {
            if (correct.compareTo(answers.get(currentCount-1)) == 0) {
                changeModeCorrectResult(answers.get(currentCount-1)); //запускаю метод работы с БД для правильного ответа

                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                String str = getString(R.string.you_have) + correctAnswers + getString(R.string.correct_answers);
                //запускааю окно с разными параметрами и правильным кол-вом ответов
                builder2.setTitle(R.string.result)
                        .setCancelable(false)
                        .setIcon(R.drawable.correct)
                        .setMessage(str)
                        .setNegativeButton(R.string.change_mode, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                Intent intent = new Intent(WordTranslateActivity.this, OurDictionaryActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setPositiveButton(R.string.this_mode, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                Intent intent = new Intent(WordTranslateActivity.this, WordTranslateActivity.class);
                                startActivity(intent);
                            }
                        });
                AlertDialog alert2 = builder2.create();
                alert2.show();

            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle(R.string.wrong).setMessage(words.get(currentCount - 1) + "  -  " + answers.get(currentCount - 1)).setCancelable(false)
                        .setIcon(R.drawable.wrong).setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        changeModeWrongResult(answers.get(currentCount-1)); // для неправильнного ответа

                        AlertDialog.Builder builder2 = new AlertDialog.Builder(WordTranslateActivity.this);
                        String str = getString(R.string.you_have) + correctAnswers + getString(R.string.correct_answers);
                        //запускааю окно с разными параметрами и правильным кол-вом ответов
                        builder2.setTitle(R.string.result)
                                .setCancelable(false)
                                .setIcon(R.drawable.correct)
                                .setMessage(str)
                                .setNegativeButton(R.string.change_mode, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                        Intent intent = new Intent(WordTranslateActivity.this, OurDictionaryActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .setPositiveButton(R.string.this_mode, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                        Intent intent = new Intent(WordTranslateActivity.this, WordTranslateActivity.class);
                                        startActivity(intent);
                                    }
                                });
                        AlertDialog alert2 = builder2.create();
                        alert2.show();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }


        }

    }

    public void changeModeCorrectResult(String wordRu) { //ищу слово и изменяю значение режима для него
        int c1 = 0; //переменная для считывания текущего значения для каждого слова в режиме 1
        int allModes = 0; //общий показатель слова по всем режимам. Если будет 12, значит слово выучено
        SQLiteDatabase database = dbHelper.getWritableDatabase(); //создаем экз БД
        Cursor cursor = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, //через курсор выполняем прямой запрос
                null,
                TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU + " = '" + wordRu + "' ", //ищу само слово
                null,
                null,
                null,
                null);

        if (cursor != null) {
            if (cursor.moveToFirst()) { // перехожу к 1 возможной строке
                c1 = cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE1)) + 1;
                //считал текущее значение и прибавил к нему 1
                allModes = c1 + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE2))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE3))
                        + cursor.getInt(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE4));
                //посчитал общее значение режимов
            }
        }

        ContentValues cv = new ContentValues(); //с помощью этой фигулины смогу перезаписать значения в таблицах
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, c1); //закидываю туда новое значение для моего режима

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, //запрос на изменение определенной строки
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU + " = '" + wordRu + "' ", null);

        if (allModes >= 9) { //если 12, значит слово изучено
            ContentValues contentValues = new ContentValues(); //создаю строку с этим словом в новой таблице для изученных слов
            String str;
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_RU, wordRu); //записал русское слово
            str = cursor.getString(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
            //из старой БД вытянул перевод этого слова
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_EN, str);
            //и закинул в другую таблицу
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_DATE, System.currentTimeMillis());
            //также добавил время, когда слово было добавлено

            database.insert(TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME, null, contentValues);
            //передал данные в новую таблицу и записал
        }


        database.close();//закрыл БД

    }

    /**
     * то же самое для неправильного ответа. Только тут устанавливаем значение в 0.
     *
     * @param wordRu
     */
    public void changeModeWrongResult(String wordRu) {
        int c1 = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU + " = '" + wordRu + "' ", null);


        database.close();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, OurDictionaryActivity.class);
        startActivity(intent);
    }
}
