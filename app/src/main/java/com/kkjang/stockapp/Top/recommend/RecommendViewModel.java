package com.kkjang.stockapp.Top.recommend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendViewModel  extends ViewModel {
    private MutableLiveData<String> mText;

    public RecommendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("무료종목추천 탭");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
