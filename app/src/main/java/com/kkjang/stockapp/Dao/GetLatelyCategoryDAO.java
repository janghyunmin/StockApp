package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.GetLatelyCategoryDAOList;

import java.util.List;

public class GetLatelyCategoryDAO extends BaseDAO{

    @SerializedName("list")
    @Expose
    private List<GetLatelyCategoryDAOList> list = null;

    public List<GetLatelyCategoryDAOList> getList() {
        return list;
    }

    public void setList(List<GetLatelyCategoryDAOList> list) {
        this.list = list;
    }
}
