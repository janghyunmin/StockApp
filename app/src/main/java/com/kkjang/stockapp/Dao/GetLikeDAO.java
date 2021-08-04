package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.GetLikeDAOList;

import java.util.List;

public class GetLikeDAO extends  BaseDAO{

    @SerializedName("list")
    @Expose
    private List<GetLikeDAOList> list = null;

    public List<GetLikeDAOList> getList() {
        return list;
    }

    public void setList(List<GetLikeDAOList> list) {
        this.list = list;
    }
}
