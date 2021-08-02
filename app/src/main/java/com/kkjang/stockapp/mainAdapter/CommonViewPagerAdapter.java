package com.kkjang.stockapp.mainAdapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kkjang.stockapp.Bottom.favorites.FavoritesFragment;
import com.kkjang.stockapp.Bottom.home.HomeFragment;
import com.kkjang.stockapp.Bottom.more.MoreFragment;
import com.kkjang.stockapp.Bottom.question.QuestionFragment;
import com.kkjang.stockapp.Bottom.revenue.RevenueFragment;
import com.kkjang.stockapp.Root.RootFavoritesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * jhm
 * @class ViewPagerAdapter
 * @date 2021-07-19
 * @time 오후 2:18
 **/

/** jhm 2021-07-19 오후 2:18
 * Common ViewPagerAdapter
 ***/
public class CommonViewPagerAdapter extends FragmentStatePagerAdapter {
    int Viewtype;
    List<Fragment> fragments=new ArrayList<>();

    public CommonViewPagerAdapter(FragmentManager fm, int ViewType) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.Viewtype = ViewType;

        fragments.add(new HomeFragment());                  /** jhm 2021-07-19 오후 2:48 Home , 급등 관련주 공통 ***/
//        fragments.add(new TodayFragment());                 /** jhm 2021-07-19 오후 2:48 오늘시황 ***/
//        fragments.add(new AnalysisFragment());              /** jhm 2021-07-19 오후 2:48 종목분석 ***/
//        fragments.add(new RecommendFragment());             /** jhm 2021-07-19 오후 2:48 무료종목추천 ***/
        fragments.add(new FavoritesFragment());             /** jhm 2021-07-19 오후 2:48 즐겨찾기 ***/
        fragments.add(new RevenueFragment());               /** jhm 2021-07-19 오후 2:48 수익인증 ***/
        fragments.add(new QuestionFragment());               /** jhm 2021-07-19 오후 2:48 1:1 문의 ***/
        fragments.add(new MoreFragment());                  /** jhm 2021-07-19 오후 2:48 더보기 ***/

    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}