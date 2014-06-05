package com.peter.fourpicsonewordcheats;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.model.WordListItem;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/3/2014.
 */
public class ContentProvider {
    public static ListMultimap<Integer,Word> wordMap = ArrayListMultimap.create();
    public static List<WordListItem> numberOfWords = new ArrayList<WordListItem>();
    public static int currentIndex = 3;

    public static List<Word> getWordListByDescription(String description){
        if(description==null)
            return wordMap.get(currentIndex);
        else
        {
            List<Word> result = new ArrayList<Word>();
            for(Word word : wordMap.get(currentIndex)){
                if(StringUtils.containsIgnoreCase(word.getHint(),description)){
                    result.add(word);
                }
            }
            return result;
        }
    }
}
