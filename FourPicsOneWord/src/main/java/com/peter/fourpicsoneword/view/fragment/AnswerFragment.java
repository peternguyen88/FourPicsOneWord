package com.peter.fourpicsoneword.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsoneword.model.Word;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Peter on 6/5/2014.
 */
@EFragment(R.layout.fragment_answer)
public class AnswerFragment extends Fragment {

    Word word;

    public static AnswerFragment instance(Word word){
        AnswerFragment answerFragment = new AnswerFragment_();
        answerFragment.setWord(word);
        return answerFragment;
    }

    @ViewById(R.id.answerTextView)
    TextView answer;

    @AfterViews
    protected void displayAnswer(){
        answer.setText(word.getWord());
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
