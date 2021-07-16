package com.kkjang.stockapp.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.kkjang.stockapp.R;

public class StatusBarCustom {

    public enum StatusBarColorType {
        BLACK_STATUS_BAR( R.color.black );
        private int backgroundColorId;
        StatusBarColorType(int backgroundColorId){
            this.backgroundColorId = backgroundColorId;
        }
        public int getBackgroundColorId() {
            return backgroundColorId;
        }
    }

    public static void setStatusBarColor(Activity activity, StatusBarColorType colorType) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, colorType.getBackgroundColorId()));
        }
    }


}
