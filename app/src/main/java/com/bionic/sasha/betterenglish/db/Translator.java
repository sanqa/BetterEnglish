package com.bionic.sasha.betterenglish.db;

import java.sql.Date;

/**
 * Created by SASHA on 10.12.2016.
 */
public class Translator {
    private int _id;
    private String _wordRu;
    private String _wordEn;
    private Date _date;

    public Translator(int _id, String _wordRu, String _wordEn, Date _date) {
        this._id = _id;
        this._wordRu = _wordRu;
        this._wordEn = _wordEn;
        this._date = _date;
    }

    public Translator(String _wordRu, String _wordEn, Date _date) {
        this._wordRu = _wordRu;
        this._wordEn = _wordEn;
        this._date = _date;
    }

    public String get_wordRu() {
        return _wordRu;
    }

    public void set_wordRu(String _wordRu) {
        this._wordRu = _wordRu;
    }

    public String get_wordEn() {
        return _wordEn;
    }

    public void set_wordEn(String _wordEn) {
        this._wordEn = _wordEn;
    }

    public Date get_date() {
        return _date;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }
}

