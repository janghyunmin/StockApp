package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpotUpDAOCategory3 extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<SpotUpDAOListCategory3> list = null;

    public List<SpotUpDAOListCategory3> getList() {
        return list;
    }

    public void setList(List<SpotUpDAOListCategory3> list) {
        this.list = list;
    }
}
