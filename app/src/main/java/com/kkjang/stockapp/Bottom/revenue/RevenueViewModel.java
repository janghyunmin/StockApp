package com.kkjang.stockapp.Bottom.revenue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RevenueViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RevenueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("수익인증 탭");
    }

    public LiveData<String> getText() {
        return mText;
    }
}