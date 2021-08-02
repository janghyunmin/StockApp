package com.kkjang.stockapp.Bottom.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.R;
import com.kkjang.stockapp.databinding.FragmentHomeBinding;
import com.kkjang.stockapp.util.Division;
import com.kkjang.stockapp.util.LogUtil;
import com.kkjang.stockapp.view.refresh.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;

public class HomeFragment extends Fragment implements View.OnClickListener{

    public FragmentHomeBinding binding;
    HomeViewModel homeViewModel;

    boolean chk = false;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        View root = binding.getRoot();
        context = getActivity();

        binding.slideLayoutVisible.setOnClickListener(this);
        binding.slideLayoutGone.setOnClickListener(this);



        initView();


//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    public void initView(){

//        binding.contentViewPager.setAdapter(new RootFavoritesAdapter(getFragmentManager()));
//        binding.contentViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.topLayout));

        SinaRefreshView refreshView = new SinaRefreshView(context);
        refreshView.setArrowResource(R.drawable.anim_loading_view);
        refreshView.setPullDownStr("땡겨지는중 ㅠㅠ..");
        refreshView.setTextColor(0xff745D5C);
        binding.refresh.setHeaderView(refreshView);

        LoadingView loadingView = new LoadingView(context);
        binding.refresh.setBottomView(loadingView);
        binding.refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishRefreshing();
                    }
                },2000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.finishLoadmore();
                    }
                },2000);
            }
        });

        binding.topLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtil.logE("tab position : " + tab.getPosition());
//                binding.contentViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case Division.VIEW_ITEM_0:

                        binding.leftLayout.setVisibility(View.VISIBLE);
                        binding.rightLayout.setVisibility(View.GONE);

                        break;
                    case Division.VIEW_ITEM_1:
                        binding.leftLayout.setVisibility(View.GONE);
                        binding.rightLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        binding.rootTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtil.logE("tab position 두번째 : " + tab.getPosition());
                switch (tab.getPosition()){
                    case Division.VIEW_ITEM_0:
                        binding.rootLeftLayout.setVisibility(View.VISIBLE);
                        binding.rootRightLayout.setVisibility(View.GONE);





                        break;
                    case Division.VIEW_ITEM_1:
                        binding.rootLeftLayout.setVisibility(View.GONE);
                        binding.rootRightLayout.setVisibility(View.VISIBLE);
                        break;
                }
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
            case R.id.slide_layout_visible:
                chk = true;
                binding.slideLayoutVisible.setVisibility(View.GONE);
                binding.slideLayoutGone.setVisibility(View.VISIBLE);

                break;

            case R.id.slide_layout_gone:
                chk = false;
                binding.slideLayoutVisible.setVisibility(View.VISIBLE);
                binding.slideLayoutGone.setVisibility(View.GONE);
                break;
        }


    }
}