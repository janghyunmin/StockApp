package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.GetPushListDAOList;

import java.util.List;

public class GetPushListDAO extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<GetPushListDAOList> list = null;

    public List<GetPushListDAOList> getList() {
        return list;
    }

    public void setList(List<GetPushListDAOList> list) {
        this.list = list;
    }
}
