package com.kkjang.stockapp.util;

import android.Manifest;

/**
 * jhm
 * @class Division
 * @date 2021-07-07
 * @time 오후 4:26
 * 분기 변수 공통
 **/

public class Division {


    /** Permission Code **/
    public static final int PERMISSIONS_REQUEST_CODE = 100;
    public static final String[] REQUEST_PER = {
            Manifest.permission.INTERNET
            , Manifest.permission.READ_EXTERNAL_STORAGE
            , Manifest.permission.ACCESS_WIFI_STATE
            , Manifest.permission.CHANGE_WIFI_STATE
            , Manifest.permission.ACCESS_NETWORK_STATE
    };


    public static final String PERMISSION_CHECK_OK = "ok";
    public static final String PERMISSION_CHECK_NO = "no";

    /**** Retrofit 분기 변수 처리***/
   




}