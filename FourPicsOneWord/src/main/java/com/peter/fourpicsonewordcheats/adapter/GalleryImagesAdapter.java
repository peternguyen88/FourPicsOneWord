package com.peter.fourpicsonewordcheats.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.peter.fourpicsonewordcheats.ContentProvider;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.view.CardView;
import com.peter.fourpicsonewordcheats.view.CardView_;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.File;
import java.util.List;

/**
 * Created by Peter on 6/4/2014.
 */
@EBean
public class GalleryImagesAdapter extends BaseAdapter {

    List<Word> wordList;

    @RootContext
    Context context;

    @AfterInject
    protected void loadImageName() {
        wordList = ContentProvider.wordMap.get(ContentProvider.curentIndex);
    }

    @Override
    public int getCount() {
        return wordList.size();
    }

    @Override
    public Word getItem(int position) {
        return wordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardView cardView;
        if (convertView == null) {
            cardView = CardView_.build(context);
            if (position < 20) {
                Word word = wordList.get(position);
                Picasso.with(context).load(word.getFileName()).into(cardView.getCard_image_view());
            }
        } else {
            cardView = (CardView) convertView;
        }
        return cardView;
    }
}
