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
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (1, 'accuse', 'обвинять', 0, 0, 0, 0);",//accuse — обвинять
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (2, 'admire', 'восхищаться', 0, 0, 0, 0);",//admire — восхищаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (3, 'adore', 'обожать', 0, 0, 0, 0);",//adore — обожать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (4, 'agitate', 'волновать', 0, 0, 0, 0);",//agitate — волновать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (5, 'be angry', 'быть сердитым', 0, 0, 0, 0);",//be angry — быть сердитым
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (6, 'be impudent', 'быть нахальным', 0, 0, 0, 0);",//be impudent — быть нахальным
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (7, 'be insolent', 'быть наглым', 0, 0, 0, 0);",//be insolent — быть наглым
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (8, 'be lazy', 'лениться', 0, 0, 0, 0);",//be lazy — лениться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (9, 'be modest', 'скромничать', 0, 0, 0, 0);",//be modest — скромничать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (10, 'be proud', 'гордиться', 0, 0, 0, 0);",//be proud — гордиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (11, 'be shy', 'робеть', 0, 0, 0, 0);",//be shy — робеть
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (12, 'be sure', 'быть уверенным', 0, 0, 0, 0);",//be sure — быть уверенным
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (13, 'be tired', 'уставать', 0, 0, 0, 0);",//be tired — уставать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (14, 'bear', 'вынести', 0, 0, 0, 0);",//bear — вынести
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (15, 'believe', 'верить', 0, 0, 0, 0);",//believe — верить
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (16, 'boast', 'хвастаться', 0, 0, 0, 0);",//boast — хвастаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (17, 'calm down', 'успокоиться', 0, 0, 0, 0);",//calm down — успокоиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (18, 'care', 'заботиться', 0, 0, 0, 0);",//care — заботиться//
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (19, 'comfort', 'утешать', 0, 0, 0, 0);",//comfort — утешать//
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (20, 'complain', 'жаловаться', 0, 0, 0, 0);",//complain — жаловаться//
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (21, 'cry', 'плакать', 0, 0, 0, 0);",//cry — плакать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (22, 'dislike', 'не нравиться', 0, 0, 0, 0);",//dislike — не нравиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (23, 'disregard', 'не обращать внимания', 0, 0, 0, 0);",//disregard — не обращать внимания
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (24, 'doubt', 'сомневаться', 0, 0, 0, 0);",//doubt — сомневаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (25, 'endure', 'терпеть', 0, 0, 0, 0);",//endure — терпеть
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (26, 'enjoy', 'наслаждаться', 0, 0, 0, 0);",//enjoy — наслаждаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (27, 'envy', 'завидовать', 0, 0, 0, 0);",//envy — завидовать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (28, 'esteem', 'ценить', 0, 0, 0, 0);",//esteem — ценить
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (29, 'excite', 'возбуждать', 0, 0, 0, 0);",//excite — возбуждать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (30, 'fall in love', 'влюбиться', 0, 0, 0, 0);",//fall in love — влюбиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (31, 'fear', 'бояться', 0, 0, 0, 0);",//fear — бояться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (32, 'feel', 'чувствовать', 0, 0, 0, 0);",//feel — чувствовать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (33, 'frighten', 'пугать', 0, 0, 0, 0);",//frighten — пугать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (34, 'get tired', 'уставать', 0, 0, 0, 0);",//get tired — уставать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (35, 'give up', 'сдаваться', 0, 0, 0, 0);",//give up — сдаваться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (36, 'hate', 'ненавидеть', 0, 0, 0, 0);",//hate — ненавидеть
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (37, 'hesitate', 'колебаться', 0, 0, 0, 0);",//hesitate — колебаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (38, 'hope', 'надеяться', 0, 0, 0, 0);",//hope — надеяться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (39, 'hurt', 'обижать', 0, 0, 0, 0);",//hurt — обижать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (40, 'laugh', 'смеяться', 0, 0, 0, 0);",//laugh — смеяться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (41, 'like', 'нравиться', 0, 0, 0, 0);",//like — нравиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (42, 'love', 'любить', 0, 0, 0, 0);",//love — любить
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (43, 'move', 'глубоко тронуть', 0, 0, 0, 0);",//move — глубоко тронуть
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (44, 'neglect', 'не заботиться', 0, 0, 0, 0);",//neglect — не заботиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (45, 'offend', 'оскорблять', 0, 0, 0, 0);",//offend — оскорблять
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (46, 'praise', 'хвалить', 0, 0, 0, 0);",//praise — хвалить
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (47, 'prefer', 'предпочитать', 0, 0, 0, 0);",//prefer — предпочитать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (48, 'put on airs', 'зазнаваться', 0, 0, 0, 0);",//put on airs — зазнаваться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (49, 'quarrel', 'ссориться', 0, 0, 0, 0);",//quarrel — ссориться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (50, 'rejoice', 'радоваться', 0, 0, 0, 0);",//rejoice — радоваться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (51, 'rely', 'полагаться', 0, 0, 0, 0);",//rely — полагаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (52, 'reproach', 'упрекать', 0, 0, 0, 0);",//reproach — упрекать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (53, 'respect', 'уважать', 0, 0, 0, 0);",//respect — уважать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (54, 'scold', 'бранить', 0, 0, 0, 0);",//scold — бранить
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (55, 'shirk', 'увиливать', 0, 0, 0, 0);",//shirk — увиливать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (56, 'smile', 'улыбаться', 0, 0, 0, 0);",//smile — улыбаться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (57, 'stand', 'выстоять', 0, 0, 0, 0);",//stand — выстоять
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (58, 'suffer', 'страдать', 0, 0, 0, 0);",//suffer — страдать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (59, 'surprise', 'удивлять', 0, 0, 0, 0);",//surprise — удивлять
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (60, 'surrender', 'капитулировать', 0, 0, 0, 0);",//surrender — капитулировать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (61, 'suspect', 'подозревать', 0, 0, 0, 0);",//suspect — подозревать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (62, 'weep', 'рыдать', 0, 0, 0, 0);",//weep — рыдать
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (63, 'worry', 'беспокоиться', 0, 0, 0, 0);",//worry — беспокоиться
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (64, 'wound', 'ранить', 0, 0, 0, 0);"//wound — ранить

    };



    public static String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TranslateTexts.TABLE_NEW_WORD_NAME;
    public static String DE2 = "DROP TABLE IF EXISTS " + LearnedWords.TABLE_LEARNED_WORDS_NAME;
    public static String DE3 = "DROP TABLE IF EXISTS " + ArrayWords.TABLE_ARRAY_WORDS;


}
