package com.peter.fourpicsonewordcheats.model;

/**
 * Created by Peter on 6/3/2014.
 */
public class WordListItem {
    public WordListItem(int length, String description) {
        this.length = length;
        this.description = description;
    }

    private int length;
    private String description;

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
