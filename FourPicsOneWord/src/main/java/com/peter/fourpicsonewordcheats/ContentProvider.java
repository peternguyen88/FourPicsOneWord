package com.peter.fourpicsonewordcheats;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.model.WordListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/3/2014.
 */
public class ContentProvider {
    public static Multimap<Integer,Word> wordMap = ArrayListMultimap.create();
    public static List<WordListItem> numberOfWords = new ArrayList<WordListItem>();
}
