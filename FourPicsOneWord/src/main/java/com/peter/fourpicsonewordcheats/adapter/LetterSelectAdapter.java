package com.peter.fourpicsonewordcheats.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.peter.fourpicsonewordcheats.ContentProvider;
import com.peter.fourpicsonewordcheats.model.WordListItem;
import com.peter.fourpicsonewordcheats.view.LetterSelectItemView;
import com.peter.fourpicsonewordcheats.view.LetterSelectItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 6/4/2014.
 */
@EBean
public class LetterSelectAdapter extends BaseAdapter{

    @RootContext
    Context context;

    List<WordListItem> items = new ArrayList<WordListItem>();

    public void bindAdapter(){
        items = ContentProvider.numberOfWords;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public WordListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WordListItem item = items.get(position);
        LetterSelectItemView personItemView;
        if (convertView == null) {
            personItemView = LetterSelectItemView_.build(context);
            personItemView.setBackground(item.getBackgroundResourceID());
        } else {
            personItemView = (LetterSelectItemView) convertView;
        }
        personItemView.setText(item.getDescription());
        return personItemView;
    }
}
