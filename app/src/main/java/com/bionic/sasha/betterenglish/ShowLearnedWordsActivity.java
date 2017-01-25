package com.bionic.sasha.betterenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.bionic.sasha.betterenglish.ui.MyAdapter;
import com.bionic.sasha.betterenglish.ui.StudyWordsAdapter;

import java.util.ArrayList;

public class ShowLearnedWordsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private StudyWordsAdapter adapter;

    private TranslateDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_learned_words);

        dbHelper = new TranslateDBHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.learned_recycler_view);

        ArrayList<String> myWords = getWords();
        ArrayList<String> myTranslates = getTranslates();

        if (myWords.size() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.learned_words_warning)
                    .setCancelable(false)
                    .setNegativeButton(R.string.learn,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent intentl = new Intent(ShowLearnedWordsActivity.this, OurDictionaryActivity.class);
                                    startActivity(intentl);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }


        layoutManager = new LinearLayoutManager(this); //осуществляем подключение менеджера к нашему списку
        recyclerView.setLayoutManager(layoutManager);

        adapter = new StudyWordsAdapter(myWords, myTranslates); //то же самое делаем с адаптером
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList<String> getWords() {
        ArrayList<String> mWords = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME,null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    mWords.add(cursor.getString(cursor.getColumnIndex(TranslateReaderDB.LearnedWords.COLUMN_WORD_RU)));
                } while (cursor.moveToNext());
            }
        }


        return mWords;
    }

    private ArrayList<String> getTranslates() {
        ArrayList<String> mTrans = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME,null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    mTrans.add(cursor.getString(cursor.getColumnIndex(TranslateReaderDB.LearnedWords.COLUMN_WORD_EN)));
                } while (cursor.moveToNext());
            }
        }


        return mTrans;
    }

}
