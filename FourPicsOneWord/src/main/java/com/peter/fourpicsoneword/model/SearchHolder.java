package com.peter.fourpicsoneword.model;

/**
 * Created by Peter on 6/12/2014.
 */
public class SearchHolder {
    private String description;
    private String letters;

    public SearchHolder(String description, String letters) {
        this.description = description;
        this.letters = letters;
    }

    public SearchHolder() {
        this(null,null);
    }

    public String getDescription() {
        return description;
    }

    public String getLetters() {
        return letters;
    }

    public void clear(){
        this.description = null;
        this.letters = null;
    }
}
