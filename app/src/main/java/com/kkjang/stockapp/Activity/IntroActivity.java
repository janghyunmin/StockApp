package com.kkjang.stockapp.Activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.snackbar.Snackbar;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.kkjang.stockapp.R;
import com.kkjang.stockapp.databinding.ActivityIntroBinding;
import com.kkjang.stockapp.util.Division;
import com.kkjang.stockapp.util.LogUtil;
import com.kkjang.stockapp.util.SharedPreferenceUtil;
import com.kkjang.stockapp.util.StatusBarCustom;
import com.kkjang.stockapp.util.ToastUtil;
import com.kkjang.stockapp.view.PermissionDialog;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    /**
     * jhm
     * @class IntroActivity
     * @date 2021-07-07
     * @time 오후 3:46
     **/

    public ActivityIntroBinding introBinding;


    Context context;
    PermissionDialog permissionDialog;
    String per;
    View IntroLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;


        introBinding = DataBindingUtil.setContentView(this,R.layout.activity_intro);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.intro_animation);
        introBinding.logo.startAnimation(animation);
        IntroLayout = findViewById(R.id.intro_layout);

        // Status bar custom
        StatusBarCustom.setStatusBarColor(this,StatusBarCustom.StatusBarColorType.BLACK_STATUS_BAR);




        per = SharedPreferenceUtil.getInstance(context).getString("per");
        permissionDialog = new PermissionDialog(context, this);
        nextStep();



    }


    public void nextStep(){
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if(per!=null){
                    LogUtil.logE("per : " + per);
                    if(per.equals("no") || per.equals("")){
                        permissionDialog.show();
                    }
                    else{
                        permissionDialog.dismiss();
                        Intent intent = new Intent(context,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }else{
                    permissionDialog.show();
                }
            }
        }, 3500);// 3.5초 정도 딜레이를 준 후 시작
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grandResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grandResults);
        if (requestCode == Division.PERMISSIONS_REQUEST_CODE && grandResults.length == Division.REQUEST_PER.length) {
            // 요청 코드가 PERMISSIONS_REQUEST_CODE 이고, 요청한 퍼미션 개수만큼 수신되었다면
            boolean check_result = true;
            // 모든 퍼미션을 허용했는지 체크합니다.
            for (int result : grandResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    LogUtil.logE("length : " + Division.REQUEST_PER.length);
                    break;
                }
            }

            if (check_result) {
                // 모든 퍼미션을 허용했다면 액티비티 전환.
                SharedPreferenceUtil.getInstance(context).putPermission("per",Division.PERMISSION_CHECK_OK);
                permissionDialog.dismiss();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                // 거부한 퍼미션이 있다면 앱을 사용할 수 없는 이유를 설명해주고 앱을 종료합니다.2 가지 경우가 있습니다.
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Division.REQUEST_PER[0])
                        && ActivityCompat.shouldShowRequestPermissionRationale(this, Division.REQUEST_PER[1])
                        && ActivityCompat.shouldShowRequestPermissionRationale(this, Division.REQUEST_PER[2])
                        && ActivityCompat.shouldShowRequestPermissionRationale(this, Division.REQUEST_PER[3])
                        && ActivityCompat.shouldShowRequestPermissionRationale(this, Division.REQUEST_PER[4])) {


                    // 사용자가 거부만 선택한 경우에는 앱을 다시 실행하여 허용을 선택하면 앱을 사용할 수 있습니다.
                    Snackbar.make(IntroLayout, "권한이 거부되었습니다. 앱을 다시 실행하여 권한을 허용해주세요. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SharedPreferenceUtil.getInstance(context).putPermission("per", "no");
                            permissionDialog.dismiss();
                            finish();
                        }
                    }).show();

                } else {

                    // “다시 묻지 않음”을 사용자가 체크하고 거부를 선택한 경우에는 설정(앱 정보)에서 퍼미션을 허용해야 앱을 사용할 수 있습니다.
                    Snackbar.make(IntroLayout, "설정(앱 정보)에서 권한을 허용해야합니다. ",
                            Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            SharedPreferenceUtil.getInstance(context).putPermission("per", "no");
                            permissionDialog.dismiss();
                            finish();
                        }
                    }).show();

                }
            }

        }
    }
}


