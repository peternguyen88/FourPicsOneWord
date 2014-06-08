package com.peter.fourpicsoneword;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.peter.fourpicsoneword.model.Word;
import com.peter.fourpicsoneword.model.WordListItem;
import com.peter.fourpicsoneword.utils.MatcherUtil;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/3/2014.
 */
public class ContentProvider {
    public static ListMultimap<Integer, Word> wordMap = ArrayListMultimap.create();
    public static List<WordListItem> numberOfWords = new ArrayList<WordListItem>();
    public static int currentIndex = 3;
    public static FilterMode filterMode;

    private static List<Word> getWordListByDescription(String description) {
        if (StringUtils.isEmpty(description))
            return wordMap.get(currentIndex);
        else {
            List<Word> result = new ArrayList<Word>();
            for (Word word : wordMap.get(currentIndex)) {
                if (StringUtils.containsIgnoreCase(word.getHint(), description)) {
                    result.add(word);
                }
            }
            return result;
        }
    }

    private static List<Word> getWordListByLetters(String letters) {
        if (StringUtils.isEmpty(letters)) return wordMap.get(currentIndex);
        else {
            List<Word> result = new ArrayList<Word>();
            for (Word word : wordMap.get(currentIndex)) {
                if (MatcherUtil.lettersMatch(word.getWord(), letters)) {
                    result.add(word);
                }
            }
            return result;
        }
    }

    public static List<Word> getWordList(String constrain) {
        switch (filterMode) {
            case BY_DESCRIPTION:
                return getWordListByDescription(constrain);
            case BY_LETTERS:
                return getWordListByLetters(constrain);
            default:
                return new ArrayList<Word>();
        }
    }


    public enum FilterMode {
        BY_DESCRIPTION, BY_LETTERS
    }
}
