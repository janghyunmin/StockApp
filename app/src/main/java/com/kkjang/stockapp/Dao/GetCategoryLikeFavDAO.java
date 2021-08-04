package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.GetCategoryLikeFavDAOList;

import java.util.List;

public class GetCategoryLikeFavDAO extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<GetCategoryLikeFavDAOList> list = null;

    public List<GetCategoryLikeFavDAOList> getList() {
        return list;
    }

    public void setList(List<GetCategoryLikeFavDAOList> list) {
        this.list = list;
    }
}

