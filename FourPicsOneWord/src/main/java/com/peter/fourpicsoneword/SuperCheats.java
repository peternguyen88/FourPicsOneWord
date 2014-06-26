package com.peter.fourpicsoneword;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.common.eventbus.EventBus;
import com.peter.fourpicsoneword.utils.ReaderUtil;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

import java.util.HashMap;

/**
 * Created by Peter on 6/6/2014.
 */
@EApplication
public class SuperCheats extends Application {
    public static EventBus eventBus = new EventBus();

    private static final String PROPERTY_ID = "UA-51917955-2";

    @AfterInject
    @Background
    protected void injectWordList() {
        ReaderUtil.loadWord(this);
    }

    Tracker tracker;

    synchronized Tracker getTracker() {
        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            tracker = analytics.newTracker(PROPERTY_ID);
        }
        return tracker;
    }
}
