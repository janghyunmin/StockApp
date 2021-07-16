package com.kkjang.stockapp.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.kkjang.stockapp.Activity.IntroActivity;
import com.kkjang.stockapp.R;
import com.kkjang.stockapp.util.Division;
import com.kkjang.stockapp.util.LogUtil;
import com.kkjang.stockapp.util.SharedPreferenceUtil;

import java.util.Objects;


public class PermissionDialog extends Dialog implements View.OnClickListener{

    Context mContext;
    TextView okBtn,cancleBtn;
    IntroActivity introActivity;


    public PermissionDialog(@NonNull Context mContext, IntroActivity activity){
        super(mContext);
        this.mContext = mContext;
        this.introActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_dialog);

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);


        // findViewById
        okBtn = findViewById(R.id.okBtn);
        cancleBtn = findViewById(R.id.cancleBtn);

        okBtn.setOnClickListener(this::onClick);
        cancleBtn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.okBtn:
                LogUtil.logE("권한 승인!");

                ActivityCompat.requestPermissions(introActivity, Division.REQUEST_PER, Division.PERMISSIONS_REQUEST_CODE);
                dismiss();

                break;
            case R.id.cancleBtn:
                LogUtil.logE("권한 취소.. App 종료..");
                SharedPreferenceUtil.getInstance(mContext).putPermission("per",Division.PERMISSION_CHECK_NO);
                dismiss();
                introActivity.finish();
                break;


        }
    }



}
