package com.peter.fourpicsonewordcheats.utils;

import com.peter.fourpicsonewordcheats.model.Word;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Peter on 6/3/2014.
 */
public class ReaderUtil {
    public static Word readLine(String line){
        if(StringUtils.isEmpty(line)) return null;
        String[] elements = line.split("#");
        String level = elements[0];
        String word = elements[1];
        int length = Integer.parseInt(elements[2]);
        String hint = elements[3];
        return new Word(level,word,length,hint);
    }
}
