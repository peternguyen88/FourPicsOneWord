package com.peter.fourpicsonewordcheats.view.fragment;

import android.support.v4.app.DialogFragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.constant.SystemConstant;
import com.peter.fourpicsonewordcheats.model.Word;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/5/2014.
 */
@EFragment(R.layout.fragment_word_view_popup)
public class ImageViewDialogFragment extends DialogFragment{

    public static ImageViewDialogFragment instance(Word word){
        ImageViewDialogFragment popup = new ImageViewDialogFragment_();
        popup.setRetainInstance(true);
        popup.setWord(word);
        return popup;
    }

    @AfterViews
    protected void setTitle(){
        this.getDialog().setTitle("Hints");
    }

    @ViewById(R.id.firstDesc)
    TextView firstDesc;

    @ViewById(R.id.secondDesc)
    TextView secondDesc;

    @ViewById(R.id.thirdDesc)
    TextView thirdDesc;

    @ViewById(R.id.forthDesc)
    TextView forthDesc;

    @ViewById(R.id.image)
    ImageView imageView;

    Word word;

    private void setWord(Word word){
        this.word = word;
    }

    @AfterViews
    protected void renderHints(){
        String[] hints = word.getHint().split(SystemConstant.HINT_SEPARATOR);
        try {
            firstDesc.setText(hints[0]);
            secondDesc.setText(hints[1]);
            thirdDesc.setText(hints[2]);
            forthDesc.setText(hints[3]);
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    @AfterViews
    protected void renderImage(){
        Picasso.with(getActivity()).load(word.getFileName()).into(imageView);
    }
}
