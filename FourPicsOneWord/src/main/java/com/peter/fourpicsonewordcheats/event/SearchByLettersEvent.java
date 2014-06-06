package com.peter.fourpicsonewordcheats.event;

/**
 * Created by Peter on 6/6/2014.
 */
public class SearchByLettersEvent {
    private String letters;

    public SearchByLettersEvent(String letters) {
        this.letters = letters;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
