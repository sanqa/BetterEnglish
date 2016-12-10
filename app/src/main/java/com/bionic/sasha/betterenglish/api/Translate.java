package com.bionic.sasha.betterenglish.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SASHA on 10.12.2016.
 */

public class Translate {

    @SerializedName("code")
    private int translateCode;

    @SerializedName("text")
    private String[] translate;

    public int getTranslateCode() {
        return translateCode;
    }

    public String[] getTranslate() {
        return translate;
    }
}
