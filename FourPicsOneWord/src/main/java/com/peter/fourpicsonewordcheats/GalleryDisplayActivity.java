package com.peter.fourpicsonewordcheats;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.adapter.GalleryImagesAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_gallery_display)
public class GalleryDisplayActivity extends ActionBarActivity {
    @Extra
    String actionBarTitle;

    @AfterViews
    protected void setTitle(){
        this.getActionBar().setTitle(actionBarTitle);
    }

    @Bean
    GalleryImagesAdapter imagesAdapter;
    @ViewById(R.id.cards_listview)
    ListView image_gallery;

    @AfterViews
    protected void bindAdapter(){
        image_gallery.setAdapter(imagesAdapter);
    }
}
