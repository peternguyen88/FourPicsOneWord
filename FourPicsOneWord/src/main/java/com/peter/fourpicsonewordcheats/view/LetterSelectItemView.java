package com.peter.fourpicsonewordcheats.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peter.fourpicsoneword.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/4/2014.
 */
@EViewGroup(R.layout.view_letter_select_item)
public class LetterSelectItemView extends LinearLayout {
    public LetterSelectItemView(Context context) {
        super(context);
    }

    public LetterSelectItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LetterSelectItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @ViewById(R.id.textView)
    TextView textView;
    public void setText(String text){
        this.textView.setText(text);
    }

    @ViewById(R.id.mainLayout)
    LinearLayout mainLayout;
    public void setBackground(int backgroundID){
        this.mainLayout.setBackgroundResource(backgroundID);
    }
}
