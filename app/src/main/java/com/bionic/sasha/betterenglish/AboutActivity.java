package com.bionic.sasha.betterenglish;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.List;

public class AboutActivity extends AppCompatActivity {

    private Drawer mDrawer;
    AdView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ButterKnife.bind(this);
        banner = (AdView) findViewById(R.id.banner_about);


        AdRequest request = new AdRequest.Builder().build();
        banner.loadAd(request);

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
                                startActivity(new Intent(AboutActivity.this, AddNewWordActivity.class));
                                break;
                            case 2:
                                startActivity(new Intent(AboutActivity.this, OurDictionaryActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(AboutActivity.this, ProgressActivity.class));
                                break;
                            case 4:
                                startActivity(new Intent(AboutActivity.this, InformationActivity.class));
                                break;
                            case 5:
                                startActivity(new Intent(AboutActivity.this, SettingsActivity.class));
                                break;
                            case 6:
                                if (mDrawer.getDrawerLayout().isDrawerOpen(GravityCompat.START))
                                    mDrawer.getDrawerLayout().closeDrawer(GravityCompat.START);
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
    public void onBackPressed() {
        if (!mDrawer.isDrawerOpen())
            mDrawer.openDrawer();
    }
}
