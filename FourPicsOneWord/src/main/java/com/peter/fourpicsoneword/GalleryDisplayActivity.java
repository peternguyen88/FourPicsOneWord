package com.peter.fourpicsoneword;

import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.common.eventbus.Subscribe;
import com.peter.fourpicsoneword.adapter.GalleryImagesAdapter;
import com.peter.fourpicsoneword.event.SearchByDescriptionEvent;
import com.peter.fourpicsoneword.event.SearchByLettersEvent;
import com.peter.fourpicsoneword.model.SearchHolder;
import com.peter.fourpicsoneword.model.Word;
import com.peter.fourpicsoneword.view.fragment.ImageViewDialogFragment;
import com.peter.fourpicsoneword.view.fragment.SearchDialogFragment;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import de.keyboardsurfer.android.widget.crouton.Crouton;

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
        Crouton.clearCroutonsForActivity(this);
    }

    @Extra
    String actionBarTitle;

    @AfterViews
    protected void setTitle(){
        this.getActionBar().setTitle(actionBarTitle);
    }

    @ViewById(R.id.adView)
    AdView adview;

    @AfterViews
    protected void fetchAds(){
        AdRequest adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);
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
        ContentProvider.filterMode = ContentProvider.FilterMode.BY_DESCRIPTION;
        isFilterMode = true;
        imagesAdapter.getFilter().filter(description);
        ContentProvider.searchHolder = new SearchHolder(event.getDescription(),null);
    }

    @Subscribe
    public void filterByLetters(SearchByLettersEvent event){
        String letters = event.getLetters();
        ContentProvider.filterMode = ContentProvider.FilterMode.BY_LETTERS;
        isFilterMode = true;
        imagesAdapter.getFilter().filter(letters);
        ContentProvider.searchHolder = new SearchHolder(null, event.getLetters());
    }

    private boolean isFilterMode;

    @Override
    public void onBackPressed() {
        ContentProvider.searchHolder.clear();
        if(isFilterMode){
            isFilterMode = false;
            imagesAdapter.getFilter().filter(null);
        }
        else {
            super.onBackPressed();
        }
    }

    @App
    SuperCheats app;

    @AfterInject
    protected void initTracker(){
        Tracker tracker = app.getTracker();
        tracker.setScreenName("Gallery Display Activity");
        tracker.send(new HitBuilders.AppViewBuilder().build());
    }
}
