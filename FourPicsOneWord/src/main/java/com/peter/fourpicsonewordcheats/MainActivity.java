package com.peter.fourpicsonewordcheats;

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.nhaarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.peter.fourpicsoneword.R;
import com.peter.fourpicsonewordcheats.adapter.LetterSelectAdapter;
import com.peter.fourpicsonewordcheats.model.Word;
import com.peter.fourpicsonewordcheats.model.WordListItem;
import com.peter.fourpicsonewordcheats.utils.ReaderUtil;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.card_list_number_of_letters)
    ListView cardListView;

    @Bean
    LetterSelectAdapter letterSelectAdapter;

    @AfterViews
    protected void bindAdapter() {
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(letterSelectAdapter);
        scaleInAnimationAdapter.setAbsListView(cardListView);
        cardListView.setAdapter(scaleInAnimationAdapter);
    }

    @AfterInject
    protected void initNumberOfWordsList() {
        ContentProvider.numberOfWords = new ArrayList<WordListItem>();
        for (int i = 3; i <= 8; i++) {
            ContentProvider.numberOfWords.add(new WordListItem(i, i + " Letter Words", WordListItem.colors[i - 3]));
        }
        letterSelectAdapter.bindAdapter();
        letterSelectAdapter.notifyDataSetChanged();
    }

    @AfterInject
    @Background
    protected void loadWordList() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("result.txt")));
            // do reading, usually loop until end of file reading
            String mLine = reader.readLine();
            while (mLine != null) {
                //process line
                Word word = ReaderUtil.readLine(mLine);
                ContentProvider.wordMap.put(word.getLength(), word);
                // Reading Next Line
                mLine = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ItemClick(R.id.card_list_number_of_letters)
    protected void listItemSelect(WordListItem item) {
        ContentProvider.currentIndex = item.getLength();
        GalleryDisplayActivity_.intent(this).actionBarTitle(item.getDescription()).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
