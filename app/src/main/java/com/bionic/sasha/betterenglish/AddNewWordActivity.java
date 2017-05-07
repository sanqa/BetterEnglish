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
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
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
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

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
        implements Callback<Translate> {

    String[] types = {"en-ru","ru-en"};

    TranslateDBHelper dbHelper;
    private Drawer mDrawer;

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



        dbHelper = new TranslateDBHelper(this);

        final List<IDrawerItem> iDrawerItems = new ArrayList<>();
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(1).withSelectable(false).withName(R.string.add_new_word).withIcon(R.drawable.ic_add_circle_outline_black_24dp));
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(2).withSelectable(false).withName(R.string.trainee).withIcon(R.drawable.ic_trainee_black_24dp));
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(3).withSelectable(false).withName(R.string.progress_label).withIcon(R.drawable.ic_progress_in_black_24dp));
        iDrawerItems.add(new DividerDrawerItem());
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(4).withSelectable(false).withName(R.string.information).withIcon(R.drawable.ic_info_outline_black_24dp));
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(5).withSelectable(false).withName(R.string.settings).withIcon(R.drawable.ic_settings_black_24dp));
        iDrawerItems.add(new PrimaryDrawerItem().withIdentifier(6).withSelectable(false).withName(R.string.about).withIcon(R.drawable.ic_assignment_black_24dp));


        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(R.layout.nav_all)
                .withDrawerItems(iDrawerItems)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(final View view, final int position, final IDrawerItem drawerItem) {
                        int id = view.getId();
                        switch (id) {
                            case 1:
                                if (mDrawer.getDrawerLayout().isDrawerOpen(GravityCompat.START))
                                    mDrawer.getDrawerLayout().closeDrawer(GravityCompat.START);
                                break;
                            case 2:
                                startActivity(new Intent(AddNewWordActivity.this, OurDictionaryActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(AddNewWordActivity.this, ProgressActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(AddNewWordActivity.this, InformationActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(AddNewWordActivity.this, SettingsActivity.class));
                                break;
                            case 6:
                                startActivity(new Intent(AddNewWordActivity.this, AboutActivity.class));
                                break;
                        }
                        return true;
                    }
                })
                .build();

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(false);
        mDrawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
        mDrawer.deselect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Ads.showBannerAddNew(this);
    }

    @Override
    public void onBackPressed() {
        if (!mDrawer.isDrawerOpen())
            mDrawer.openDrawer();
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