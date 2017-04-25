package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bionic.sasha.betterenglish.db.TranslateDBHelper;
import com.bionic.sasha.betterenglish.db.TranslateReaderDB;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressActivity extends AppCompatActivity {

    @BindView(R.id.all_words)
    TextView allWords;

    @BindView(R.id.current_all_learn)
    TextView currentLearn;

    @BindView(R.id.progress_progress_bar)
    ProgressBar progress;

    @BindView(R.id.banner_progress)
    AdView banner;

    TranslateDBHelper dbHelper;
    private Drawer mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

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
                                startActivity(new Intent(ProgressActivity.this, AddNewWordActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(ProgressActivity.this, OurDictionaryActivity.class));
                                break;
                            case 3:
                                if (mDrawer.getDrawerLayout().isDrawerOpen(GravityCompat.START))
                                    mDrawer.getDrawerLayout().closeDrawer(GravityCompat.START);
                                break;
                            case 4:
                                startActivity(new Intent(ProgressActivity.this, InformationActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(ProgressActivity.this, SettingsActivity.class));
                                break;
                            case 6:
                                startActivity(new Intent(ProgressActivity.this, AboutActivity.class));
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
        if (!mDrawer.isDrawerOpen())
            mDrawer.openDrawer();
    }

    public void showLearned(View view) {
        Intent intent = new Intent(this, ShowLearnedWordsActivity.class);
        startActivity(intent);
    }
}
