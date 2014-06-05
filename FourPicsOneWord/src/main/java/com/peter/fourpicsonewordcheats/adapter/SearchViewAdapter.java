package com.peter.fourpicsonewordcheats.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.peter.fourpicsonewordcheats.view.fragment.SearchByDescriptionFragment;

/**
 * Created by Peter on 6/6/2014.
 */
public class SearchViewAdapter extends FragmentPagerAdapter {

    public SearchViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SearchByDescriptionFragment.instance();
            case 1:
                return SearchByDescriptionFragment.instance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "By Description";
            case 1:
                return "By Letters";
            default:
                return null;
        }
    }
}
