package com.bionic.sasha.betterenglish.api;

import com.bionic.sasha.betterenglish.BuildConfig;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SASHA on 10.12.2016.
 */


public interface TranslateAPI {



    @GET("/api/v1.5/tr.json/translate?lang=en-ru&key=" + BuildConfig.API_YANDEX )
    Call<Translate> getTranslate(@Query("text") String text);

    @GET("/api/v1.5/tr.json/translate?lang=ru-en&key=" + BuildConfig.API_YANDEX )
    Call<Translate> getTranslateRU(@Query("text") String text);

}
