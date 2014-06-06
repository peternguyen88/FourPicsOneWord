package com.peter.fourpicsonewordcheats.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.SuperCheats;
import com.peter.fourpicsonewordcheats.event.SearchByDescriptionEvent;
import com.peter.fourpicsonewordcheats.event.SearchByLettersEvent;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/6/2014.
 */
@EFragment(R.layout.fragment_search_by_letters)
public class SearchByLettersFragment extends Fragment{

    public static SearchByLettersFragment instance(){
        return new SearchByLettersFragment_();
    }

    @ViewById(R.id.search_letters)
    EditText search_letters;

    @Click(R.id.search_button)
    protected void search(){
        SuperCheats.eventBus.post(new SearchByLettersEvent(search_letters.getText().toString()));
    }
}
