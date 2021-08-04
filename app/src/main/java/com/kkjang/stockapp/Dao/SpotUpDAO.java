package com.kkjang.stockapp.Dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpotUpDAO extends BaseDAO{
    @SerializedName("list")
    @Expose
    private List<SpotUpDAOList> spotUpDAOList = null;

    public List<SpotUpDAOList> getList() {
        return spotUpDAOList;
    }

    public void setList(List<SpotUpDAOList> spotUpDAOList) {
        this.spotUpDAOList = spotUpDAOList;
    }

    public class SpotUpDAOList {
        @SerializedName("ca_id")
        @Expose
        private String caId;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("code_name")
        @Expose
        private String codeName;

        public String getCaId() {
            return caId;
        }

        public void setCaId(String caId) {
            this.caId = caId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCodeName() {
            return codeName;
        }

        public void setCodeName(String codeName) {
            this.codeName = codeName;
        }

        @Override
        public String toString(){
            return "Content {" +
                    "caId='" + caId + '\'' +
                    ", code='" + code + '\'' +
                    ", codeName='" + codeName + '\'' +
                    '}';
        }
    }


}


