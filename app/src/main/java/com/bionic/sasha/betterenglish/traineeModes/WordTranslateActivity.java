package com.bionic.sasha.betterenglish.traineeModes;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordTranslateActivity extends AppCompatActivity {

    public int allCount;
    private int correctAnswers = 0;
    public int currentCount = 1;
    public String answer = "";
    Toast toast;
    Toast toast2;


    @BindView(R.id.trainee_card_layout)
    LinearLayout layout;

    @BindView(R.id.traine_mode_word)
    TextView wordTrainee;

    @BindView(R.id.wrong_view)
    WrongNotif wrong;

    @BindView(R.id.right_view)
    RightNotification right;

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

        dbHelper = new TranslateDBHelper(this);

        allCount = 10; //количество изучений за один проход тренировки

        traineeWords.setText("" + currentCount); // заполняю №текущего слова и предыдущий параметр
        allWords.setText("" + allCount);


        toast = Toast.makeText(this, "Correct", Toast.LENGTH_SHORT);
        View toastView = toast.getView(); //This'll return the default View of the Toast.

        /* And now you can get the TextView of the default View of the Toast. */
        TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
        toastMessage.setTextSize(25);
        toastMessage.setTextColor(Color.WHITE);
        toastMessage.setGravity(Gravity.CENTER);
        toastMessage.setCompoundDrawablePadding(16);
        toastView.setBackgroundColor(Color.GREEN);

        toast2 = Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT);
        View toastView2 = toast2.getView(); //This'll return the default View of the Toast.

        /* And now you can get the TextView of the default View of the Toast. */
        TextView toastMessage2 = (TextView) toastView2.findViewById(android.R.id.message);
        toastMessage2.setTextSize(25);
        toastMessage2.setTextColor(Color.WHITE);
        toastMessage2.setGravity(Gravity.CENTER);
        toastMessage2.setCompoundDrawablePadding(16);
        toastView2.setBackgroundColor(Color.RED);

        answer = workingWithDB();
    }

    /**
     * Метод для необходимой работы с БД
     * @return ответ, который должен ввести пользователь.
     */
    public String workingWithDB(){
        Random random = new Random(); //создаем экземпляр рандома для получения рандомной строки таблицы
        ArrayList<String> variants = new ArrayList<>(); //сюда передадим возможные варианты ответов на кнопках. Всего будет 4.
        String answer = ""; //строка, с которой будем сравнивать
        String selection1 = " mode1 < 3 "; //условие для БД, необходимое для получения нужных слов для изучения
        ArrayList<Integer> used = new ArrayList<>(); //вспомогательный Лист для того, чтобы варианты на кнопках не повторялись
        int count = 0; //счетчик количества строк, удовлетворяющих условие выше
        int position; //текущяя позиция курсора

        SQLiteDatabase database = dbHelper.getWritableDatabase(); //Создаем экземпляр БД и соединяем с нашим помощником.
        Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,null, selection1, null, null, null, null);
        //Это был прямой запрос к таблице New Word Name с некоторым требованием.
        if (c != null){
            if (c.moveToFirst()){
                do {
                    count++; //считаем количество удовлетв. строк табицы
                } while (c.moveToNext());
            }

            c.moveToFirst(); // переходим к первой строке полученной таблицы

            do { // так я вывожу свою БД в лог для контроля происходящего. Во время оптимизации кода удалю)
                Log.d("my DB", "id = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts._ID))
                        + " , ru = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU))
                        + " , en = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN))
                        + " , mode1 = " + c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_MODE1)));
            } while (c.moveToNext()); //выовдится построчно, пока есть возможность перейти к следующей строке
        }




        // Дальше, если есть записи в таблице, переходим
        if (c != null) {
            position = random.nextInt(count); //генерируем случайную позицию в таблице для выыбора слова
            Log.d("pos", String.valueOf(position));
            c.moveToPosition(position); //переходим к этой строке в таблице
            used.add(position); //добавляем в использованные
            Log.d("used", String.valueOf(position));
            wordTrainee.setText(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN))); //записываем в карточку
            answer = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));
            // записываем ожидаемый ответ пользователя

            variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            //добавляем в лист правильный вариант

            for (int i = 0; i < 3; i++) { //тут генерируем еще 3 позиции чтобы не повторялись и добавляем в Лист возможных ответов
                do {
                    position = random.nextInt(count);
                }  while (used.contains(position));
                used.add(position);
                Log.d("used", String.valueOf(position));

                c.moveToPosition(position);
                variants.add(c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU)));
            }

            Collections.shuffle(variants); //мешаем весь Лист и присваиваем значения кнопочкам
            buttonOne.setText(variants.get(0));
            buttonTwo.setText(variants.get(1));
            buttonThree.setText(variants.get(2));
            buttonFour.setText(variants.get(3));
        }
        database.close(); //закрываем БД
        return answer; //передаем ожидаемый ответ
    }

    /**
     * Метод отклика на кнопочке
     * @param view
     */
    public void onClick(View view) {

        Button b = (Button) view;
        String correct = (String) b.getText(); //считываю значение с нажатой кнопки

        if (currentCount < allCount){ //если текущее значение меньше общего проверяю

            if (correct.equals(answer)){ //если пользователь нажал правильно
              //  Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();


                toast.show();

                correctAnswers++;
                changeModeCorrectResult(answer); //запускаю метод работы с БД для правильного ответа
                right.setVisibility(View.VISIBLE);
                wrong.setVisibility(View.INVISIBLE);
            } else {
                toast2.show();

                changeModeWrongResult(answer); // для неправильнного ответа

                wrong.setVisibility(View.VISIBLE);
                right.setVisibility(View.INVISIBLE);
            }
           answer =  workingWithDB(); //после произведения изменений в БД обновляю текущее слово и ответ


            currentCount++; //изменяю счетчик текущего слова
            traineeWords.setText("" + currentCount); //записываю слово в карточку для пользователя
        } else {
            if (correct.equals(answer)){
                correctAnswers++; //после 10 слова не считывало правильный вариант, поэтому добавил такой костыль =)
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //запускааю окно с разными параметрами и правильным кол-вом ответов
            builder.setTitle("Result!")
                    .setCancelable(false)
                    .setMessage("You have " + correctAnswers + " correct answers.")
                    .setNegativeButton("Change Mode", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();

                                    Intent intent = new Intent(WordTranslateActivity.this, OurDictionaryActivity.class);
                                    startActivity(intent);
                                }
                            })
                    .setPositiveButton("This Mode", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                            Intent intent = new Intent(WordTranslateActivity.this, WordTranslateActivity.class);
                            startActivity(intent);
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    public void changeModeCorrectResult(String wordRu){ //ищу слово и изменяю значение режима для него
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
            if (cursor.moveToFirst()){ // перехожу к 1 возможной строке
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

        if (allModes >= 12) { //если 12, значит слово изучено
            ContentValues contentValues = new ContentValues(); //создаю строку с этим словом в новой таблице для изученных слов
            String str;
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_RU, wordRu); //записал русское слово
            str = cursor.getString(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
            //из старой БД вытянул перевод этого слова
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_WORD_EN, str);
            //и закинул в другую таблицу
            contentValues.put(TranslateReaderDB.LearnedWords.COLUMN_DATE, System.currentTimeMillis());
            //также добавил время, когда слово было добавлено

            database.insert(TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME, null , contentValues);
            //передал данные в новую таблицу и записал
        }


        database.close();//закрыл БД

    }

    /**
     * то же самое для неправильного ответа. Только тут устанавливаем значение в 0.
     * @param wordRu
     */
    public void changeModeWrongResult(String wordRu){
        int c1 = 0;
        SQLiteDatabase database = dbHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, c1);

        database.update(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,
                cv, TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU + " = '" + wordRu + "' ", null);



        database.close();

    }
}
