package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.ui.MyAdapter;

import java.util.ArrayList;

public class OurDictionaryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    private TranslateDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_dictionary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        dbHelper = new TranslateDBHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurDictionaryActivity.this, AddNewWordActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.trainee_recycler_view);

        ArrayList<String> myDataset = getDataSet();
        ArrayList<Integer> myDrawable = getBackgroundSet();
        ArrayList<Integer> myIcons  = getIcons();
        ArrayList<Integer> myModes = getModes();

        mLayoutManager = new LinearLayoutManager(this); //осуществляем подключение менеджера к нашему списку
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(myDataset, myDrawable, myIcons, myModes);//то же самое делаем с адаптером
        recyclerView.setAdapter(mAdapter);
    }

    private ArrayList<Integer> getIcons() {
        ArrayList<Integer> icons = new ArrayList<>();
        icons.add(R.mipmap.ic_mode1);
        icons.add(R.mipmap.icon_mode2);
        icons.add(R.mipmap.icon_mode3);
        icons.add(R.mipmap.icon_mode4);

        return icons;
    }

    private ArrayList<Integer> getModes() {
        ArrayList<Integer> modes = new ArrayList<>();
        modes.add(R.string.mode1);
        modes.add(R.string.mode2);
        modes.add(R.string.mode3);
        modes.add(R.string.mode4);

        return modes;
    }

    private ArrayList<Integer> getBackgroundSet() {
        ArrayList<Integer> myImageSet = new ArrayList();
        myImageSet.add(R.color.mode1);
        myImageSet.add(R.color.mode2);
        myImageSet.add(R.color.mode3);
        myImageSet.add(R.color.mode4);

        return myImageSet;
    }

    private ArrayList<String> getDataSet() {
        ArrayList<String> mDataSet = new ArrayList();

        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //Cursor cursor = database.query();

        mDataSet.add("123");
        mDataSet.add("216");
        mDataSet.add("77");
        mDataSet.add("134");
        return mDataSet;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {//переход к другим активити по нажатию
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_trainee) {
            //do nothing

        } else if (id == R.id.nav_add_words) {
            Intent intent = new Intent(this, AddNewWordActivity.class);
            startActivity(intent);
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
}
