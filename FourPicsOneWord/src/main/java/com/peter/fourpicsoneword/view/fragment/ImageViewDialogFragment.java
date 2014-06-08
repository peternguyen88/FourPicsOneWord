package com.peter.fourpicsoneword.view.fragment;

import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;
import com.peter.fourpicsoneword.R;
import com.peter.fourpicsoneword.adapter.HintsAnswerAdapter;
import com.peter.fourpicsoneword.model.Word;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/5/2014.
 */
@EFragment(R.layout.fragment_word_view_popup)
public class ImageViewDialogFragment extends DialogFragment {

    public static ImageViewDialogFragment instance(Word word) {
        ImageViewDialogFragment popup = new ImageViewDialogFragment_();
        popup.setRetainInstance(true);
        popup.setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog);
        popup.setWord(word);
        return popup;
    }

    Word word;

    private void setWord(Word word) {
        this.word = word;
    }


    @ViewById(R.id.pager)
    ViewPager pager;

    @ViewById(R.id.tabs)
    PagerSlidingTabStrip tabs;

    @AfterViews
    protected void bindAdapter() {
        HintsAnswerAdapter adapter = new HintsAnswerAdapter(getChildFragmentManager(), word);
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }
}
