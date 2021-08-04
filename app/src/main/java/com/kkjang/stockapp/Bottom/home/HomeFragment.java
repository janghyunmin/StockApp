package com.kkjang.stockapp.Bottom.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.tabs.TabLayout;
import com.kkjang.stockapp.Adapter.SpotUpAdapter.SpotUpAdapter;
import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.Network.Http.Util_osj;
import com.kkjang.stockapp.R;
import com.kkjang.stockapp.databinding.FragmentHomeBinding;
import com.kkjang.stockapp.util.Division;
import com.kkjang.stockapp.util.LogUtil;
import com.kkjang.stockapp.util.ToastUtil;
import com.kkjang.stockapp.view.refresh.header.SinaRefreshView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{

    public FragmentHomeBinding binding;
    HomeViewModel homeViewModel;
    SpotUpAdapter spotUpAdapter;

    boolean chk = false;
    Context context;
    int pageNumber = 0;
    boolean lastPageState = false;
    /** jhm 2021-08-03 오후 5:47 * arraylist  ***/
    ArrayList<SpotUpDAO.SpotUpDAOList> spotUpDAOListArrayList = new ArrayList<SpotUpDAO.SpotUpDAOList>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        View root = binding.getRoot();
        context = getActivity();

        binding.slideLayoutVisible.setOnClickListener(this);
        binding.slideLayoutGone.setOnClickListener(this);




        Handler handler = new Handler(){
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                binding.ShimmerViewContainer.stopShimmerAnimation();
                binding.ShimmerViewContainer.setVisibility(View.GONE);
                initView();
            }
        };
        handler.sendEmptyMessageDelayed(0,3000);




//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.ShimmerViewContainer.startShimmerAnimation();

    }

    @Override
    public void onPause() {
        super.onPause();
        binding.ShimmerViewContainer.setVisibility(View.GONE);
        binding.ShimmerViewContainer.stopShimmerAnimation();
    }

    public void initView(){

        /** jhm 2021-08-03 오후 2:44
         * recycler view loading
         ***/
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
                        ToastUtil.toast(context,"Top 입니다.");
                        pageNumber = 0;
                        lastPageState = false;
                        initPotList();
                    }
                },2000);
            }
            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if(lastPageState){
                            ToastUtil.toast(context,"불러올 데이터가 없습니다.");
                            refreshLayout.finishLoadmore();
                        }else{
                            ToastUtil.toast(context,"바텀입니다.");
                            refreshLayout.finishLoadmore();

                            //팟 리스트 데이터 추가
                            addPotList();
                        }

                    }
                },2000);
            }

        });

        initPotList();
        setUpRecyclerView();








        /** jhm 2021-08-03 오후 2:45 
         * 급등관련주 탭
         ***/
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



    public void setUpRecyclerView(){
        if(spotUpAdapter == null){
            spotUpAdapter = new SpotUpAdapter(spotUpDAOListArrayList,context);
            binding.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
            binding.recyclerView.setAdapter(spotUpAdapter);
            binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            binding.recyclerView.setNestedScrollingEnabled(true);
        }else{
            spotUpAdapter.notifyDataSetChanged();
        }
    }

    void initPotList(){
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getSpotData(Util_osj.getAndroidId(getActivity())).observe(getActivity(), spotResponse -> {
            List<SpotUpDAO.SpotUpDAOList> spotUpDaos = spotResponse.getList();
            LogUtil.logE("size : " + spotUpDaos.size());
            spotUpDAOListArrayList.addAll(spotUpDaos);
            spotUpAdapter.notifyDataSetChanged();
        });
    }
    void addPotList() {
        pageNumber++;
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        homeViewModel.getSpotData(Util_osj.getAndroidId(getActivity())).observe(getActivity(), spotResponse -> {
            List<SpotUpDAO.SpotUpDAOList> spotUpDaos = spotResponse.getList();
            List<SpotUpDAO.SpotUpDAOList> tempList = new ArrayList<>();
            for(int i = 0; i < spotUpDaos.size(); i++){
                if(i < 6)
                    tempList.add((SpotUpDAO.SpotUpDAOList) spotResponse.getList());
                else break;
            }
            spotUpDAOListArrayList.addAll(spotUpDaos);
            spotUpAdapter.notifyDataSetChanged();
        });
    }


}