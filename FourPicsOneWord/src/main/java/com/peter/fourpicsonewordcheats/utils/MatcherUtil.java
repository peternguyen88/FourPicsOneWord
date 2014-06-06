package com.peter.fourpicsonewordcheats.utils;

import com.google.common.primitives.Chars;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Peter on 6/6/2014.
 */
public class MatcherUtil {
    /**
     * Matching if a word is a combination of letters provided
     * @param word Word to be search
     * @param letters Collection of letters
     * @return true if all characters in the word contained in letters
     */
    public static boolean lettersMatch(String word, String letters){
        List<Character> letterArray = new ArrayList<Character>(Chars.asList(letters.toLowerCase().toCharArray()));
        List<Character> strList = new ArrayList<Character>(Chars.asList(word.toLowerCase().toCharArray()));
        for(Character character : strList){
            if(!letterArray.remove(character)){
                return false;
            }
        }
        return true;
    }
}
