package com.kkjang.stockapp.mainAdapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.Bottom.favorites.FavoritesFragment;
import com.kkjang.stockapp.Bottom.home.HomeFragment;
import com.kkjang.stockapp.Bottom.more.MoreFragment;
import com.kkjang.stockapp.Bottom.question.QuestionFragment;
import com.kkjang.stockapp.Bottom.revenue.RevenueFragment;

import java.util.ArrayList;

public class ViewModel {

    private FragmentStatePagerAdapter viewPagerAdapter;
    private TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener;
    private TabLayout.TabLayoutOnPageChangeListener tabLayoutOnTopPageChangeListener;

    public ViewModel(FragmentManager fm,
                     TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener,
                     TabLayout.TabLayoutOnPageChangeListener tabLayoutOnTopPageChangeListener
    ) {
        this.viewPagerOnTabSelectedListener = viewPagerOnTabSelectedListener;
        this.tabLayoutOnTopPageChangeListener = tabLayoutOnTopPageChangeListener;


        // ViewPagerAdapter 생성
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());                  /** jhm 2021-07-19 오후 2:48 Home , 급등 관련주 공통 ***/
//        fragments.add(new TodayFragment());                 /** jhm 2021-07-19 오후 2:48 오늘시황 ***/
//        fragments.add(new AnalysisFragment());              /** jhm 2021-07-19 오후 2:48 종목분석 ***/
//        fragments.add(new RecommendFragment());             /** jhm 2021-07-19 오후 2:48 무료종목추천 ***/
        fragments.add(new FavoritesFragment());             /** jhm 2021-07-19 오후 2:48 즐겨찾기 ***/
        fragments.add(new RevenueFragment());               /** jhm 2021-07-19 오후 2:48 수익인증 ***/
        fragments.add(new QuestionFragment());               /** jhm 2021-07-19 오후 2:48 1:1 문의 ***/
        fragments.add(new MoreFragment());                  /** jhm 2021-07-19 오후 2:48 더보기 ***/

        viewPagerAdapter = new ViewPagerAdapter(fm, fragments);
    }

    public FragmentStatePagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public TabLayout.ViewPagerOnTabSelectedListener getViewPagerOnTabSelectedListener() {
        return viewPagerOnTabSelectedListener;
    }

    public TabLayout.TabLayoutOnPageChangeListener getTabLayoutOnTopPageChangeListener() {
        return tabLayoutOnTopPageChangeListener;
    }


}
