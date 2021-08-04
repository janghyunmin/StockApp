package com.kkjang.stockapp.Network.Http;

import android.content.Context;
import android.provider.Settings;

/** jhm 2021-08-03 오후 3:14
 *
 ***/
public class Util_osj {
    public static String getAndroidId(Context mContext){
        return android.provider.Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

}

