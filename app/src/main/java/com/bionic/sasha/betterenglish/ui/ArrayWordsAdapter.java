package com.bionic.sasha.betterenglish.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bionic.sasha.betterenglish.ArrayWordsActivity;
import com.bionic.sasha.betterenglish.R;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;

import java.util.ArrayList;

/**
 * Created by SASHA on 09.01.2017.
 */

public class ArrayWordsAdapter extends RecyclerView.Adapter<ArrayWordsAdapter.ViewHolder> {

    private ArrayList<String> words;
    private ArrayList<String> numbers;
    private TranslateDBHelper dbHelper;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView wordRu;
        TextView number;
        ImageButton addButton;

        public ViewHolder(View v) {
            super(v);
            wordRu = (TextView) v.findViewById(R.id.array_word);
            number = (TextView) v.findViewById(R.id.array_count_words);
            addButton = (ImageButton) v.findViewById(R.id.array_button_add);
        }


    }

    public ArrayWordsAdapter(ArrayList<String> words, ArrayList<String> numbers) {
        this.words = words;
        this.numbers = numbers;
    }


    @Override
    public ArrayWordsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.array_words_card, parent, false);

        dbHelper = new TranslateDBHelper(v.getContext());

        ArrayWordsAdapter.ViewHolder vh = new ArrayWordsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ArrayWordsAdapter.ViewHolder holder, final int position) {
        holder.wordRu.setText(words.get(position));
        holder.number.setText(numbers.get(position));
        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                switch (position) {
                    default:
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                        builder.setTitle(R.string.add_array).setMessage(R.string.array_question).setCancelable(false)
                                .setPositiveButton(R.string.array_answer_yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        String name = words.get(position);
                                        writeWords(name);
                                        Intent intent = new Intent(view.getContext(), ArrayWordsActivity.class);
                                        view.getContext().startActivity(intent);
                                        Toast.makeText(view.getContext(), R.string.array_add, Toast.LENGTH_LONG).show();
                                    }
                                }).setNegativeButton(R.string.array_answer_no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                        break;

                }
            }
        });
    }

    private void writeWords(String tableName) {

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(tableName, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String wordRu = cursor.getString(cursor.getColumnIndex("wordru"));
                    String wordEn = cursor.getString(cursor.getColumnIndex("worden"));

                    ContentValues cv = new ContentValues();

                    int counter = 0;

                    Cursor c = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, null, null, null, null, null);
                    if (c != null) {
                        if (c.moveToFirst()) {
                            do {
                                String str1 = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));
                                String str2 = c.getString(c.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
                                if (wordEn.equals(str2) || wordRu.equals(str1) || str1.length() < 2 || str2.length() < 2)
                                    counter++;
                            } while (c.moveToNext());
                        }
                    }

                    if (counter == 0) {

                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU, wordRu);
                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN, wordEn);
                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, 0);
                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE2, 0);
                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE3, 0);
                        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE4, 0);

                        database.insert(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, cv);
                    }

                } while (cursor.moveToNext());
            }
        }
        ContentValues cv2 = new ContentValues();
        cv2.put(TranslateReaderDB.FlagTable.COLUMN_FLAG, 0);

        database.update(TranslateReaderDB.FlagTable.TABLE_FLAG,
                cv2,
                TranslateReaderDB.FlagTable.COLUMN_NAME + " = ?",
                new String[] {tableName});

        database.close();

    }



    @Override
    public int getItemCount() {
        return words.size();
    }


}
