package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SAVED_TEXT = "saved_count_settings";

    String words_count[] = {"10", "15", "20"};

    Spinner spinner;

    SharedPreferences sp;

    @BindView(R.id.banner_settings)
    AdView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, words_count);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapter);
        spinner.setPrompt("Counts");

        spinner.setSelection(loadText());

        AdRequest request = new AdRequest.Builder().build();
        banner.loadAd(request);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getBaseContext(), words_count[i], Toast.LENGTH_LONG).show();
                spinner.setSelection(i);
                saveText(words_count[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //do nothing
            }
        });



    }

    private void saveText(String str){
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(SAVED_TEXT, str);
        ed.commit();
    }

    private int loadText(){
        int position = 0;
        sp = getPreferences(MODE_PRIVATE);
        String savedText = sp.getString(SAVED_TEXT, "");
        for (int i = 0; i < words_count.length; i++){
            if (savedText.equals(words_count[i])) position = i;
        }
        return position;
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
            Intent intent = new Intent(this, ProgressActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_info) {
            Intent intent = new Intent(this, InformationActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            //do nothing
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
