package com.bionic.sasha.betterenglish.db;

import android.provider.BaseColumns;

/**
 * Created by SASHA on 10.12.2016.
 */

public class TranslateReaderDB {

    public class TranslateTexts implements BaseColumns {

        public static final String TABLE_NEW_WORD_NAME = "newWords";
        public static final String _ID = "wordid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
        public static final String COLUMN_MODE1 = "mode1";
        public static final String COLUMN_MODE2 = "mode2";
        public static final String COLUMN_MODE3 = "mode3";
        public static final String COLUMN_MODE4 = "mode4";
    }

    public class LearnedWords implements BaseColumns {
        public static final String TABLE_LEARNED_WORDS_NAME = "learnedWords";
        public static final String _ID = "wordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
        public static final String COLUMN_DATE = "date";
    }


    public static String CREATE_ENTRIES = "CREATE TABLE "
            + TranslateTexts.TABLE_NEW_WORD_NAME + " (" + TranslateTexts._ID + " INTEGER PRIMARY KEY, "
            + TranslateTexts.COLUMN_WORD_RU + " TEXT, " + TranslateTexts.COLUMN_WORD_EN + " TEXT, "
            + TranslateTexts.COLUMN_MODE1 + " INTEGER, " + TranslateTexts.COLUMN_MODE2  + " INTEGER, "
            + TranslateTexts.COLUMN_MODE3 + " INTEGER, " + TranslateTexts.COLUMN_MODE4 + " INTEGER " + "); \n"

            + " CREATE TABLE " + LearnedWords.TABLE_LEARNED_WORDS_NAME + " ("
            + LearnedWords._ID + " INTEGER PRIMARY KEY, " + LearnedWords.COLUMN_WORD_RU + " TEXT, "
            + LearnedWords.COLUMN_WORD_EN + " TEXT, " + LearnedWords.COLUMN_DATE + " DATE " + " )";

    public static String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TranslateTexts.TABLE_NEW_WORD_NAME
            + ", " + LearnedWords.COLUMN_DATE;

}
