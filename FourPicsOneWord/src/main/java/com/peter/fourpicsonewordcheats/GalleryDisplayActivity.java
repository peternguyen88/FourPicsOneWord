package com.peter.fourpicsonewordcheats;

import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

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
    @ViewById(R.id.image_gallery)
    GridView image_gallery;

    @AfterViews
    protected void bindAdapter(){
        image_gallery.setAdapter(imagesAdapter);
    }
}
