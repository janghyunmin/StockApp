package com.kkjang.stockapp.Bottom.more;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MoreViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MoreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("더보기 탭");
    }

    public LiveData<String> getText() {
        return mText;
    }
    
}
