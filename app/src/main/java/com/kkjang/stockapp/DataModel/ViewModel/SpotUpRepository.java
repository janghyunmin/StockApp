package com.kkjang.stockapp.DataModel.ViewModel;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.Network.Retrofit.RetrofitService;
import com.kkjang.stockapp.Network.Retrofit.RetrofitModule;
import com.kkjang.stockapp.util.LogUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpotUpRepository {
    private static RetrofitService myInterface;
    private final MutableLiveData<SpotUpDAO> spotData = new MutableLiveData<>();

    private static SpotUpRepository spotUpRepository;

    public static SpotUpRepository getInstance(){
        if(spotUpRepository == null){
            spotUpRepository = new SpotUpRepository();
        }
        return spotUpRepository;
    }

    public SpotUpRepository() {
        myInterface = RetrofitModule.getService();
    }



      public MutableLiveData<SpotUpDAO> getListSpotData(String mb_id){
        Call<SpotUpDAO> spotUpDAOList = myInterface.getCategory01(mb_id);
        spotUpDAOList.enqueue(new Callback<SpotUpDAO>() {
            @Override
            public void onResponse(Call<SpotUpDAO> call, Response<SpotUpDAO> response) {
                LogUtil.logE("category body : " + response.body().getList().toString());
                spotData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SpotUpDAO> call, Throwable t) {
                    spotData.postValue(null);
            }
        });
        return spotData;
    }


}
