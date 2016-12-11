package com.bionic.sasha.betterenglish;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bionic.sasha.betterenglish.api.Translate;
import com.bionic.sasha.betterenglish.api.TranslateAPI;
import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

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

    @OnClick (R.id.button_add) void newAdd(){
        ContentValues cv = new ContentValues();
        String wordRu;
        String wordEn;
        if (typeSpinner.getSelectedItemPosition() == 0){
            wordRu = translateWord.getText().toString();
            wordEn = newWord.getText().toString();
        } else {
            wordEn = translateWord.getText().toString();
            wordRu = newWord.getText().toString();
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_RU, wordRu);
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_WORD_EN, wordEn);
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE1, 0);
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE2, 0);
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE3, 0);
        cv.put(TranslateReaderDB.TranslateTexts.COLUMN_MODE4, 0);

        long rowID = db.insert(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, cv);
        Toast.makeText(this, "Add to learn as #" + rowID,Toast.LENGTH_SHORT).show();

        newWord.setText("");
        translateWord.setText("");
    }

    @OnClick(R.id.button_get_translate) void getTranslate() {
        String BASE_URL = "https://translate.yandex.net" ;

        String ourWord = newWord.getText().toString();

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
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ask_author){
            Intent intent = new Intent(this, WriteAuthorActivity.class);
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

            addButton.setEnabled(true);
        } else {
            Toast.makeText(AddNewWordActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Translate> call, Throwable t) {
        Log.e("Some mistake", t.toString());
    }
}