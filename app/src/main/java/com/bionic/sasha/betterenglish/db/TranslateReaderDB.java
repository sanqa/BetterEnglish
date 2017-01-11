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

    public class DeseaseWords implements BaseColumns {
        public static final String TABLE_DESEASE_WORDS = "Болезни";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class EmotionsWords implements BaseColumns {
        public static final String TABLE_EMOTIONS_WORDS = "Эмоции";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";

    }

    public class WearsWords implements BaseColumns {
        public static final String TABLE_WEARS_WORDS = "Одежда";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class FoodWords implements BaseColumns {
        public static final String TABLE_FOOD_WORDS = "Еда";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class FurnitureWords implements BaseColumns {
        public static final String TABLE_FURNITURE_WORDS = "Мебель";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class FlagTable implements BaseColumns {
        public static final String TABLE_FLAG = "tableFlag";
        public static final String _ID = "tableid";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_FLAG = "flag";
    }


    public static String CREATE_ENTRIES = "CREATE TABLE "
            + TranslateTexts.TABLE_NEW_WORD_NAME + " (" + TranslateTexts._ID + " INTEGER PRIMARY KEY, "
            + TranslateTexts.COLUMN_WORD_EN + " TEXT, " + TranslateTexts.COLUMN_WORD_RU + " TEXT, "
            + TranslateTexts.COLUMN_MODE1 + " INTEGER, " + TranslateTexts.COLUMN_MODE2  + " INTEGER, "
            + TranslateTexts.COLUMN_MODE3 + " INTEGER, " + TranslateTexts.COLUMN_MODE4 + " INTEGER " + ")";

    public static String CT2 = "CREATE TABLE " + LearnedWords.TABLE_LEARNED_WORDS_NAME + " ("
            + LearnedWords._ID + " INTEGER PRIMARY KEY, " + LearnedWords.COLUMN_WORD_EN + " TEXT, "
            + LearnedWords.COLUMN_WORD_RU + " TEXT, " + LearnedWords.COLUMN_DATE + " DATE " + " )";



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

    public static String ce3 = "CREATE TABLE " + DeseaseWords.TABLE_DESEASE_WORDS + " ("
            + DeseaseWords._ID + " INTEGER PRIMARY KEY, " + DeseaseWords.COLUMN_WORD_EN + " TEXT, "
            + DeseaseWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr3 = {
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (1, 'ache', 'боль');",    // ache  —  боль
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (2, 'allergy', 'аллергия');",    // allergy  —  аллергия
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (3, 'asthma', 'астма');",    // asthma  —  астма
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (4, 'bandage', 'бинт');",    // bandage  —  бинт
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (5, 'blood pressure', 'артериальное давление');",    // blood pressure  —  артериальное давление
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (6, 'boil', 'нарыв');",    // boil  —  нарыв
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (7, 'bronchitis', 'бронхит');",    // bronchitis  —  бронхит
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (8, 'bruise', 'синяк');",    // bruise  —  синяк
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (9, 'burn', 'ожог');",    // burn  —  ожог
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (10, 'cancer', 'рак');",    // cancer  —  рак
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (11, 'catch a cold', 'простужаться');",    // catch a cold  —  простужаться
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (12, 'cold', 'простуда');",    // cold  —  простуда
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (13, 'contagious', 'заразный');",    // contagious  —  заразный
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (14, 'cough', 'кашель');",    // cough  —  кашель
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (15, 'crutch', 'костыль');",    // crutch  —  костыль
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (16, 'cure', 'лечение');",    // cure  —  лечение
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (17, 'cut', 'порез');",    // cut  —  порез
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (18, 'diagnosis', 'диагноз');",    // diagnosis  —  диагноз
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (19, 'diarrhea', 'диарея');",    // diarrhea  —  диарея
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (20, 'disease', 'болезнь');",    // disease  —  болезнь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (21, 'dose', 'доза');",    // dose  —  доза
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (22, 'drug', 'лекарственное средство');",    // drug  —  лекарственное средство
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (23, 'faint', 'падать в обморок');",    // faint  —  падать в обморок
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (24, 'fever', 'повышенная температура');",    // fever  —  повышенная температура
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (25, 'flu', 'грипп');",    // flu  —  грипп
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (26, 'fracture', 'перелом');",    // fracture  —  перелом
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (27, 'giddiness', 'головокружение');",    // giddiness  —  головокружение
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (28, 'headache', 'головная боль');",    // headache  —  головная боль
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (29, 'heart attack', 'сердечный приступ');",    // heart attack  —  сердечный приступ
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (30, 'illness', 'болезнь');",    // illness  —  болезнь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (31, 'immunity', 'иммунитет');",    // immunity  —  иммунитет
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (32, 'incurable disease', 'неизлечимая болезнь');",    // incurable disease  —  неизлечимая болезнь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (33, 'injection', 'укол');",    // injection  —  укол
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (34, 'injury', 'повреждение');",    // injury  —  повреждение
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (35, 'medicine', 'лекарство');",    // medicine  —  лекарство
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (36, 'nearsightedness', 'близорукость');",    // nearsightedness  —  близорукость
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (37, 'nervous breakdown', 'нервное расстройство');",    // nervous breakdown  —  нервное расстройство
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (38, 'ointment', 'мазь');",    // ointment  —  мазь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (39, 'operation', 'операция');",    // operation  —  операция
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (40, 'pain', 'боль');",    // pain  —  боль
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (41, 'painkiller', 'болеутоляющее средство');",    // painkiller  —  болеутоляющее средство
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (42, 'perspiration', 'потливость');",    // perspiration  —  потливость
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (43, 'pharmacy', 'аптека');",    // pharmacy  —  аптека
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (44, 'pill', 'таблетка');",    // pill  —  таблетка
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (45, 'pimple', 'прыщ');",    // pimple  —  прыщ
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (46, 'plaster', 'пластырь');",    // plaster  —  пластырь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (47, 'pulse', 'пульс');",    // pulse  —  пульс
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (48, 'pus', 'гной');",    // pus  —  гной
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (49, 'rash', 'сыпь');",    // rash  —  сыпь
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (50, 'recovery', 'выздоровление');",    // recovery  —  выздоровление
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (51, 'remedy', 'средство');",    // remedy  —  средство
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (52, 'sickness', 'тошнота');",    // sickness  —  тошнота
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (53, 'side-effect ', 'побочное действие');",    // side-effect  —  побочное действие
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (54, 'sore throat', 'больное горло');",    // sore throat  —  больное горло
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (55, 'stroke', 'инсульт');",    // stroke  —  инсульт
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (56, 'sunstroke', 'солнечный удар');",    // sunstroke  —  солнечный удар
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (57, 'surgery', 'хирургия');",    // surgery  —  хирургия
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (58, 'sweat', 'пот');",    // sweat  —  пот
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (59, 'symptom', 'симптом');",    // symptom  —  симптом
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (60, 'syringe', 'шприц');",    // syringe  —  шприц
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (61, 'therapy', 'терапия');",    // therapy  —  терапия
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (62, 'thermometer', 'термометр');",    // thermometer  —  термометр
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (63, 'toothache', 'зубная боль');",    // toothache  —  зубная боль
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (64, 'treatment', 'лечение');",    // treatment  —  лечение
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (65, 'ulcer', 'язва');",    // ulcer  —  язва
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (66, 'urine test', 'анализ мочи');",    // urine test  —  анализ мочи
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (67, 'wound', 'рана');",    // wound  —  рана
        "INSERT INTO " + DeseaseWords.TABLE_DESEASE_WORDS + " VALUES (68, 'x-ray', 'рентген');"   // x-ray  —  рентген
    };


    public static String ce4 = "CREATE TABLE " + EmotionsWords.TABLE_EMOTIONS_WORDS + " ("
            + EmotionsWords._ID + " INTEGER PRIMARY KEY, " + EmotionsWords.COLUMN_WORD_EN + " TEXT, "
            + EmotionsWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr4 = {
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", //         acceptance  —  одобрение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // adoration  —  обожание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // affection  —  привязанность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // ambition  —  честолюбие
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // anticipation  —  ожидание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // anxiety  —  беспокойство
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // apprehension  —  опасение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // attachment  —  верность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // attraction  —  привлекательность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // awe  —  страх
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // calm  —  спокойный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // capricious  —  капризный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // cheerful  —  весёлый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // concerned  —  встревоженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // confused  —  смущённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // curious  —  любопытный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // delightful  —  очаровательный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // dependent  —  подвластный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // deranged  —  ненормальный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // desperate  —  отчаянный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // eager  —  интенсивный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // embarrassed  —  смущённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // emotional  —  взволнованный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // energetic  —  энергичный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // enthusiastic  —  восторженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // envious  —  завистливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // euphoria  —  радостное настроение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // funny  —  смешной
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // generous  —  великодушный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // happy  —  счастливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // hopeful  —  надеющийся
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // horrible  —  ужасный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // impatient  —  нетерпеливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // jealous  —  ревнивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // jealousy  —  ревность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // kindhearted  —  добрый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // modesty  —  скромность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // mortified  —  оскорблённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // moved  —  растроганный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // pathetic  —  трогательный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // patient  —  терпеливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // ridiculous  —  нелепый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // self-conscious  —  застенчивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // senseless  —  бессмысленный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // sweet  —  милый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // temptation  —  искушение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // thrilled  —  потрясённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // twisted  —  искривлённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // uncomfortable  —  неудобный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // useful  —  полезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // useless  —  бесполезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // admiration  —  восхищение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // amorousness  —  влюблённость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // amusement  —  развлечения
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // annoy  —  надоедать
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // apathy  —  апатия
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // ashamed  —  пристыженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // bliss  —  счастье
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // bored  —  скучающий
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // brave heart  —  смельчак
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // caress  —  ласка
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // charming personality  —  харизматическая личность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // clever  —  умный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // desire  —  желание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // dignity  —  гордость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // disgustedly  —  с отвращением
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // dizzy  —  чувствующий головокружение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // elated by success  —  окрылённый успехом
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // frightened  —  испуганный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // fun  —  веселье
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // genuinely  —  искренне
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // good  —  хороший
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // hate  —  ненавидеть
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // healthy  —  здоровый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // helpful  —  полезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // helpless  —  беспомощный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // hope  —  надеяться
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // inspiration  —  вдохновение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // interest  —  интересовать
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // irritation  —  недовольство
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // joy  —  радость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // jubilation  —  ликование
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // lazy  —  ленивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // lightness  —  лёгкость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // longing  —  стремление
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // love  —  любить
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // melancholy  —  меланхоличный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // pain  —  боль
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // pity  —  жалость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // revulsion  —  антипатия
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // riot  —  восстание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // sadness  —  грусть
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // smirk  —  ухмыляться
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // suffering  —  страдание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // sympathy  —  сочувствие
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // thankful  —  благодарный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // troubled  —  беспокойный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // trust  —  доверять
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');", // witty remark  —  остроумное замечание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'A', 'B');" // worried  —  озабоченный
    };


    public static String ce5 = "CREATE TABLE " + FoodWords.TABLE_FOOD_WORDS + " ("
            + FoodWords._ID + " INTEGER PRIMARY KEY, " + FoodWords.COLUMN_WORD_EN + " TEXT, "
            + FoodWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr5 = {
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", //         apple  —  яблоко
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bar  —  бар
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bite  —  кусать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bitter  —  горький
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // boil  —  кипеть
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cake  —  торт
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // chocolate  —  шоколад
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // croissant  —  круассан
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // dinner  —  ужин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // fresh  —  свежий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // honey  —  мед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // hot  —  горячий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // lemon  —  лимон
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // napkin  —  салфетка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // rare  —  непрожаренный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // raw  —  сырой
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // rice  —  рис
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // salt  —  соль
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // salty  —  соленый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // slice  —  ломтик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // snack  —  лёгкая закуска
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sweet  —  сладкий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bacon  —  бекон
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // baguette  —  багет
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // baked  —  печеный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // banana  —  банан
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // barbecue  —  барбекю
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bean  —  фасоль
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // biscuit  —  печенье
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // bland  —  пресный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // boiled eggs  —  вареные яйца
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cabbage  —  капуста
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cafe  —  кафе
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // candy  —  конфета
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // carrot  —  морковь
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cereal  —  мюсли
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // chew  —  жевать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cooked  —  вареный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cooking  —  готовка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cornflakes  —  хлопья
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // cream  —  сливки
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // creamy  —  сливочный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // crisps  —  чипсы
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // dessert  —  десерт
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // doughnut  —  пончик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // for breakfast  —  на завтрак
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // fry  —  жарить
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // grape  —  виноград
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // grill  —  жарить на гриле
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // ham  —  ветчина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // have a bite  —  перекусить
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // ice  —  лед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // ketchup  —  кетчуп
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // kiwi  —  киви
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // lemonade  —  лимонад
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // liter  —  литр
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // loaf  —  буханка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // lump  —  кусок
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // lunch  —  обед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // marmalade  —  повидло
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // mayonnaise  —  майонез
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // meal  —  еда
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // menu  —  меню
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // milk  —  молоко
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // mushroom  —  гриб
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // nibble  —  откусывать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // orange  —  апельсин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pancake  —  блин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pasta  —  паста
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // peach  —  персик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pear  —  груша
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pizza  —  пицца
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // plum  —  слива
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // popcorn  —  попкорн
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pork  —  свинина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // potato  —  картофель
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // prawn  —  креветка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pub  —  паб
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // pudding  —  пудинг
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // ripe  —  спелый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // roast  —  запекать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // salad  —  салат
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // salami  —  салями
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // salmon  —  лосось
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sandwich  —  сэндвич
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sardine  —  сардина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sauce  —  соус
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // seafood  —  морепродукты
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // soda  —  газированная вода
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sorbet  —  щербет
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // soup  —  суп
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // sour  —  кислый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // spice  —  пряность
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // spicy  —  острый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // steak  —  стейк
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // stew  —  рагу
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // take a sip  —  прихлебнуть
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // toast  —  гренки
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // trout  —  форель
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'A', 'D');", // tuna  —  тунец
    };


    public static String ce6 = "CREATE TABLE " + WearsWords.TABLE_WEARS_WORDS + " ("
            + WearsWords._ID + " INTEGER PRIMARY KEY, " + WearsWords.COLUMN_WORD_EN + " TEXT, "
            + WearsWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr6 = {
        //         ankle boot  —  полусапожки
        // anorak  —  анорак
        // apron  —  фартук
        // army boots  —  армейские ботинки
        // ball gown  —  бальное платье
        // bandanna  —  бандана
        // baseball cap  —  бейсболка
        // bathing suit  —  купальный костюм
        // beach shoes  —  пляжная обувь
        // belt  —  ремень
        // Bermuda shorts  —  бермуды
        // blazer  —  блейзер
        // blouse  —  блузка
        // boots  —  ботинки
        // bow tie  —  галстук-бабочка
        // bowling shoes  —  обувь для боулинга
        // breeches  —  бриджи
        // brogues  —  броги
        // cardigan  —  кардиган
        // casual dress  —  повседневная одежда
        // chemise  —  женская сорочка
        // cloak  —  плащ
        // clothes  —  одежда
        // coat  —  пальто
        // costume  —  костюм
        // court shoes  —  туфли-лодочки
        // coveralls  —  комбинезон
        // cowboy boots  —  ковбойские сапоги
        // culottes  —  юбка-брюки
        // dinner jacket  —  смокинг
        // espadrilles  —  эспадрильи
        // evening gown  —  вечернее платье
        // fedora  —  мягкая фетровая шляпа
        // flip-flops  —  вьетнамки
        // garment  —  предмет одежды
        // golf shoes  —  туфли для гольфа
        // gown  —  платье
        // hat  —  шапка
        // hiking boots  —  треккинговые ботинки
        // hoodie  —  толстовка с капюшоном
        // housecoat  —  женский халат
        // jackboots  —  ботфорты
        // jersey  —  свитер
        // jumpsuit  —  спортивный костюм
        // kimono  —  кимоно
        // leather jacket  —  кожаный пиджак
        // leggings  —  лосины
        // miniskirt  —  мини-юбка
        // mittens  —  рукавицы
        // moccasins  —  мокасины
        // outerwear  —  верхняя одежда
        // oxfords  —  оксфорды
        // pinafore  —  сарафан
        // platform shoes  —  обувь на платформе
        // pleated skirt  —  юбка в складку
        // pointe shoes  —  пуанты
        // polo shirt  —  поло
        // poncho  —  пончо
        // pullover  —  пуловер
        // raincoat  —  плащ
        // riding boots  —  сапоги для верховой езды
        // scarf  —  шарф
        // shirt  —  рубашка
        // shoes  —  обувь
        // ski boots  —  лыжные ботинки
        // sneakers  —  кроссовки
        // stiletto heels  —  туфли на шпильках
        // stockings  —  женские чулки
        // sweatshirt  —  толстовка
        // T-shirt  —  футболка
        // tanktop  —  майка на лямках
        // tennis shoes  —  обувь для тенниса
        // trench coat  —  тренч
        // trousers  —  брюки
        // tunic  —  туника
        // turtleneck sweater  —  водолазка
        // tuxedo  —  смокинг
        // tweed jacket  —  твидовый пиджак
        // underwear  —  нижнее белье
        // wellington boots  —  резиновые сапоги
        // white tie  —  парадный костюм
        // beret  —  берет
        // bra  —  бюстгальтер
        // dress  —  платье
        // frock  —  платье
        // fur coat  —  шуба
        // gloves  —  перчатки
        // jacket  —  куртка
        // jeans  —  джинсы
        // nightgown  —  ночная рубашка
        // pajamas  —  пижама
        // pantyhose  —  колготки
        // running shoes  —  кроссовки
        // sandals  —  сандалии
        // shorts  —  шорты
        // skirt  —  юбка
        // slippers  —  тапочки
        // socks  —  носки
        // tie  —  галстук
        // waistcoat  —  жилет
    };

    public static String ce7 = "CREATE TABLE " + FurnitureWords.TABLE_FURNITURE_WORDS + " ("
            + FurnitureWords._ID + " INTEGER PRIMARY KEY, " + FurnitureWords.COLUMN_WORD_EN + " TEXT, "
            + FurnitureWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr7 = {
        //         armchair  —  кресло
        // armoire  —  шкаф
        // bar stool  —  барный стул
        // beach chair  —  шезлонг
        // bed  —  кровать
        // bench  —  скамья
        // bentwood rocker  —  кресло-качалка
        // blinds  —  жалюзи
        // bookcase  —  книжный шкаф
        // bookshelf  —  книжная полка
        // buffet  —  буфет
        // bunk bed  —  двухъярусная кровать
        // bureau  —  письменный стол
        // cabinet  —  мебельная горка
        // canopy bed  —  кровать с балдахином
        // card table  —  карточный стол
        // carpet  —  ковер
        // chair  —  стул
        // chaise longue  —  кушетка
        // chandelier  —  люстра
        // chest  —  ящик
        // chest of drawers  —  комод
        // clock  —  часы
        // coffee table  —  кофейный столик
        // console  —  шкафчик
        // cot  —  детская кроватка
        // couch  —  диван
        // cradle  —  колыбель
        // cupboard  —  шкаф
        // curio  —  антикварная вещь
        // curtains  —  шторы
        // cushion  —  диванная подушка
        // desk  —  письменный стол
        // dining room table  —  обеденный стол
        // display cabinet  —  шкаф-витрина
        // divan  —  тахта
        // door  —  дверь
        // double bed  —  двуспальная кровать
        // drapery  —  портьера
        // dresser  —  туалетный столик
        // easel  —  мольберт
        // easy chair  —  удобное кресло
        // escritoire  —  секретер
        // fireplace  —  камин
        // folding chair  —  складной стул
        // footrest  —  подставка для ног
        // footstool  —  скамеечка для ног
        // four-poster bed  —  кровать с балдахином
        // furnishings  —  предметы обстановки
        // furniture  —  мебель
        // futon  —  хлопчатобумажный матрац
        // garden bench  —  садовая скамейка
        // gas-stove  —  газовая плита
        // gateleg table  —  стол-тумба
        // grandfather clock  —  дедушкины часы
        // hammock  —  гамак
        // hassock  —  подушечка
        // hat stand  —  вешалка для шляп
        // headboard  —  изголовье кровати
        // highchair  —  высокий стул
        // hope chest  —  сундук с приданым
        // hutch  —  ящик для вещей
        // ironing board  —  гладильная доска
        // lamp  —  лампа
        // light  —  свет
        // lintel  —  перемычка
        // mattress  —  тюфяк
        // mirror  —  зеркало
        // nightstand  —  тумбочка
        // office chair  —  офисный стул
        // ottoman  —  тахта
        // pantry  —  кладовая
        // park bench  —  скамейке в парке
        // picnic table  —  стол для пикника
        // pillow  —  подушка
        // rocking chair  —  кресло-качалка
        // room divider  —  комнатная перегородка
        // rug  —  ковер
        // sconce  —  бра
        // screen  —  экран
        // seat  —  сиденье
        // settee  —  небольшой диван
        // shelf  —  полка
        // sideboard  —  сервант
        // sofa  —  диван
        // sofabed  —  диван-кровать
        // staircase  —  лестница
        // stool  —  стул
        // strongbox  —  сейф
        // swings  —  качели
        // swivel chair  —  вращающийся стул
        // table  —  стол
        // truckle bed  —  выдвижная кровать
        // tuffet  —  табурет
        // wardrobe  —  гардероб
        // waste basket  —  корзина для мусора
        // window shades  —  шторы
        // windsor chair  —  виндзорское кресло
        // work table  —  рабочий стол
        // writing desk  —  письменный стол
    };

    public static String ce8 = "CREATE TABLE " + FlagTable.TABLE_FLAG + " ("
            + FlagTable._ID + " INTEGER PRIMARY KEY, " + FlagTable.COLUMN_NAME + " TEXT, "
            + FlagTable.COLUMN_FLAG + " TEXT " + " )";

    public static String[] arr8 = {
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (1, '" + EmotionsWords.TABLE_EMOTIONS_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (2, '" + FoodWords.TABLE_FOOD_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (3, '" + FurnitureWords.TABLE_FURNITURE_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (4, '" + DeseaseWords.TABLE_DESEASE_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (5, '" + WearsWords.TABLE_WEARS_WORDS + "', '1');",
    };


    public static String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TranslateTexts.TABLE_NEW_WORD_NAME;
    public static String DE2 = "DROP TABLE IF EXISTS " + LearnedWords.TABLE_LEARNED_WORDS_NAME;
    public static String DE3 = "DROP TABLE IF EXISTS " + DeseaseWords.TABLE_DESEASE_WORDS;
    public static String DE4 = "DROP TABLE IF EXISTS " + FoodWords.TABLE_FOOD_WORDS;
    public static String DE5 = "DROP TABLE IF EXISTS " + FurnitureWords.TABLE_FURNITURE_WORDS;
    public static String DE6 = "DROP TABLE IF EXISTS " + EmotionsWords.TABLE_EMOTIONS_WORDS;
    public static String DE7 = "DROP TABLE IF EXISTS " + WearsWords.TABLE_WEARS_WORDS;
    public static String DE8 = "DROP TABLE IF EXISTS " + FlagTable.TABLE_FLAG;


}
