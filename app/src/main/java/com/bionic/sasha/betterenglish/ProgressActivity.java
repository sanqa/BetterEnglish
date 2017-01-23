package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.all_words)
    TextView allWords;

    @BindView(R.id.current_all_learn)
    TextView currentLearn;

    @BindView(R.id.progress_progress_bar)
    ProgressBar progress;

    @BindView(R.id.banner_progress)
    AdView banner;

    TranslateDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dbHelper = new TranslateDBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        long cnt  = DatabaseUtils.queryNumEntries(database, TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME);
        allWords.setText("" + cnt);

        long current = DatabaseUtils.queryNumEntries(database, TranslateReaderDB.LearnedWords.TABLE_LEARNED_WORDS_NAME);
        currentLearn.setText("" + current);

        progress.setMax((int) cnt);
        progress.setProgress((int) current);

        AdRequest request = new AdRequest.Builder().build();
        banner.loadAd(request);
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
            Intent intent = new Intent(this, AddNewWordActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_progress){
            //do nothing
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

    public void showLearned(View view) {
        Intent intent = new Intent(this, ShowLearnedWordsActivity.class);
        startActivity(intent);
    }
}
