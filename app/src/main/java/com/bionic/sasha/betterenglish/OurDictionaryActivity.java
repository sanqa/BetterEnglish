package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.bionic.sasha.betterenglish.ui.MyAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class OurDictionaryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    private TranslateDBHelper dbHelper;
    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_dictionary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
                                startActivity(new Intent(OurDictionaryActivity.this, AddNewWordActivity.class));
                                break;
                            case 2:
                                if (mDrawer.getDrawerLayout().isDrawerOpen(GravityCompat.START))
                                    mDrawer.getDrawerLayout().closeDrawer(GravityCompat.START);
                                break;
                            case 3:
                                startActivity(new Intent(OurDictionaryActivity.this, ProgressActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(OurDictionaryActivity.this, InformationActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(OurDictionaryActivity.this, SettingsActivity.class));
                                break;
                            case 6:
                                startActivity(new Intent(OurDictionaryActivity.this, AboutActivity.class));
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
        ArrayList<Integer> myIcons = getIcons();
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

        return icons;
    }

    private ArrayList<Integer> getModes() {
        ArrayList<Integer> modes = new ArrayList<>();
        modes.add(R.string.mode1);
        modes.add(R.string.mode2);
        modes.add(R.string.mode3);

        return modes;
    }

    private ArrayList<Integer> getBackgroundSet() {
        ArrayList<Integer> myImageSet = new ArrayList();
        myImageSet.add(R.color.mode1);
        myImageSet.add(R.color.mode2);
        myImageSet.add(R.color.mode3);

        return myImageSet;
    }

    private ArrayList<String> getDataSet() {
        ArrayList<String> mDataSet = new ArrayList();
        int c1 = 0, c2 = 0, c3 = 0;
        String selection1 = " mode1 < 3 ";
        String selection2 = " mode2 < 3 ";
        String selection3 = " mode3 < 3 ";

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, selection1, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    c1++;
                } while (cursor.moveToNext());
            }
        }
        mDataSet.add(String.valueOf(c1));

        Cursor cursor2 = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, selection2, null, null, null, null);
        if (cursor2 != null) {
            if (cursor2.moveToFirst()) {
                do {
                    c2++;
                } while (cursor2.moveToNext());
            }
        }
        mDataSet.add(String.valueOf(c2));


        Cursor cursor3 = database.query(TranslateReaderDB.TranslateTexts.TABLE_NEW_WORD_NAME, null, selection3, null, null, null, null);
        if (cursor3 != null) {
            if (cursor3.moveToFirst()) {
                do {
                    c3++;
                } while (cursor3.moveToNext());
            }
        }
        mDataSet.add(String.valueOf(c3));


        return mDataSet;
    }

    @Override
    public void onBackPressed() {
        if (!mDrawer.isDrawerOpen())
            mDrawer.openDrawer();
    }
}
