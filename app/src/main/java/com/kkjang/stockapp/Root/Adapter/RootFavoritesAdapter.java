package com.kkjang.stockapp.Root.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.kkjang.stockapp.Root.RootFavoritesFragment;

import java.util.ArrayList;
import java.util.List;

public class RootFavoritesAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragments=new ArrayList<>();

    public RootFavoritesAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new RootFavoritesFragment());
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
