package com.peter.fourpicsonewordcheats;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;
import com.google.common.eventbus.Subscribe;
import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.adapter.GalleryImagesAdapter;
import com.peter.fourpicsonewordcheats.adapter.SearchViewAdapter;
import com.peter.fourpicsonewordcheats.event.SearchByDescriptionEvent;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.view.fragment.ImageViewDialogFragment;
import com.peter.fourpicsonewordcheats.view.fragment.SearchDialogFragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_gallery_display)
@OptionsMenu(R.menu.gallery_display)
public class GalleryDisplayActivity extends ActionBarActivity {

    @AfterInject
    protected void registerToEventBus(){
        SuperCheats.eventBus.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SuperCheats.eventBus.unregister(this);
    }

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

    @ItemClick(R.id.image_gallery)
    protected void showAnswer(Word word){
        ImageViewDialogFragment.instance(word).show(getSupportFragmentManager(), "Image View Fragment");
    }

    @OptionsItem(R.id.menu_search)
    protected void searchMenuClicked(){
        SearchDialogFragment.instance().show(getSupportFragmentManager(),"Search View Fragment");
    }

    @Subscribe
    public void filterByDescription(SearchByDescriptionEvent event){
        String description = event.getDescription();
        imagesAdapter.getFilter().filter(description);
    }
}
