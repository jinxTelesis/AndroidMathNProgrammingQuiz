package com.example.dre.individualprojectquest2v1.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dre.individualprojectquest2v1.Constants.Constant;
import com.example.dre.individualprojectquest2v1.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        /**
         * lambda that starts thread to op login
         * after splash screen
         */
        new Handler().postDelayed( ()-> {

            Intent startInt = new Intent(Splash.this, LoginActivity.class);
            startActivity(startInt);
            finish();

            // delay for splash screen
        }, Constant.SPLASH_TIME_OUT);
    }
}
