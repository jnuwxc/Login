package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

//        SharedPreferences loginSP = getSharedPreferences("login", Context.MODE_PRIVATE);
//        boolean isLogin = loginSP.getBoolean("isLogin", false);
//        if(isLogin){
//            Toast.makeText(this, "user info: " + loginSP.getString("userName", "error"), Toast.LENGTH_SHORT).show();
//        }else {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        }
    }
}