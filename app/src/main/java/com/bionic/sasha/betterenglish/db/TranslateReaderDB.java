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

    public class DiseaseWords implements BaseColumns {
        public static final String TABLE_DESEASE_WORDS = "Diseases";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class EmotionsWords implements BaseColumns {
        public static final String TABLE_EMOTIONS_WORDS = "Emotions";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";

    }

    public class WearsWords implements BaseColumns {
        public static final String TABLE_WEARS_WORDS = "Clothes";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class FoodWords implements BaseColumns {
        public static final String TABLE_FOOD_WORDS = "Food";
        public static final String _ID = "awordsid";
        public static final String COLUMN_WORD_RU = "wordru";
        public static final String COLUMN_WORD_EN = "worden";
    }

    public class FurnitureWords implements BaseColumns {
        public static final String TABLE_FURNITURE_WORDS = "Furniture";
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
            "INSERT INTO " + TranslateTexts.TABLE_NEW_WORD_NAME + " VALUES (34, 'solaсe', 'успокаивать', 0, 0, 0, 0);",//solaсe — успокаивать
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

    public static String ce3 = "CREATE TABLE " + DiseaseWords.TABLE_DESEASE_WORDS + " ("
            + DiseaseWords._ID + " INTEGER PRIMARY KEY, " + DiseaseWords.COLUMN_WORD_EN + " TEXT, "
            + DiseaseWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr3 = {
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (1, 'ache', 'боль');",    // ache  —  боль
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (2, 'allergy', 'аллергия');",    // allergy  —  аллергия
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (3, 'asthma', 'астма');",    // asthma  —  астма
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (4, 'bandage', 'бинт');",    // bandage  —  бинт
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (5, 'blood pressure', 'артериальное давление');",    // blood pressure  —  артериальное давление
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (6, 'boil', 'нарыв');",    // boil  —  нарыв
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (7, 'bronchitis', 'бронхит');",    // bronchitis  —  бронхит
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (8, 'bruise', 'синяк');",    // bruise  —  синяк
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (9, 'burn', 'ожог');",    // burn  —  ожог
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (10, 'cancer', 'рак');",    // cancer  —  рак
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (11, 'catch a cold', 'простужаться');",    // catch a cold  —  простужаться
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (12, 'cold', 'простуда');",    // cold  —  простуда
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (13, 'contagious', 'заразный');",    // contagious  —  заразный
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (14, 'cough', 'кашель');",    // cough  —  кашель
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (15, 'crutch', 'костыль');",    // crutch  —  костыль
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (16, 'cure', 'лечение');",    // cure  —  лечение
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (17, 'cut', 'порез');",    // cut  —  порез
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (18, 'diagnosis', 'диагноз');",    // diagnosis  —  диагноз
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (19, 'diarrhea', 'диарея');",    // diarrhea  —  диарея
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (20, 'disease', 'болезнь');",    // disease  —  болезнь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (21, 'dose', 'доза');",    // dose  —  доза
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (22, 'drug', 'лекарственное средство');",    // drug  —  лекарственное средство
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (23, 'faint', 'падать в обморок');",    // faint  —  падать в обморок
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (24, 'fever', 'повышенная температура');",    // fever  —  повышенная температура
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (25, 'flu', 'грипп');",    // flu  —  грипп
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (26, 'fracture', 'перелом');",    // fracture  —  перелом
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (27, 'giddiness', 'головокружение');",    // giddiness  —  головокружение
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (28, 'headache', 'головная боль');",    // headache  —  головная боль
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (29, 'heart attack', 'сердечный приступ');",    // heart attack  —  сердечный приступ
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (30, 'illness', 'болезнь');",    // illness  —  болезнь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (31, 'immunity', 'иммунитет');",    // immunity  —  иммунитет
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (32, 'incurable disease', 'неизлечимая болезнь');",    // incurable disease  —  неизлечимая болезнь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (33, 'injection', 'укол');",    // injection  —  укол
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (34, 'injury', 'повреждение');",    // injury  —  повреждение
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (35, 'medicine', 'лекарство');",    // medicine  —  лекарство
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (36, 'nearsightedness', 'близорукость');",    // nearsightedness  —  близорукость
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (37, 'nervous breakdown', 'нервное расстройство');",    // nervous breakdown  —  нервное расстройство
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (38, 'ointment', 'мазь');",    // ointment  —  мазь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (39, 'operation', 'операция');",    // operation  —  операция
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (40, 'pain', 'боль');",    // pain  —  боль
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (41, 'painkiller', 'болеутоляющее средство');",    // painkiller  —  болеутоляющее средство
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (42, 'perspiration', 'потливость');",    // perspiration  —  потливость
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (43, 'pharmacy', 'аптека');",    // pharmacy  —  аптека
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (44, 'pill', 'таблетка');",    // pill  —  таблетка
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (45, 'pimple', 'прыщ');",    // pimple  —  прыщ
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (46, 'plaster', 'пластырь');",    // plaster  —  пластырь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (47, 'pulse', 'пульс');",    // pulse  —  пульс
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (48, 'pus', 'гной');",    // pus  —  гной
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (49, 'rash', 'сыпь');",    // rash  —  сыпь
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (50, 'recovery', 'выздоровление');",    // recovery  —  выздоровление
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (51, 'remedy', 'средство');",    // remedy  —  средство
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (52, 'sickness', 'тошнота');",    // sickness  —  тошнота
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (53, 'side-effect ', 'побочное действие');",    // side-effect  —  побочное действие
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (54, 'sore throat', 'больное горло');",    // sore throat  —  больное горло
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (55, 'stroke', 'инсульт');",    // stroke  —  инсульт
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (56, 'sunstroke', 'солнечный удар');",    // sunstroke  —  солнечный удар
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (57, 'surgery', 'хирургия');",    // surgery  —  хирургия
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (58, 'sweat', 'пот');",    // sweat  —  пот
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (59, 'symptom', 'симптом');",    // symptom  —  симптом
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (60, 'syringe', 'шприц');",    // syringe  —  шприц
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (61, 'therapy', 'терапия');",    // therapy  —  терапия
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (62, 'thermometer', 'термометр');",    // thermometer  —  термометр
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (63, 'toothache', 'зубная боль');",    // toothache  —  зубная боль
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (64, 'treatment', 'лечение');",    // treatment  —  лечение
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (65, 'ulcer', 'язва');",    // ulcer  —  язва
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (66, 'urine test', 'анализ мочи');",    // urine test  —  анализ мочи
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (67, 'wound', 'рана');",    // wound  —  рана
        "INSERT INTO " + DiseaseWords.TABLE_DESEASE_WORDS + " VALUES (68, 'x-ray', 'рентген');"   // x-ray  —  рентген
    };


    public static String ce4 = "CREATE TABLE " + EmotionsWords.TABLE_EMOTIONS_WORDS + " ("
            + EmotionsWords._ID + " INTEGER PRIMARY KEY, " + EmotionsWords.COLUMN_WORD_EN + " TEXT, "
            + EmotionsWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr4 = {
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (1, 'acceptance', 'одобрение');", //         acceptance  —  одобрение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (2, 'adoration', 'обожание');", // adoration  —  обожание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (3, 'affection', 'привязанность');", // affection  —  привязанность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (4, 'ambition', 'честолюбие');", // ambition  —  честолюбие
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (5, 'anticipation', 'ожидание');", // anticipation  —  ожидание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (6, 'anxiety', 'беспокойство');", // anxiety  —  беспокойство
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (7, 'apprehension', 'опасение');", // apprehension  —  опасение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (8, 'attachment', 'верность');", // attachment  —  верность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (9, 'attraction', 'привлекательность');", // attraction  —  привлекательность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (10, 'awe', 'страх');", // awe  —  страх
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (11, 'calm', 'спокойный');", // calm  —  спокойный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (12, 'capricious', 'капризный');", // capricious  —  капризный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (13, 'cheerful', 'весёлый');", // cheerful  —  весёлый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (14, 'concerned', 'встревоженный');", // concerned  —  встревоженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (15, 'confused', 'смущённый');", // confused  —  смущённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (16, 'curious', 'любопытный');", // curious  —  любопытный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (17, 'delightful', 'очаровательный');", // delightful  —  очаровательный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (18, 'dependent', 'подвластный');", // dependent  —  подвластный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (19, 'deranged', 'ненормальный');", // deranged  —  ненормальный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (20, 'desperate', 'отчаянный');", // desperate  —  отчаянный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (21, 'eager', 'интенсивный');", // eager  —  интенсивный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (22, 'embarrassed', 'смущённый');", // embarrassed  —  смущённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (23, 'emotional', 'взволнованный');", // emotional  —  взволнованный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (24, 'energetic', 'энергичный');", // energetic  —  энергичный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (25, 'enthusiastic', 'восторженный');", // enthusiastic  —  восторженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (26, 'envious', 'завистливый');", // envious  —  завистливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (27, 'euphoria', 'радостное настроение');", // euphoria  —  радостное настроение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (28, 'funny', 'смешной');", // funny  —  смешной
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (29, 'generous', 'великодушный');", // generous  —  великодушный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (30, 'happy', 'счастливый');", // happy  —  счастливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (31, 'hopeful', 'надеющийся');", // hopeful  —  надеющийся
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (32, 'horrible', 'ужасный');", // horrible  —  ужасный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (33, 'impatient', 'нетерпеливый');", // impatient  —  нетерпеливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (34, 'jealous', 'ревнивый');", // jealous  —  ревнивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (35, 'jealousy', 'ревность');", // jealousy  —  ревность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (36, 'kindhearted', 'добрый');", // kindhearted  —  добрый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (37, 'modesty', 'скромность');", // modesty  —  скромность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (38, 'mortified', 'оскорблённый');", // mortified  —  оскорблённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (39, 'moved', 'растроганный');", // moved  —  растроганный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (40, 'pathetic', 'трогательный');", // pathetic  —  трогательный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (41, 'patient', 'терпеливый');", // patient  —  терпеливый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (42, 'ridiculous', 'нелепый');", // ridiculous  —  нелепый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (43, 'self-conscious', 'застенчивый');", // self-conscious  —  застенчивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (44, 'senseless', 'бессмысленный');", // senseless  —  бессмысленный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (45, 'sweet', 'милый');", // sweet  —  милый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (46, 'temptation', 'искушение');", // temptation  —  искушение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (47, 'thrilled', 'потрясённый');", // thrilled  —  потрясённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (48, 'twisted', 'искривлённый');", // twisted  —  искривлённый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (49, 'uncomfortable', 'неудобный');", // uncomfortable  —  неудобный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (50, 'useful', 'полезный');", // useful  —  полезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (51, 'useless', 'бесполезный');", // useless  —  бесполезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (52, 'admiration', 'восхищение');", // admiration  —  восхищение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (53, 'amorousness', 'влюблённость');", // amorousness  —  влюблённость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (54, 'amusement', 'развлечения');", // amusement  —  развлечения
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (55, 'annoy', 'надоедать');", // annoy  —  надоедать
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (56, 'apathy', 'апатия');", // apathy  —  апатия
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (57, 'ashamed', 'пристыженный');", // ashamed  —  пристыженный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (58, 'bliss', 'счастье');", // bliss  —  счастье
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (59, 'bored', 'скучающий');", // bored  —  скучающий
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (60, 'brave heart', 'смельчак');", // brave heart  —  смельчак
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (61, 'caress', 'ласка');", // caress  —  ласка
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (62, 'charming personality', 'харизматическая личность');", // charming personality  —  харизматическая личность
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (63, 'clever', 'умный');", // clever  —  умный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (64, 'desire', 'желание');", // desire  —  желание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (65, 'dignity', 'гордость');", // dignity  —  гордость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (66, 'disgustedly', 'с отвращением');", // disgustedly  —  с отвращением
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (67, 'dizzy', 'чувствующий головокружение');", // dizzy  —  чувствующий головокружение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (68, 'elated by success', 'окрылённый успехом');", // elated by success  —  окрылённый успехом
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (69, 'frightened', 'испуганный');", // frightened  —  испуганный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (70, 'fun', 'веселье');", // fun  —  веселье
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (71, 'genuinely', 'искренне');", // genuinely  —  искренне
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (72, 'good', 'хороший');", // good  —  хороший
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (73, 'hate', 'ненавидеть');", // hate  —  ненавидеть
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (74, 'healthy', 'здоровый');", // healthy  —  здоровый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (75, 'helpful', 'полезный');", // helpful  —  полезный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (76, 'helpless', 'беспомощный');", // helpless  —  беспомощный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (77, 'hope', 'надеяться');", // hope  —  надеяться
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (78, 'inspiration', 'вдохновение');", // inspiration  —  вдохновение
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (79, 'interest', 'интересовать');", // interest  —  интересовать
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (80, 'irritation', 'недовольство');", // irritation  —  недовольство
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (81, 'joy', 'радость');", // joy  —  радость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (82, 'jubilation', 'ликование');", // jubilation  —  ликование
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (83, 'lazy', 'ленивый');", // lazy  —  ленивый
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (84, 'lightness', 'лёгкость');", // lightness  —  лёгкость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (85, 'longing', 'стремление');", // longing  —  стремление
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (86, 'love', 'любить');", // love  —  любить
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (87, 'melancholy', 'меланхоличный');", // melancholy  —  меланхоличный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (88, 'pain', 'боль');", // pain  —  боль
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (89, 'pity', 'жалость');", // pity  —  жалость
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (90, 'revulsion', 'антипатия');", // revulsion  —  антипатия
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (91, 'riot', 'восстание');", // riot  —  восстание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (92, 'sadness', 'грусть');", // sadness  —  грусть
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (93, 'smirk', 'ухмыляться');", // smirk  —  ухмыляться
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (94, 'suffering', 'страдание');", // suffering  —  страдание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (95, 'sympathy', 'сочувствие');", // sympathy  —  сочувствие
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (96, 'thankful', 'благодарный');", // thankful  —  благодарный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (97, 'troubled', 'беспокойный');", // troubled  —  беспокойный
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (98, 'trust', 'доверять');", // trust  —  доверять
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (99, 'witty remark', 'остроумное замечание');", // witty remark  —  остроумное замечание
        "INSERT INTO " + EmotionsWords.TABLE_EMOTIONS_WORDS + " VALUES (100, 'worried', 'озабоченный');" // worried  —  озабоченный
    };


    public static String ce5 = "CREATE TABLE " + FoodWords.TABLE_FOOD_WORDS + " ("
            + FoodWords._ID + " INTEGER PRIMARY KEY, " + FoodWords.COLUMN_WORD_EN + " TEXT, "
            + FoodWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr5 = {
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (1, 'apple', 'яблоко');", //apple  —      яблоко
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (2, 'bar', 'бар');", // bar  —       бар
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (3, 'bite', 'кусать');", // bite  —      кусать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (4, 'bitter', 'горький');", // bitter  —    горький
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (5, 'boil', 'кипеть');", // boil  —      кипеть
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (6, 'cake', 'торт');", // cake  —      торт
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (7, 'chocolate', 'шоколад');", // chocolate  — шоколад
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (8, 'croissant', 'круассан');", // croissant  — круассан
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (9, 'dinner', 'ужин');", // dinner  —    ужин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (10, 'fresh', 'свежий');", // fresh  —     свежий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (11, 'honey', 'мед');", // honey  —     мед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (12, 'hot', 'горячий');", // hot  —       горячий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (13, 'lemon', 'лимон');", // lemon  —     лимон
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (14, 'napkin', 'салфетка');", // napkin  —    салфетка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (15, 'rare', 'непрожаренный');", // rare  —      непрожаренный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (16, 'raw', 'сырой');", // raw  —       сырой
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (17, 'rice', 'рис');", // rice  —      рис
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (18, 'salt', 'соль');", // salt  —      соль
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (19, 'salty', 'соленый');", // salty  —     соленый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (20, 'slice', 'ломтик');", // slice  —     ломтик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (21, 'snack', 'лёгкая закуска');", // snack  —     лёгкая закуска
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (22, 'sweet', 'сладкий');", // sweet  —     сладкий
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (23, 'bacon', 'бекон');", // bacon  —     бекон
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (24, 'baguette', 'багет');", // baguette  —  багет
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (25, 'baked', 'печеный');", // baked  —     печеный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (26, 'banana', 'банан');", // banana  —    банан
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (27, 'barbecue', 'барбекю');", // barbecue  —  барбекю
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (28, 'bean', 'фасоль');", // bean  —      фасоль
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (29, 'biscuit', 'печенье');", // biscuit  —   печенье
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (30, 'bland', 'пресный');", // bland  —     пресный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (31, 'boiled eggs', 'вареные яйца');", // boiled eggs   вареные яйца
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (32, 'cabbage', 'капуста');", // cabbage  —   капуста
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (33, 'cafe', 'кафе');", // cafe  —      кафе
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (34, 'candy', 'конфета');", // candy  —     конфета
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (35, 'carrot', 'морковь');", // carrot  —    морковь
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (36, 'cereal', 'мюсли');", // cereal  —    мюсли
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (37, 'chew', 'жевать');", // chew  —      жевать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (38, 'cooked', 'вареный');", // cooked  —    вареный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (39, 'cooking', 'готовка');", // cooking  —   готовка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (40, 'cornflakes', 'хлопья');", // cornflakes  —хлопья
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (41, 'cream', 'сливки');", // cream  —     сливки
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (42, 'creamy', 'сливочный');", // creamy  —    сливочный
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (43, 'crisps', 'чипсы');", // crisps  —    чипсы
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (44, 'dessert', 'десерт');", // dessert  —   десерт
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (45, 'doughnut', 'пончик');", // doughnut  —  пончик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (46, 'for breakfast', 'на завтрак');", // for breakfast на завтрак
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (47, 'fry', 'жарить');", // fry  —       жарить
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (48, 'grape', 'виноград');", // grape  —     виноград
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (49, 'grill', 'жарить на гриле');", // grill  —     жарить на гриле
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (50, 'ham', 'ветчина');", // ham  —       ветчина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (51, 'have a bite', 'перекусить');", // have a bite   перекусить
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (52, 'ice', 'лед');", // ice  —       лед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (53, 'ketchup', 'кетчуп');", // ketchup  —   кетчуп
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (54, 'kiwi', 'киви');", // kiwi  —      киви
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (55, 'lemonade', 'лимонад');", // lemonade  —  лимонад
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (56, 'liter', 'литр');", // liter  —     литр
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (57, 'loaf', 'буханка');", // loaf  —      буханка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (58, 'lump', 'кусок');", // lump  —      кусок
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (59, 'lunch', 'обед');", // lunch  —     обед
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (60, 'marmalade', 'повидло');", // marmalade  — повидло
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (61, 'mayonnaise', 'майонез');", // mayonnaise  —майонез
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (62, 'meal', 'еда');", // meal  —      еда
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (63, 'menu', 'меню');", // menu  —      меню
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (64, 'milk', 'молоко');", // milk  —      молоко
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (65, 'mushroom', 'гриб');", // mushroom  —  гриб
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (66, 'nibble', 'откусывать');", // nibble  —    откусывать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (67, 'orange', 'апельсин');", // orange  —    апельсин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (68, 'pancake', 'блин');", // pancake  —   блин
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (69, 'pasta', 'паста');", // pasta  —     паста
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (70, 'peach', 'персик');", // peach  —     персик
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (71, 'pear', 'груша');", // pear  —      груша
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (72, 'pizza', 'пицца');", // pizza  —     пицца
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (73, 'plum', 'слива');", // plum  —      слива
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (74, 'popcorn', 'попкорн');", // popcorn  —   попкорн
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (75, 'pork', 'свинина');", // pork  —      свинина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (76, 'potato', 'картофель');", // potato  —    картофель
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (77, 'prawn', 'креветка');", // prawn  —     креветка
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (78, 'pub', 'паб');", // pub  —       паб
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (79, 'pudding', 'пудинг');", // pudding  —   пудинг
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (80, 'ripe', 'спелый');", // ripe  —      спелый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (81, 'roast', 'запекать');", // roast  —     запекать
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (82, 'salad', 'салат');", // salad  —     салат
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (83, 'salami', 'салями');", // salami  —    салями
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (84, 'salmon', 'лосось');", // salmon  —    лосось
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (85, 'sandwich', 'сэндвич');", // sandwich  —  сэндвич
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (86, 'sardine', 'сардина');", // sardine  —   сардина
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (87, 'sauce', 'соус');", // sauce  —     соус
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (88, 'seafood', 'морепродукты');", // seafood  —   морепродукты
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (89, 'soda', 'газированная вода');", // soda  —      газированная вода
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (90, 'sorbet', 'щербет');", // sorbet  —    щербет
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (91, 'soup', 'суп');", // soup  —      суп
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (92, 'sour', 'кислый');", // sour  —      кислый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (93, 'spice', 'пряность');", // spice  —     пряность
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (94, 'spicy', 'острый');", // spicy  —     острый
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (95, 'steak', 'стейк');", // steak  —     стейк
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (96, 'stew', 'рагу');", // stew  —      рагу
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (97, 'take a sip', 'прихлебнуть');", // take a sip  —прихлебнуть
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (98, 'toast', 'гренки');", // toast  —     гренки
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (99, 'trout', 'форель');", // trout  —     форель
       "INSERT INTO " + FoodWords.TABLE_FOOD_WORDS + " VALUES (100, 'tuna', 'тунец');", // tuna  —     тунец
    };


    public static String ce6 = "CREATE TABLE " + WearsWords.TABLE_WEARS_WORDS + " ("
            + WearsWords._ID + " INTEGER PRIMARY KEY, " + WearsWords.COLUMN_WORD_EN + " TEXT, "
            + WearsWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr6 = {
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (1, 'ankle boot', 'полусапожки');", // ankle boot  —      полусапожки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (2, 'anorak', 'анорак');", // anorak  —          анорак
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (3, 'apron', 'фартук');", // apron  —           фартук
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (4, 'army boots', 'армейские ботинки');", // army boots  —      армейские ботинки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (5, 'ball gown', 'бальное платье');", // ball gown  —       бальное платье
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (6, 'bandanna', 'бандана');", // bandanna  —        бандана
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (7, 'baseball cap', 'бейсболка');", // baseball cap  —    бейсболка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (8, 'bathing suit', 'купальный костюм');", // bathing suit  —    купальный костюм
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (9, 'beach shoes', 'пляжная обувь');", // beach shoes  —     пляжная обувь
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (10, 'belt', 'ремень');", // belt  —            ремень
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (11, 'bermuda shorts', 'бермуды');", // bermuda shorts  —  бермуды
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (12, 'blazer', 'блейзер');", // blazer  —          блейзер
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (13, 'blouse', 'блузка');", // blouse  —          блузка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (14, 'boots', 'ботинки');", // boots  —           ботинки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (15, 'bow tie', 'галстук-бабочка');", // bow tie  —         галстук-бабочка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (16, 'bowling shoes', 'обувь для боулинга');", // bowling shoes  —   обувь для боулинга
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (17, 'breeches', 'бриджи');", // breeches  —        бриджи
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (18, 'brogues', 'броги');", // brogues  —         броги
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (19, 'cardigan', 'кардиган');", // cardigan  —        кардиган
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (20, 'casual dress', 'повседневная одежда');", // casual dress  —    повседневная одежда
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (21, 'chemise', 'женская сорочка');", // chemise  —         женская сорочка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (22, 'cloak', 'плащ');", // cloak  —           плащ
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (23, 'clothes', 'одежда');", // clothes  —         одежда
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (24, 'coat', 'пальто');", // coat  —            пальто
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (25, 'costume', 'костюм');", // costume  —         костюм
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (26, 'court shoes', 'туфли-лодочки');", // court shoes  —     туфли-лодочки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (27, 'coveralls', 'комбинезон');", // coveralls  —       комбинезон
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (28, 'cowboy boots', 'ковбойские сапоги');", // cowboy boots  —    ковбойские сапоги
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (29, 'culottes', 'юбка-брюки');", // culottes  —        юбка-брюки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (30, 'dinner jacket', 'смокинг');", // dinner jacket  —   смокинг
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (31, 'espadrilles', 'эспадрильи');", // espadrilles  —     эспадрильи
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (32, 'evening gown', 'вечернее платье');", // evening gown  —    вечернее платье
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (33, 'fedora', 'мягкая фетровая шляпа');", // fedora  —          мягкая фетровая шляпа
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (34, 'flip-flops', 'вьетнамки');", // flip-flops  —      вьетнамки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (35, 'garment', 'предмет одежды');", // garment  —         предмет одежды
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (36, 'golf shoes', 'туфли для гольфа');", // golf shoes  —      туфли для гольфа
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (37, 'gown', 'платье');", // gown  —            платье
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (38, 'hat', 'шапка');", // hat  —             шапка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (39, 'hiking boots', 'треккинговые ботинки');", // hiking boots  —    треккинговые ботинки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (40, 'hoodie', 'толстовка с капюшоном');", // hoodie  —          толстовка с капюшоном
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (41, 'housecoat', 'женский халат');", // housecoat  —       женский халат
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (42, 'jackboots', 'ботфорты');", // jackboots  —       ботфорты
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (43, 'jersey', 'свитер');", // jersey  —          свитер
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (44, 'jumpsuit', 'спортивный костюм');", // jumpsuit  —        спортивный костюм
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (45, 'kimono', 'кимоно');", // kimono  —          кимоно
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (46, 'leather jacket', 'кожаный пиджак');", // leather jacket  —  кожаный пиджак
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (47, 'leggings', 'лосины');", // leggings  —        лосины
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (48, 'miniskirt', 'мини-юбка');", // miniskirt  —       мини-юбка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (49, 'mittens', 'рукавицы');", // mittens  —         рукавицы
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (50, 'moccasins', 'мокасины');", // moccasins  —       мокасины
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (51, 'outerwear', 'верхняя одежда');", // outerwear  —       верхняя одежда
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (52, 'oxfords', 'оксфорды');", // oxfords  —         оксфорды
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (53, 'pinafore', 'сарафан');", // pinafore  —        сарафан
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (54, 'platform shoes', 'обувь на платформе');", // platform shoes  —  обувь на платформе
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (55, 'pleated skirt', 'юбка в складку');", // pleated skirt  —   юбка в складку
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (56, 'pointe shoes', 'пуанты');", // pointe shoes  —    пуанты
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (57, 'polo shirt', 'поло');", // polo shirt  —      поло
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (58, 'poncho', 'пончо');", // poncho  —          пончо
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (59, 'pullover', 'пуловер');", // pullover  —        пуловер
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (60, 'raincoat', 'плащ');", // raincoat  —        плащ
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (61, 'riding boots', 'сапоги для верховой езды');", // riding boots  —    сапоги для верховой езды
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (62, 'scarf', 'шарф');", // scarf  —           шарф
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (63, 'shirt', 'рубашка');", // shirt  —           рубашка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (64, 'shoes', 'обувь');", // shoes  —           обувь
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (65, 'ski boots', 'лыжные ботинки');", // ski boots  —       лыжные ботинки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (66, 'sneakers', 'кроссовки');", // sneakers  —        кроссовки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (67, 'stiletto heels', 'туфли на шпильках');", // stiletto heels  —  туфли на шпильках
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (68, 'stockings', 'женские чулки');", // stockings  —       женские чулки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (69, 'sweatshirt', 'толстовка');", // sweatshirt  —      толстовка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (70, 't-shirt', 'футболка');", // T-shirt  —         футболка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (71, 'tanktop', 'майка на лямках');", // tanktop  —         майка на лямках
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (72, 'tennis shoes', 'обувь для тенниса');", // tennis shoes  —    обувь для тенниса
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (73, 'trench coat', 'тренч');", // trench coat  —     тренч
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (74, 'trousers', 'брюки');", // trousers  —        брюки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (75, 'tunic', 'туника');", // tunic  —           туника
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (76, 'turtleneck sweater', ' водолазка');", // turtleneck sweater  водолазка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (77, 'tuxedo', 'смокинг');", // tuxedo  —          смокинг
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (78, 'tweed jacket', 'твидовый пиджак');", // tweed jacket  —    твидовый пиджак
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (79, 'underwear', 'нижнее белье');", // underwear  —       нижнее белье
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (80, 'wellington boots', 'резиновые сапоги');", // wellington boots  —резиновые сапоги
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (81, 'white tie', 'парадный костюм');", // white tie  —       парадный костюм
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (82, 'beret', 'берет');", // beret  —           берет
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (83, 'bra', 'бюстгальтер');", // bra  —             бюстгальтер
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (84, 'dress', 'платье');", // dress  —           платье
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (85, 'frock', 'платьеце');", // frock  —           платьеце
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (86, 'fur coat', 'шуба');", // fur coat  —        шуба
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (87, 'gloves', 'перчатки');", // gloves  —          перчатки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (88, 'jacket', 'куртка');", // jacket  —          куртка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (89, 'jeans', 'джинсы');", // jeans  —           джинсы
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (90, 'nightgown', 'ночная рубашка');", // nightgown  —       ночная рубашка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (91, 'pajamas', 'пижама');", // pajamas  —         пижама
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (92, 'pantyhose', 'колготки');", // pantyhose  —       колготки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (93, 'running shoes', 'кроссовки');", // running shoes  —   кроссовки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (94, 'sandals', 'сандалии');", // sandals  —         сандалии
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (95, 'shorts', 'шорты');", // shorts  —          шорты
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (96, 'skirt', 'юбка');", // skirt  —           юбка
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (97, 'slippers', 'тапочки');", // slippers  —        тапочки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (98, 'socks', 'носки');", // socks  —           носки
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (99, 'tie', 'галстук');", // tie  —             галстук
       "INSERT INTO " + WearsWords.TABLE_WEARS_WORDS + " VALUES (100, 'waistcoat', 'жилет');" // waistcoat  —       жилет
    };

    public static String ce7 = "CREATE TABLE " + FurnitureWords.TABLE_FURNITURE_WORDS + " ("
            + FurnitureWords._ID + " INTEGER PRIMARY KEY, " + FurnitureWords.COLUMN_WORD_EN + " TEXT, "
            + FurnitureWords.COLUMN_WORD_RU + " TEXT " + " )";

    public static String[] arr7 = {
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (1, 'armchair', 'кресло');", //armchair  —         кресло
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (2, 'armoire', 'шкаф');", // armoire  —         шкаф
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (3, 'bar stool', 'барный стул');", // bar stool  —       барный стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (4, 'beach chair', 'шезлонг');", // beach chair  —     шезлонг
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (5, 'bed', 'кровать');", // bed  —             кровать
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (6, 'bench', 'скамья');", // bench  —           скамья
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (7, 'bentwood rocker', 'кресло-качалка');", // bentwood rocker  — кресло-качалка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (8, 'blinds', 'жалюзи');", // blinds  —          жалюзи
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (9, 'bookcase', 'книжный шкаф');", // bookcase  —        книжный шкаф
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (10, 'bookshelf', 'книжная полка');", // bookshelf  —       книжная полка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (11, 'buffet', 'буфет');", // buffet  —          буфет
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (12, 'bunk bed', 'двухъярусная кровать');", // bunk bed  —        двухъярусная кровать
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (13, 'bureau', 'письменный стол');", // bureau  —          письменный стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (14, 'cabinet', 'мебельная горка');", // cabinet  —         мебельная горка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (15, 'canopy bed', 'кровать с балдахином');", // canopy bed  —      кровать с балдахином
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (16, 'card table', 'карточный стол');", // card table  —      карточный стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (17, 'carpet', 'ковер');", // carpet  —          ковер
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (18, 'chair', 'стул');", // chair  —           стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (19, 'chaise longue', 'кушетка');", // chaise longue  —   кушетка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (20, 'chandelier', 'люстра');", // chandelier  —      люстра
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (21, 'chest', 'ящик');", // chest  —           ящик
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (22, 'chest of drawers', 'комод');", // chest of drawers  —комод
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (23, 'clock', 'часы');", // clock  —           часы
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (24, 'coffee table', 'кофейный столик');", // coffee table  —    кофейный столик
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (25, 'console', 'шкафчик');", // console  —         шкафчик
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (26, 'cot', 'детская кроватка');", // cot  —             детская кроватка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (27, 'couch', 'диван');", // couch  —           диван
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (28, 'cradle', 'колыбель');", // cradle  —          колыбель
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (29, 'cupboard', 'шкаф');", // cupboard  —        шкаф
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (30, 'curio', 'антикварная вещь');", // curio  —           антикварная вещь
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (31, 'curtains', 'шторы');", // curtains  —        шторы
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (32, 'cushion', 'диванная подушка');", // cushion  —         диванная подушка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (33, 'desk', 'письменный стол');", // desk  —            письменный стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (34, 'dining room table', ' обеденный стол');", // dining room table   обеденный стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (35, 'display cabinet', 'шкаф-витрина');", // display cabinet  — шкаф-витрина
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (36, 'divan', 'тахта');", // divan  —           тахта
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (37, 'door', 'дверь');", // door  —            дверь
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (38, 'double bed', 'двуспальная кровать');", // double bed  —      двуспальная кровать
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (39, 'drapery', 'портьера');", // drapery  —         портьера
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (40, 'dresser', 'туалетный столик');", // dresser  —         туалетный столик
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (41, 'easel', 'мольберт');", // easel  —           мольберт
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (42, 'easy chair', 'удобное кресло');", // easy chair  —      удобное кресло
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (43, 'escritoire', 'секретер');", // escritoire  —      секретер
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (44, 'fireplace', 'камин');", // fireplace  —       камин
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (45, 'folding chair', 'складной стул');", // folding chair  —   складной стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (46, 'footrest', 'подставка для ног');", // footrest  —        подставка для ног
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (47, 'footstool', 'скамеечка для ног');", // footstool  —       скамеечка для ног
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (48, 'four-poster bed', 'кровать с балдахином');", // four-poster bed  — кровать с балдахином
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (49, 'furnishings', 'предметы обстановки');", // furnishings  —     предметы обстановки
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (50, 'furniture', 'мебель');", // furniture  —       мебель
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (51, 'futon', 'хлопчатобумажный матрац');", // futon  —           хлопчатобумажный матрац
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (52, 'garden bench', 'садовая скамейка');", // garden bench  —    садовая скамейка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (53, 'gas-stove', 'газовая плита');", // gas-stove  —       газовая плита
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (54, 'gateleg table', 'стол-тумба');", // gateleg table  —   стол-тумба
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (55, 'grandfather clock', ' дедушкины часы');", // grandfather clock   дедушкины часы
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (56, 'hammock', 'гамак');", // hammock  —         гамак
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (57, 'hassock', 'подушечка');", // hassock  —         подушечка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (58, 'hat stand', 'вешалка для шляп');", // hat stand  —       вешалка для шляп
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (59, 'headboard', 'изголовье кровати');", // headboard  —       изголовье кровати
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (60, 'highchair', 'высокий стул');", // highchair  —       высокий стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (61, 'hope chest', 'сундук с приданым');", // hope chest  —      сундук с приданым
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (62, 'hutch', 'ящик для вещей');", // hutch  —           ящик для вещей
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (63, 'ironing board', 'гладильная доска');", // ironing board  —   гладильная доска
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (64, 'lamp', 'лампа');", // lamp  —            лампа
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (65, 'light', 'свет');", // light  —           свет
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (66, 'lintel', 'перемычка');", // lintel  —          перемычка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (67, 'mattress', 'тюфяк');", // mattress  —        тюфяк
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (68, 'mirror', 'зеркало');", // mirror  —          зеркало
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (69, 'nightstand', 'тумбочка');", // nightstand  —      тумбочка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (70, 'office chair', 'офисный стул');", // office chair  —    офисный стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (71, 'ottoman', 'тахта');", // ottoman  —         тахта
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (72, 'pantry', 'кладовая');", // pantry  —          кладовая
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (73, 'park bench', 'скамейке в парке');", // park bench  —      скамейке в парке
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (74, 'picnic table', 'стол для пикника');", // picnic table  —    стол для пикника
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (75, 'pillow', 'подушка');", // pillow  —          подушка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (76, 'rocking chair', 'кресло-качалка');", // rocking chair  —   кресло-качалка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (77, 'room divider', 'комнатная перегородка');", // room divider  —    комнатная перегородка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (78, 'rug', 'ковер');", // rug  —             ковер
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (79, 'sconce', 'бра');", // sconce  —          бра
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (80, 'screen', 'экран');", // screen  —          экран
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (81, 'seat', 'сиденье');", // seat  —            сиденье
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (82, 'settee', 'небольшой диван');", // settee  —          небольшой диван
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (83, 'shelf', 'полка');", // shelf  —           полка
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (84, 'sideboard', 'сервант');", // sideboard  —       сервант
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (85, 'sofa', 'диван');", // sofa  —            диван
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (86, 'sofabed', 'диван-кровать');", // sofabed  —         диван-кровать
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (87, 'staircase', 'лестница');", // staircase  —       лестница
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (88, 'stool', 'стул');", // stool  —           стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (89, 'strongbox', 'сейф');", // strongbox  —       сейф
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (90, 'swings', 'качели');", // swings  —          качели
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (91, 'swivel chair', 'вращающийся стул');", // swivel chair  —    вращающийся стул
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (92, 'table', 'стол');", // table  —           стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (93, 'truckle bed', 'выдвижная кровать');", // truckle bed  —     выдвижная кровать
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (94, 'tuffet', 'табурет');", // tuffet  —          табурет
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (95, 'wardrobe', 'гардероб');", // wardrobe  —        гардероб
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (96, 'waste basket', 'корзина для мусора');", // waste basket  —    корзина для мусора
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (97, 'window shades', 'шторы');", // window shades  —   шторы
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (98, 'windsor chair', 'виндзорское кресло');", // windsor chair  —   виндзорское кресло
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (99, 'work table', 'рабочий стол');", // work table  —      рабочий стол
       "INSERT INTO " + FurnitureWords.TABLE_FURNITURE_WORDS + " VALUES (100, 'writing desk', 'письменный стол');" // writing desk  —    письменный стол
    };

    public static String ce8 = "CREATE TABLE " + FlagTable.TABLE_FLAG + " ("
            + FlagTable._ID + " INTEGER PRIMARY KEY, " + FlagTable.COLUMN_NAME + " TEXT, "
            + FlagTable.COLUMN_FLAG + " TEXT " + " )";

    public static String[] arr8 = {
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (1, '" + EmotionsWords.TABLE_EMOTIONS_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (2, '" + FoodWords.TABLE_FOOD_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (3, '" + FurnitureWords.TABLE_FURNITURE_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (4, '" + DiseaseWords.TABLE_DESEASE_WORDS + "', '1');",
            "INSERT INTO " + FlagTable.TABLE_FLAG + " VALUES (5, '" + WearsWords.TABLE_WEARS_WORDS + "', '1');",
    };


    public static String DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TranslateTexts.TABLE_NEW_WORD_NAME;
    public static String DE2 = "DROP TABLE IF EXISTS " + LearnedWords.TABLE_LEARNED_WORDS_NAME;
    public static String DE3 = "DROP TABLE IF EXISTS " + DiseaseWords.TABLE_DESEASE_WORDS;
    public static String DE4 = "DROP TABLE IF EXISTS " + FoodWords.TABLE_FOOD_WORDS;
    public static String DE5 = "DROP TABLE IF EXISTS " + FurnitureWords.TABLE_FURNITURE_WORDS;
    public static String DE6 = "DROP TABLE IF EXISTS " + EmotionsWords.TABLE_EMOTIONS_WORDS;
    public static String DE7 = "DROP TABLE IF EXISTS " + WearsWords.TABLE_WEARS_WORDS;
    public static String DE8 = "DROP TABLE IF EXISTS " + FlagTable.TABLE_FLAG;


}
