package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kkjang.stockapp.DataModel.ResultMarketConditionsDAOList;

import java.util.List;

public class ResultMarketConditionsDAO extends BaseDAO{

    @SerializedName("list")
    @Expose
    private List<ResultMarketConditionsDAOList> list = null;

    public List<ResultMarketConditionsDAOList> getList() {
        return list;
    }

    public void setList(List<ResultMarketConditionsDAOList> list) {
        this.list = list;
    }

}
