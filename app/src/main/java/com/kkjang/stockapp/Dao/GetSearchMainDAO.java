package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSearchMainDAO extends  BaseDAO{

    @SerializedName("list")
    @Expose
    private List<GetSearchMainDAOList> list = null;

    public List<GetSearchMainDAOList> getList() {
        return list;
    }

    public void setList(List<GetSearchMainDAOList> list) {
        this.list = list;
    }

}
