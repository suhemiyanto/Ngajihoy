package com.example.suhemi.gurungaji;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class FontAsset extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/NeoSans-Medium.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }


}
