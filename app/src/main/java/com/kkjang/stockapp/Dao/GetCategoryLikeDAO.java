package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.GetCategoryLikeDAOList;

import java.util.List;

public class GetCategoryLikeDAO extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<GetCategoryLikeDAOList> list = null;

    public List<GetCategoryLikeDAOList> getList() {
        return list;
    }

    public void setList(List<GetCategoryLikeDAOList> list) {
        this.list = list;
    }


}

