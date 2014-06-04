package com.peter.fourpicsonewordcheats.model;

import com.peter.fourpicsoneword.R;

/**
 * Created by Peter on 6/3/2014.
 */
public class WordListItem {
    public static int[] colors = {R.color.flatui_concrete,R.color.flatui_amethyst,R.color.flatui_belize_hole,
    R.color.flatui_midnight_blue,R.color.flatui_sun_flower,R.color.flatui_alizarin};

    public WordListItem(int length, String description) {
        this.length = length;
        this.description = description;
    }

    public WordListItem(int length, String description, int backgroundResourceID) {
        this.length = length;
        this.description = description;
        this.backgroundResourceID = backgroundResourceID;
    }

    private int length;
    private String description;
    private int backgroundResourceID;

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public int getBackgroundResourceID() {
        return backgroundResourceID;
    }

    @Override
    public String toString() {
        return description;
    }
}
