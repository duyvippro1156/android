package com.example.firstinstallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private static final String KEY_FIRST_INSTALL = "KEY_FIRST_INSTALL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final MySharePreference mySharePreference = new MySharePreference(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mySharePreference.getBooleanValues(KEY_FIRST_INSTALL)){
                    startActivity(MainActivity.class);
                }else{
                    startActivity(OnboardingActivity.class);
                    mySharePreference.putBooleanValues(KEY_FIRST_INSTALL,true);
                }
            }
        },2000);
    }

    private void startActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}
