package com.peter.fourpicsoneword;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.nhaarman.listviewanimations.swinginadapters.prepared.ScaleInAnimationAdapter;
import com.peter.fourpicsoneword.adapter.LetterSelectAdapter;
import com.peter.fourpicsoneword.model.Word;
import com.peter.fourpicsoneword.model.WordListItem;
import com.peter.fourpicsoneword.utils.AdUtils;
import com.peter.fourpicsoneword.utils.ReaderUtil;

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
import java.util.Random;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends ActionBarActivity {
    public static final String AdUnitId = "ca-app-pub-5196353855654242/4308385613";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @ViewById(R.id.card_list_number_of_letters)
    ListView cardListView;

    @Bean
    LetterSelectAdapter letterSelectAdapter;

    private InterstitialAd interstitial;
    private InterstitialAd interstitialOnExit;

    private final Random random = new Random();

    @AfterInject
    protected void interstitialAds(){
        if(random.nextBoolean()) {
            loadStartingAdWith50Probability();
        }
        preLoadExitingAd();
    }

    private void loadStartingAdWith50Probability() {
        this.interstitial = new InterstitialAd(this);
        this.interstitial.setAdUnitId(AdUnitId);
        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);

        // Set the AdListener.
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Log.d(LOG_TAG, "onAdLoaded");
                interstitial.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                String message = String.format("onAdFailedToLoad (%s)", AdUtils.getErrorReason(errorCode));
                Log.d(LOG_TAG, message);
            }

        });
    }

    private void preLoadExitingAd(){
        this.interstitialOnExit = new InterstitialAd(this);
        this.interstitialOnExit.setAdUnitId(AdUnitId);

        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitialOnExit.loadAd(adRequest);
    }

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
    protected void setAutoRestart() {
        Thread.setDefaultUncaughtExceptionHandler(new AutoRestartWhenCrash(this, MainActivity_.class));
    }

    @ItemClick(R.id.card_list_number_of_letters)
    protected void listItemSelect(WordListItem item) {
        ContentProvider.currentIndex = item.getLength();
        GalleryDisplayActivity_.intent(this).actionBarTitle(item.getDescription()).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if(this.interstitialOnExit!=null && this.interstitialOnExit.isLoaded()){
            this.interstitialOnExit.show();
        }
        super.onBackPressed();
    }
}
