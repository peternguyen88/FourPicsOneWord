package com.peter.fourpicsoneword.view.fragment;

import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.google.common.eventbus.Subscribe;
import com.peter.fourpicsoneword.R;
import com.peter.fourpicsoneword.SuperCheats;
import com.peter.fourpicsoneword.adapter.SearchViewAdapter;
import com.peter.fourpicsoneword.event.SearchByDescriptionEvent;
import com.peter.fourpicsoneword.event.SearchByLettersEvent;
import com.peter.fourpicsoneword.model.SearchHolder;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/6/2014.
 */
@EFragment(R.layout.fragment_word_search_poup)
public class SearchDialogFragment extends DialogFragment{

    public static SearchDialogFragment instance() {
        SearchDialogFragment popup = new SearchDialogFragment_();
        popup.setRetainInstance(true);
        popup.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog);
        return popup;
    }

    SearchHolder searchHolder;

    public SearchDialogFragment lastSearch(SearchHolder searchHolder){
        this.searchHolder = searchHolder;
        return this;
    }

    @ViewById(R.id.tabs)
    PagerSlidingTabStrip tabs;

    @ViewById(R.id.pager)
    ViewPager pager;

    @AfterViews
    protected void bindViewPagerAdapter(){
        SearchViewAdapter adapter = new SearchViewAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    @AfterInject
    protected void registerToEventBus(){
        SuperCheats.eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        SuperCheats.eventBus.unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void dismiss(SearchByDescriptionEvent event){
        this.dismiss();
    }

    @Subscribe
    public void dismiss(SearchByLettersEvent event){
        this.dismiss();
    }
}
