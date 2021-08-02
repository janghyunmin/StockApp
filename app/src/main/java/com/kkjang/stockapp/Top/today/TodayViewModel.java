package com.kkjang.stockapp.Top.today;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodayViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TodayViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("오늘시황 탭");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

