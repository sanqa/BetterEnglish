package com.bionic.sasha.betterenglish;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class Ads {

    public static void showBannerAddNew(Activity activity) {
        AdView banner = (AdView) activity.findViewById(R.id.bannerAddNew);
        AdRequest adRequest = new AdRequest.Builder().build();
        banner.loadAd(adRequest);

    }



    public static void setupContentViewPadding(Activity activity, int padding) {
       // View view = activity.findViewById()
    }
}
