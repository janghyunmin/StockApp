package com.kkjang.stockapp.Bottom.question;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuestionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("1:1문의 탭");
    }

    public LiveData<String> getText() {
        return mText;
    }
    
    
}
