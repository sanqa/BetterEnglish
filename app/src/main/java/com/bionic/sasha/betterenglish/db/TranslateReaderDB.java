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

    public class ArrayWords implements BaseColumns {
        public static final String TABLE_ARRAY_WORDS = "arrayWords";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }


    public static String CREATE_ENTRIES = "CREATE TABLE "
            + TranslateTexts.TABLE_NEW_WORD_NAME + " (" + TranslateTexts._ID + " INTEGER PRIMARY KEY, "
            + TranslateTexts.COLUMN_WORD_RU + " TEXT, " + TranslateTexts.COLUMN_WORD_EN + " TEXT, "
            + TranslateTexts.COLUMN_MODE1 + " INTEGER, " + TranslateTexts.COLUMN_MODE2  + " INTEGER, "
            + TranslateTexts.COLUMN_MODE3 + " INTEGER, " + TranslateTexts.COLUMN_MODE4 + " INTEGER " + ")";

    public static String CT2 = "CREATE TABLE " + LearnedWords.TABLE_LEARNED_WORDS_NAME + " ("
            + LearnedWords._ID + " INTEGER PRIMARY KEY, " + LearnedWords.COLUMN_WORD_RU + " TEXT, "
            + LearnedWords.COLUMN_WORD_EN + " TEXT, " + LearnedWords.COLUMN_DATE + " DATE " + " )";

    public static String ce3 = "CREATE TABLE " + ArrayWords.TABLE_ARRAY_WORDS + " ("
            + ArrayWords._ID + " INTEGER PRIMARY KEY, " + ArrayWords.COLUMN_WORD_RU + " TEXT, "
            + ArrayWords.COLUMN_WORD_EN + " TEXT " + " )";

    public static String[] arr = {
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (1, 'accuse', 'обвинять');",//accuse — обвинять
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (2, 'admire', 'восхищаться');",//admire — восхищаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (3, 'adore', 'обожать');",//adore — обожать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (4, 'agitate', 'волновать');",//agitate — волновать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (5, 'be angry', 'быть сердитым');",//be angry — быть сердитым
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (6, 'be impudent', 'быть нахальным');",//be impudent — быть нахальным
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (7, 'be insolent', 'быть наглым');",//be insolent — быть наглым
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (8, 'be lazy', 'лениться');",//be lazy — лениться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (9, 'be modest', 'скромничать');",//be modest — скромничать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (10, 'be proud', 'гордиться');",//be proud — гордиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (11, 'be shy', 'робеть');",//be shy — робеть
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (12, 'be sure', 'быть уверенным');",//be sure — быть уверенным
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (13, 'be tired', 'уставать');",//be tired — уставать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (14, 'bear', 'вынести');",//bear — вынести
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (15, 'believe', 'верить');",//believe — верить
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (16, 'boast', 'хвастаться');",//boast — хвастаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (17, 'calm down', 'успокоиться');",//calm down — успокоиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (18, 'care', 'заботиться');",//care — заботиться//
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (19, 'comfort', 'утешать');",//comfort — утешать//
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (20, 'complain', 'жаловаться');",//complain — жаловаться//
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (21, 'cry', 'плакать');",//cry — плакать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (22, 'dislike', 'не нравиться');",//dislike — не нравиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (23, 'disregard', 'не обращать внимания');",//disregard — не обращать внимания
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (24, 'doubt', 'сомневаться');",//doubt — сомневаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (25, 'endure', 'терпеть');",//endure — терпеть
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (26, 'enjoy', 'наслаждаться');",//enjoy — наслаждаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (27, 'envy', 'завидовать');",//envy — завидовать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (28, 'esteem', 'ценить');",//esteem — ценить
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (29, 'excite', 'возбуждать');",//excite — возбуждать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (30, 'fall in love', 'влюбиться');",//fall in love — влюбиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (31, 'fear', 'бояться');",//fear — бояться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (32, 'feel', 'чувствовать');",//feel — чувствовать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (33, 'frighten', 'пугать');",//frighten — пугать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (34, 'get tired', 'уставать');",//get tired — уставать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (35, 'give up', 'сдаваться');",//give up — сдаваться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (36, 'hate', 'ненавидеть');",//hate — ненавидеть
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (37, 'hesitate', 'колебаться');",//hesitate — колебаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (38, 'hope', 'надеяться');",//hope — надеяться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (39, 'hurt', 'обижать');",//hurt — обижать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (40, 'laugh', 'смеяться');",//laugh — смеяться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (41, 'like', 'нравиться');",//like — нравиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (42, 'love', 'любить');",//love — любить
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (43, 'move', 'глубоко тронуть');",//move — глубоко тронуть
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (44, 'neglect', 'не заботиться');",//neglect — не заботиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (45, 'offend', 'оскорблять');",//offend — оскорблять
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (46, 'praise', 'хвалить');",//praise — хвалить
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (47, 'prefer', 'предпочитать');",//prefer — предпочитать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (48, 'put on airs', 'зазнаваться');",//put on airs — зазнаваться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (49, 'quarrel', 'ссориться');",//quarrel — ссориться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (50, 'rejoice', 'радоваться');",//rejoice — радоваться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (51, 'rely', 'полагаться');",//rely — полагаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (52, 'reproach', 'упрекать');",//reproach — упрекать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (53, 'respect', 'уважать');",//respect — уважать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (54, 'scold', 'бранить');",//scold — бранить
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (55, 'shirk', 'увиливать');",//shirk — увиливать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (56, 'smile', 'улыбаться');",//smile — улыбаться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (57, 'stand', 'выстоять');",//stand — выстоять
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (58, 'suffer', 'страдать');",//suffer — страдать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (59, 'surprise', 'удивлять');",//surprise — удивлять
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (60, 'surrender', 'капитулировать');",//surrender — капитулировать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (61, 'suspect', 'подозревать');",//suspect — подозревать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (62, 'weep', 'рыдать');",//weep — рыдать
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (63, 'worry', 'беспокоиться');",//worry — беспокоиться
            "INSERT INTO " + ArrayWords.TABLE_ARRAY_WORDS + " VALUES (64, 'wound', 'ранить');"//wound — ранить

    };



    public static String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TranslateTexts.TABLE_NEW_WORD_NAME;
    public static String DE2 = "DROP TABLE IF EXISTS " + LearnedWords.TABLE_LEARNED_WORDS_NAME;
    public static String DE3 = "DROP TABLE IF EXISTS " + ArrayWords.TABLE_ARRAY_WORDS;


}
