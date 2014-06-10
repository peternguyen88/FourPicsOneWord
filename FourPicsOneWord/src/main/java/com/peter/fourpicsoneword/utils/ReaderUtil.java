package com.peter.fourpicsoneword.utils;

import android.app.Application;

import com.peter.fourpicsoneword.ContentProvider;
import com.peter.fourpicsoneword.constant.SystemConstant;
import com.peter.fourpicsoneword.model.Word;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Peter on 6/3/2014.
 */
public class ReaderUtil {
    public static Word readLine(String line){
        if(StringUtils.isEmpty(line)) return null;
        String[] elements = line.split(SystemConstant.RESULT_SEPARATOR);
        String level = elements[0];
        String word = elements[1];
        int length = Integer.parseInt(elements[2]);
        String hint = elements[3];
        return new Word(level,word,length,hint);
    }

    public static void loadWord(Application application){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(application.getAssets().open("result.txt")));
            // do reading, usually loop until end of file reading
            String mLine = reader.readLine();
            while (mLine != null) {
                //process line
                Word word = ReaderUtil.readLine(mLine);
                ContentProvider.wordMap.put(word.getLength(), word);
                // Reading Next Line
                mLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
