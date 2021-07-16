package com.kkjang.stockapp.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kkjang.stockapp.R;

public class BaseActivity extends AppCompatActivity {

    ProgressBar progress;

    public interface OnClickListener {
        void onClick();
    }

    public interface OnCancelListener {
        void onClick();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setProgress(ProgressBar progress){
        this.progress = progress;
    }

    public void showProgress(){
        if(progress != null)
            progress.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        if(progress != null)
            progress.setVisibility(View.GONE);
    }





}
