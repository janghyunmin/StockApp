package com.kkjang.stockapp.Activity;

import android.content.Context;
import android.os.Bundle;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.pageAdapter.TopViewModel;
import com.kkjang.stockapp.R;

import com.kkjang.stockapp.databinding.ActivityMainBinding;
import com.kkjang.stockapp.util.StatusBarCustom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
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
    public TopViewModel topViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        /** jhm 2021-07-07 오후 3:48  navigationView 초기화 **/
        initView();

    }


    public void initView(){
        BottomNavigationView navView = findViewById(R.id.bottom_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_favorites,
                R.id.navigation_revenue,
                R.id.navigation_question,
                R.id.navigation_more
        )
                .build();
        NavController navController = Navigation.findNavController(this, R.id.bottom_nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.navigateUp(navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        // OkHttp 3.x 버전
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        Stetho.initializeWithDefaults(this);

        // Status bar custom
        StatusBarCustom.setStatusBarColor(this,StatusBarCustom.StatusBarColorType.BLACK_STATUS_BAR);

        topViewModel = new TopViewModel(getSupportFragmentManager(),
                new TabLayout.ViewPagerOnTabSelectedListener((ViewPager)findViewById(R.id.content_viewPager)),
                new TabLayout.TabLayoutOnPageChangeListener((TabLayout)findViewById(R.id.top_tabLayout)));
        mainBinding.setTopViewModel(topViewModel);
    }

}