package com.bionic.sasha.betterenglish;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bionic.sasha.betterenglish.api.Translate;
import com.bionic.sasha.betterenglish.api.TranslateAPI;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewWordActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Callback<Translate> {

    String[] types = {"en-ru","ru-en"};

    TranslateDBHelper dbHelper;

    @BindView (R.id.text_new_word)
    EditText newWord;

    @BindView(R.id.add_text_translate)
    EditText translateWord;

    @BindView (R.id.button_add)
    Button addButton;

    @BindView (R.id.spinner_type)
    Spinner typeSpinner;

    @BindView (R.id.new_word_progress)
    ProgressBar progress;

    @BindView(R.id.linearAddNew)
    LinearLayout linear;

    @OnClick (R.id.button_add) void newAdd(){
        ContentValues cv = new ContentValues();
        String wordRu;
        String wordEn;
        if (typeSpinner.getSelectedItemPosition() == 0){
            wordRu = translateWord.getText().toString().toLowerCase();
            wordEn = newWord.getText().toString().toLowerCase();
        } else {
            wordEn = translateWord.getText().toString().toLowerCase();
            wordRu = newWord.getText().toString().toLowerCase();
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int counter = 0;

        Cursor cursor = db.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME,null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String str1 = cursor.getString(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU));
                    String str2 = cursor.getString(cursor.getColumnIndex(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN));
                    if (wordEn.equals(str2) || wordRu.equals(str1) || str1.length() < 2 || str2.length() < 2)
                        counter++;
                } while (cursor.moveToNext());
            }
        }

        if (counter == 0) {

            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU, wordRu);
            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN, wordEn);
            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, 0);
            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE2, 0);
            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE3, 0);
            cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE4, 0);

            long rowID = db.insert(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, cv);
            Toast.makeText(this, getString(R.string.toast_add_word_number) + rowID, Toast.LENGTH_SHORT).show();

            newWord.setText("");
            translateWord.setText("");
            addButton.setEnabled(false);
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle(R.string.wrong).setMessage(R.string.toast_same_word).setCancelable(false)
                    .setIcon(R.drawable.wrong).setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                    newWord.setText("");
                    translateWord.setText("");
                    addButton.setEnabled(false);

                }
            });

            AlertDialog alert = builder.create();
            alert.show();

        }
    }

    @OnClick(R.id.button_get_translate) void getTranslate() {
        String BASE_URL = "https://translate.yandex.net" ;

        String ourWord = newWord.getText().toString();

        progress.setVisibility(View.VISIBLE);

        //Retrofit2 logging - 3 lines.

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client2 = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client2)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        TranslateAPI transAPI = client.create(TranslateAPI.class);

        if (typeSpinner.getSelectedItemPosition() == 0) {
            Call<Translate> callTrans = transAPI.getTranslate(ourWord);
            callTrans.enqueue(this);
        } else {
            Call<Translate> callTrans = transAPI.getTranslateRU(ourWord);
            callTrans.enqueue(this);
        }



    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_word);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner.setAdapter(adapter);
        typeSpinner.setSelection(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        Ads.showBannerAddNew(this);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dbHelper = new TranslateDBHelper(this);
    }

    @Override
    public void onBackPressed() {

    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_trainee) {
            Intent intent = new Intent(this, OurDictionaryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_add_words) {
            //do nothing
        } else if (id == R.id.nav_progress){
            Intent intent = new Intent(this, ProgressActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_info) {
            Intent intent = new Intent(this, InformationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onResponse(Call<Translate> call, Response<Translate> response) {
        if (response.isSuccessful()){
            String[] array = response.body().getTranslate();

            translateWord.setText(array[0]);
            progress.setVisibility(View.INVISIBLE);

            addButton.setEnabled(true);
        } else {
            Toast.makeText(AddNewWordActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Translate> call, Throwable t) {
        Log.e("Some mistake", t.toString());
    }

    public void openArrayWords(View view) {
        Intent intent = new Intent(this, ArrayWordsActivity.class);
        startActivity(intent);
    }
}