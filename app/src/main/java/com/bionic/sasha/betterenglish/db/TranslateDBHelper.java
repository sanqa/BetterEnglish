package com.bionic.sasha.betterenglish.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SASHA on 10.12.2016.
 */

public class TranslateDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 2;
    public static final String DB_NAME = "EasyEnglish.db";



    public TranslateDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TranslateReaderDB.CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TranslateReaderDB.DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void addWord(Translator translator){

    }
}
