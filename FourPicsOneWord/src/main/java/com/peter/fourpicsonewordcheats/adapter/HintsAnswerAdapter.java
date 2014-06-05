package com.peter.fourpicsonewordcheats.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.view.fragment.AnswerFragment;
import com.peter.fourpicsonewordcheats.view.fragment.HintsFragment;

/**
 * Created by Peter on 6/5/2014.
 */
public class HintsAnswerAdapter extends FragmentPagerAdapter {
    Word word;

    public HintsAnswerAdapter(FragmentManager fm, Word word) {
        super(fm);
        this.word = word;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Hints";
            case 1:
                return "Answer";
            default:
                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HintsFragment.instance(word);
            case 1:
                return AnswerFragment.instance(word);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
