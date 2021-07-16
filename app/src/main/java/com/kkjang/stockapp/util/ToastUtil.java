package com.kkjang.stockapp.util;

import android.content.Context;
import android.widget.Toast;

/**
 * jhm
 * @class ToastUtil
 * @date 2021-07-07
 * @time 오후 3:51
 * Toast 처리시 공통
 **/
public class ToastUtil {
    private static Toast toast;


    public static void toast(Context ctx, Context baseCtx, String msg) {
        if(android.os.Build.VERSION.SDK_INT >= 26){
            toast(ctx, msg);
        }else{
            toast(baseCtx, msg);
        }
    }


    public static void toast(Context ctx, String msg) {
        if (null == toast) toast = toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
        else toast.setText(msg);
        toast.show();
    }


    public static void toast(Context ctx, int strId) {
        toast(ctx, ctx.getString(strId));
    }

    public static Toast getToast() {
        return toast;
    }
}
