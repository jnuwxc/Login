package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        ImageView runManImg = findViewById(R.id.runManImg);
        ObjectAnimator runManAnimator = ObjectAnimator.ofFloat(runManImg, "translationX", getImgTranX());
        runManAnimator.setDuration(1500);
        runManAnimator.start();
//        SharedPreferences loginSP = getSharedPreferences("login", Context.MODE_PRIVATE);
//        loginSP.edit()
//                .putString("userName", "test")
//                .putBoolean("isLogin", true)
//                .apply();
    }

    /**
     * 获取图片位移的距离，单位为像素，效果为将图片从左/右侧未出现移动到屏幕中央。
     * @return 返回要移动的距离
     */
    private float getImgTranX(){
        //图片的宽度，单位dp。
        final int imgWidthDp = 250;
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        //这两个就是手机屏幕的屏幕分辨率，物理宽高值如1080*1920（ToolBar或ActionBar会占据一定空间，得到的heightPiexls会小一点）
        // 表示屏幕的像素宽度，单位是px（像素）
        int screenWidth = metrics.widthPixels;
        // 表示屏幕的像素高度，单位是px（像素）
        //int screenHeight = metrics.heightPixels;
        // 获取dp与px的换算值
        float screenScale = metrics.density;
        return screenWidth / 2 + imgWidthDp * screenScale / 2 ;
    }

}