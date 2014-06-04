package com.peter.fourpicsonewordcheats.model;

import com.google.common.collect.ComparisonChain;

/**
 * Created by Peter on 6/3/2014.
 */
public class Word implements Comparable<Word> {
    private String level;
    private String word;
    private int length;
    private String hint;

    public Word(String level, String word, int length, String hint) {
        this.level = level;
        this.word = word;
        this.length = length;
        this.hint = hint;
    }

    public String getLevel() {
        return level;
    }

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public String getHint() {
        return hint;
    }

    public String getFileName(){
        return "file:///android_asset/"+level+".jpg";
    }

    @Override
    public int compareTo(Word another) {
        return ComparisonChain.start().compare(this.level, another.level).result();
    }
}
