package com.peter.fourpicsonewordcheats.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peter.fourpicsoneword.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/4/2014.
 */
@EViewGroup(R.layout.view_card_list_item)
public class CardView extends LinearLayout{
    public CardView(Context context) {
        super(context);
    }

    public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @ViewById(R.id.card_text_view)
    TextView card_text_view;

    public void setTitleText(String text){
        card_text_view.setText(text);
    }
    @ViewById(R.id.card_image_view)
    ImageView card_image_view;

    public ImageView getCard_image_view() {
        return card_image_view;
    }
}
