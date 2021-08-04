package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpotUpDAOCategory2 extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<SpotUpDAOListCategory2> list = null;

    public List<SpotUpDAOListCategory2> getList() {
        return list;
    }

    public void setList(List<SpotUpDAOListCategory2> list) {
        this.list = list;
    }
}
