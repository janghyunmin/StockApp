package com.kkjang.stockapp.Adapter.SpotUpAdapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.R;
import com.kkjang.stockapp.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class SpotUpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<SpotUpDAO.SpotUpDAOList> spotUpDAOList;
    Context context;

    private OnLoadMoreListener onLoadMoreListener;
    private LinearLayoutManager mLinearLayoutManager;

    private boolean isMoreLoading = false;
    private int visibleThreshold = 1;
    int firstVisibleItem, visibleItemCount, totalItemCount, lastVisibleItem;

    public SpotUpAdapter(ArrayList<SpotUpDAO.SpotUpDAOList> spotUpDAOList, Context context){
        this.spotUpDAOList = spotUpDAOList;
        this.context = context;
        this.onLoadMoreListener=onLoadMoreListener;
    }
    private ItemClick itemClick;
    public interface ItemClick{
        public void onClick(int position);
    }
    public void setItemClick(ItemClick itemClick){
        this.itemClick = itemClick;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SpotUpAdapter.SpotUpViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.spotup_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof SpotUpViewHolder){
            ((SpotUpViewHolder) holder).item.setText(spotUpDAOList.get(position).getCodeName());
        }
    }

    @Override
    public int getItemCount() {
        return spotUpDAOList.size();
    }
    public class SpotUpViewHolder extends RecyclerView.ViewHolder{
        TextView item;
        public SpotUpViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
        }
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager){
        this.mLinearLayoutManager=linearLayoutManager;
    }
    public void setRecyclerView(RecyclerView mView){
        mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLinearLayoutManager.getItemCount();
                firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                LogUtil.logE("total" + totalItemCount + "");
                LogUtil.logE("visible" + visibleItemCount + "");
                LogUtil.logE("first" + firstVisibleItem + "");
                LogUtil.logE("last" + lastVisibleItem + "");

                if (!isMoreLoading && (totalItemCount - visibleItemCount)<= (firstVisibleItem + visibleThreshold)) {
                    isMoreLoading = true;
                }
            }
        });
    }
    public void addItemMore(List<SpotUpDAO.SpotUpDAOList> lst){
        spotUpDAOList.addAll(lst);
        notifyItemRangeChanged(0,spotUpDAOList.size());
    }
    public void setMoreLoading(boolean isMoreLoading) {
        this.isMoreLoading=isMoreLoading;
    }
    public void setProgressMore(final boolean isProgress) {
        if (isProgress) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    spotUpDAOList.add(null);
                    notifyItemInserted(spotUpDAOList.size() - 1);
                }
            });
        } else {
            spotUpDAOList.remove(spotUpDAOList.size() - 1);
            notifyItemRemoved(spotUpDAOList.size());
        }
    }

}
