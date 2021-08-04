package com.kkjang.stockapp.Adapter.SpotUpAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kkjang.stockapp.Dao.SpotUpDAO;
import com.kkjang.stockapp.R;

import java.util.ArrayList;

public class SpotUpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<SpotUpDAO.SpotUpDAOList> spotUpDAOList;
    Context context;
    SpotUpDAO.SpotUpDAOList itemList;


    public SpotUpAdapter(ArrayList<SpotUpDAO.SpotUpDAOList> spotUpDAOList, Context context){
        this.spotUpDAOList = spotUpDAOList;
        this.context = context;
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
        itemList = spotUpDAOList.get(position);
        if(holder instanceof SpotUpViewHolder){
            ((SpotUpViewHolder) holder).item.setText(itemList.getCodeName());
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
}
