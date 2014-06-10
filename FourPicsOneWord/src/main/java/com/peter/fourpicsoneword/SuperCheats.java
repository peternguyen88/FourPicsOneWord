package com.peter.fourpicsoneword;

import android.app.Application;

import com.google.common.eventbus.EventBus;
import com.peter.fourpicsoneword.utils.ReaderUtil;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

/**
 * Created by Peter on 6/6/2014.
 */
@EApplication
public class SuperCheats extends Application{
    public static EventBus eventBus = new EventBus();

    @AfterInject
    @Background
    protected void injectWordList(){
        ReaderUtil.loadWord(this);
    }
}
