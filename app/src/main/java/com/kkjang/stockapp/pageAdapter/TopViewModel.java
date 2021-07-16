package com.kkjang.stockapp.pageAdapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.Bottom.home.HomeFragment;
import com.kkjang.stockapp.Top.jump.JumpFragment;
import com.kkjang.stockapp.Top.today.TodayFragment;

import java.util.ArrayList;

public class TopViewModel {

    private FragmentStatePagerAdapter viewPagerAdapter;
    private TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener;
    private TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener;

    public TopViewModel(FragmentManager fm,
                        TabLayout.ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener,
                        TabLayout.TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener) {
        this.viewPagerOnTabSelectedListener = viewPagerOnTabSelectedListener;
        this.tabLayoutOnPageChangeListener = tabLayoutOnPageChangeListener;

        // ViewPagerAdapter 생성
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TodayFragment());
        viewPagerAdapter = new ViewPagerAdapter(fm, fragments);
    }

    public FragmentStatePagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public TabLayout.ViewPagerOnTabSelectedListener getViewPagerOnTabSelectedListener() {
        return viewPagerOnTabSelectedListener;
    }

    public TabLayout.TabLayoutOnPageChangeListener getTabLayoutOnPageChangeListener() {
        return tabLayoutOnPageChangeListener;
    }
}
