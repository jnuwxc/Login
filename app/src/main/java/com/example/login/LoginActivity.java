package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.login.databinding.ActivityLoginBinding;

import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        ObjectAnimator.ofFloat(binding.runManImg, "translationX", getImgTranX())
                .setDuration(1000).start();
        binding.loginBtn.setOnClickListener(v -> {
            String account = binding.accountEdit.getText().toString();
            String password = binding.passwordEdit.getText().toString();
            Log.d(TAG, "onCreate: " + account + " " + password);
            if(passwordIsRight(account, password)){
               getSharedPreferences("login", Context.MODE_PRIVATE)
                       .edit()
                       .putString("account", account)
                       .putBoolean("isLogin", true)
                       .apply();
               // 结束动画
               ObjectAnimator.ofFloat(binding.runManImg, "translationX", getImgTranX() * 2)
                        .setDuration(1000).start();
               // 动画结束再跳转，开启一个线程暂停和动画相同时间。
               Thread thread = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       SystemClock.sleep(1000);
                       Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                       startActivity(intent);
                   }
               });
               thread.start();
            }else {
                Toast.makeText(this, "账号或密码错误，请核实后重新输入", Toast.LENGTH_LONG).show();
            }
        });

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

    /**
     * 向服务器请求，验证账号密码是否正确
     * @param account 账号
     * @param password 密码
     * @return 是否正确
     */
    private boolean passwordIsRight(String account, String password){

        //待实现
        return true;
    }
}