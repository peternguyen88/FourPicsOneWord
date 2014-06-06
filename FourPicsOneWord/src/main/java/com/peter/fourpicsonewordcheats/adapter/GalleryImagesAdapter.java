package com.peter.fourpicsonewordcheats.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.peter.fourpicsonewordcheats.ContentProvider;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.view.CardView;
import com.peter.fourpicsonewordcheats.view.CardView_;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/4/2014.
 */
@EBean
public class GalleryImagesAdapter extends BaseAdapter implements Filterable{

    List<Word> wordList;

    @RootContext
    Context context;

    @AfterInject
    @Background
    public void loadWordList() {
        wordList = ContentProvider.wordMap.get(ContentProvider.currentIndex);
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
        } else {
            cardView = (CardView) convertView;
        }
        Word word = wordList.get(position);
        Picasso.with(context).load(word.getFileName()).into(cardView.getCard_image_view());
        return cardView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Word> filteredWords = ContentProvider.getWordList(constraint == null ? null :constraint.toString());

                results.count = filteredWords.size();
                results.values = filteredWords;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                wordList = (List<Word>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
