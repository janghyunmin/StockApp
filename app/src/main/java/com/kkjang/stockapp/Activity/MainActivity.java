package com.kkjang.stockapp.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.R;

import com.kkjang.stockapp.databinding.ActivityMainBinding;
import com.kkjang.stockapp.Adapter.CommonViewPagerAdapter;
import com.kkjang.stockapp.util.Division;
import com.kkjang.stockapp.util.LogUtil;
import com.kkjang.stockapp.util.StatusBarCustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * jhm
     * @class MainActivity
     * @date 2021-07-07
     * @time 오후 3:43
     **/


    /** jhm 2021-07-07 오후 3:44 **/
    /** 공통 **/
    Context context;
    public ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        /** jhm 2021-07-07 오후 3:48  navigationView 초기화 **/
        Debuging();
        initView();

    }
    public void Debuging(){
        // OkHttp 3.x 버전
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        Stetho.initializeWithDefaults(this);
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    public void initView(){
        /** jhm 2021-07-27 오후 2:24
         * StatusBar Custom
         ***/
        StatusBarCustom.setStatusBarColor(this,StatusBarCustom.StatusBarColorType.BLACK_STATUS_BAR);
//
//        viewModel = new ViewModel(getSupportFragmentManager(),
//                new TabLayout.ViewPagerOnTabSelectedListener((ViewPager)findViewById(R.id.content_viewPager)),
//                new TabLayout.TabLayoutOnPageChangeListener((TabLayout)findViewById(R.id.bottom_tabLayout))
//        );
//
//        mainBinding.setLifecycleOwner(this);
//        mainBinding.setViewModel(viewModel);

        mainBinding.textHome.setSelected(true);

        mainBinding.textHome.setOnClickListener(this);
        mainBinding.textToday.setOnClickListener(this);
        mainBinding.textAnalysis.setOnClickListener(this);
        mainBinding.textRecommend.setOnClickListener(this);




        mainBinding.contentViewPager.setAdapter(new CommonViewPagerAdapter(getSupportFragmentManager(), Division.VIEW_ITEM_0));
        mainBinding.contentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainBinding.bottomTabLayout));
        mainBinding.bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainBinding.textHome.setSelected(false);
                mainBinding.textToday.setSelected(false);
                mainBinding.textAnalysis.setSelected(false);
                mainBinding.textRecommend.setSelected(false);

                mainBinding.contentViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_home:
                LogUtil.logE("급등관련주");
                mainBinding.textHome.setSelected(true);
                mainBinding.textToday.setSelected(false);
                mainBinding.textAnalysis.setSelected(false);
                mainBinding.textRecommend.setSelected(false);
                break;

            case R.id.text_today:
                LogUtil.logE("오늘시황");
                mainBinding.textHome.setSelected(false);
                mainBinding.textToday.setSelected(true);
                mainBinding.textAnalysis.setSelected(false);
                mainBinding.textRecommend.setSelected(false);
                break;

            case R.id.text_analysis:
                LogUtil.logE("종목분석");
                mainBinding.textHome.setSelected(false);
                mainBinding.textToday.setSelected(false);
                mainBinding.textAnalysis.setSelected(true);
                mainBinding.textRecommend.setSelected(false);
                break;

            case R.id.text_recommend:
                LogUtil.logE("무료종목추천");
                mainBinding.textHome.setSelected(false);
                mainBinding.textToday.setSelected(false);
                mainBinding.textAnalysis.setSelected(false);
                mainBinding.textRecommend.setSelected(true);
                break;
        }
    }

}