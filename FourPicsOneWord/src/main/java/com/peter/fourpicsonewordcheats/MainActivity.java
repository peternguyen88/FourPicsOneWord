package com.peter.fourpicsonewordcheats;

import android.support.v7.app.ActionBarActivity;

import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.model.WordListItem;
import com.peter.fourpicsonewordcheats.utils.ReaderUtil;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.card_list_number_of_letters)
    CardListView cardListView;

    @AfterViews
    protected void initCards() {
        //Init an array of Cards
        ArrayList<Card> cards = new ArrayList<Card>();
        for (WordListItem item : ContentProvider.numberOfWords) {
            Card card = new Card(this);
            card.setTitle(item.getDescription());
            cards.add(card);
        }

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);
        cardListView.setAdapter(mCardArrayAdapter);

    }

    @AfterInject
    protected void initNumberOfWordsList(){
        ContentProvider.numberOfWords = new ArrayList<WordListItem>();
        for (int i = 3; i <= 8 ; i++) {
            ContentProvider.numberOfWords.add(new WordListItem(i,i+" Letter Words"));
        }
    }

    @AfterInject
    @Background
    protected void loadWordList(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("result.txt")));
            // do reading, usually loop until end of file reading
            String mLine = reader.readLine();
            while (mLine != null) {
                //process line
                Word word = ReaderUtil.readLine(mLine);
                ContentProvider.wordMap.put(word.getLength(),word);
                // Reading Next Line
                mLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
