package com.bionic.sasha.betterenglish.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SASHA on 10.12.2016.
 */

public class TranslateDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 14;
    public static final String DB_NAME = "EasyEnglish.db";



    public TranslateDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TranslateReaderDB.CREATE_ENTRIES);
        sqLiteDatabase.execSQL(TranslateReaderDB.CT2);

        for (String i : TranslateReaderDB.arr){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce3);
        for (String i : TranslateReaderDB.arr3){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce4);
        for (String i : TranslateReaderDB.arr4){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce5);
        for (String i : TranslateReaderDB.arr5){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce6);
        for (String i : TranslateReaderDB.arr6){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce7);
        for (String i : TranslateReaderDB.arr7){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce8);
        for (String i : TranslateReaderDB.arr8){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce9);
        for (String i : TranslateReaderDB.arr9){
            sqLiteDatabase.execSQL(i);
        }

        sqLiteDatabase.execSQL(TranslateReaderDB.ce10);
        for (String i : TranslateReaderDB.arr10){
            sqLiteDatabase.execSQL(i);
        }


        sqLiteDatabase.execSQL(TranslateReaderDB.ce11);
        for (String i : TranslateReaderDB.arr11){
            sqLiteDatabase.execSQL(i);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TranslateReaderDB.DELETE_ENTRIES);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE2);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE3);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE4);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE5);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE6);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE7);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE8);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE9);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE10);
        sqLiteDatabase.execSQL(TranslateReaderDB.DE11);
        onCreate(sqLiteDatabase);
    }


}
