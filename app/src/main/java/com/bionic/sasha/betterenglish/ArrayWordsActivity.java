package com.bionic.sasha.betterenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.bionic.sasha.betterenglish.ui.ArrayWordsAdapter;
import com.bionic.sasha.betterenglish.ui.StudyWordsAdapter;

import java.util.ArrayList;

public class ArrayWordsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private ArrayWordsAdapter adapter;

    private TranslateDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_words);

        dbHelper = new TranslateDBHelper(this);

        recyclerView = (RecyclerView) findViewById(R.id.array_recycler_view);

        ArrayList<String> myWords = getWords();
        ArrayList<String> myNumbers = getCount();

        if (myWords.size() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.array_words_warning)
                    .setCancelable(false)
                    .setNegativeButton(R.string.add,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    Intent intentl = new Intent(ArrayWordsActivity.this, AddNewWordActivity.class);
                                    startActivity(intentl);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }


        layoutManager = new LinearLayoutManager(this); //осуществляем подключение менеджера к нашему списку
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ArrayWordsAdapter(myWords, myNumbers); //то же самое делаем с адаптером
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<String> getCount() {
        ArrayList<String> mCount = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        ArrayList<String> myWords = getWords();
        int size = myWords.size();


        for (int i = 0; i < size; i++) {
            int counter = 0;
            Cursor cursor = database.query(myWords.get(i), null, null, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        counter++;
                    } while (cursor.moveToNext());
                }
            }
            mCount.add(String.valueOf(counter));
        }

        return mCount;
    }

    private ArrayList<String> getWords() {
        ArrayList<String> mWords = new ArrayList<>();

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(TranslateReaderDB.FlagTable.TABLE_FLAG,null, " flag = 1", null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    mWords.add(cursor.getString(cursor.getColumnIndex(TranslateReaderDB.FlagTable.COLUMN_NAME)));
                } while (cursor.moveToNext());
            }
        }


        return mWords;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AddNewWordActivity.class);
        startActivity(intent);
    }
}
