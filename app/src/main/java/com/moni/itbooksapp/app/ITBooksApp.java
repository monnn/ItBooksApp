package com.moni.itbooksapp.app;

import android.app.Application;

import com.moni.itbooksapp.abstractapp.WebFetcher;


/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class ITBooksApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WebFetcher.init(this);
    }
}
