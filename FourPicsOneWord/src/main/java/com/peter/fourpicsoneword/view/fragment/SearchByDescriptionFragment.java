package com.peter.fourpicsoneword.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.EditText;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsoneword.SuperCheats;
import com.peter.fourpicsoneword.event.SearchByDescriptionEvent;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/6/2014.
 */
@EFragment(R.layout.fragment_search_by_description)
public class SearchByDescriptionFragment extends Fragment {

    public static SearchByDescriptionFragment instance(){
        return new SearchByDescriptionFragment_();
    }

    @ViewById(R.id.search_description)
    EditText search_description;

    @Click(R.id.search_button)
    protected void search(){
        SuperCheats.eventBus.post(new SearchByDescriptionEvent(search_description.getText().toString()));
    }
}
