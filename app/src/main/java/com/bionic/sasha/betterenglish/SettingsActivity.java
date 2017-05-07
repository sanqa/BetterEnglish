package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity {

    private static final String SAVED_TEXT = "saved_count_settings";

    String words_count[] = {"10", "15", "20"};

    private Drawer mDrawer;
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


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, words_count);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapter);
        spinner.setPrompt("Counts");

        spinner.setSelection(loadText());

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
                                startActivity(new Intent(SettingsActivity.this, AddNewWordActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(SettingsActivity.this, OurDictionaryActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(SettingsActivity.this, ProgressActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(SettingsActivity.this, InformationActivity.class));
                                break;
                            case 5:
                                if (mDrawer.getDrawerLayout().isDrawerOpen(GravityCompat.START))
                                    mDrawer.getDrawerLayout().closeDrawer(GravityCompat.START);
                                break;
                            case 6:
                                startActivity(new Intent(SettingsActivity.this, AboutActivity.class));
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

    @Override
    protected void onResume() {
        super.onResume();
        AdRequest request = new AdRequest.Builder().build();
        banner.loadAd(request);
    }

    @Override
    public void onBackPressed() {
        if (!mDrawer.isDrawerOpen())
            mDrawer.openDrawer();
    }

    private void saveText(String str) {
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(SAVED_TEXT, str);
        ed.commit();
    }

    private int loadText() {
        int position = 0;
        sp = getPreferences(MODE_PRIVATE);
        String savedText = sp.getString(SAVED_TEXT, "");
        for (int i = 0; i < words_count.length; i++) {
            if (savedText.equals(words_count[i])) position = i;
        }
        return position;
    }


}
