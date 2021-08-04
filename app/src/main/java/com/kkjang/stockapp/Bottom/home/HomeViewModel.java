package com.kkjang.stockapp.Bottom.home;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.DataModel.ViewModel.SpotUpRepository;
import com.kkjang.stockapp.Network.Http.Util_osj;

public class HomeViewModel extends AndroidViewModel {
   // private MutableLiveData<String> mText;
    private final SpotUpRepository repository;
    @SuppressWarnings({"FieldCanBeLocal"})
    private MutableLiveData<SpotUpDAO> spotData = new MutableLiveData<>();
    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new SpotUpRepository();
    }

    public MutableLiveData<SpotUpDAO> getSpotData(String code_name){
        spotData = loadSpotData(code_name);
        return spotData;
    }
    private MutableLiveData<SpotUpDAO> loadSpotData(String code_name){
        return repository.getListSpotData(code_name);
    }




//    public HomeViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("홈 탭");
//
//    }

//    public LiveData<String> getText() {
//        return mText;
//    }


}