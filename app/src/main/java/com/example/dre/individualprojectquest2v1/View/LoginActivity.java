package com.example.dre.individualprojectquest2v1.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dre.individualprojectquest2v1.R;
import com.example.dre.individualprojectquest2v1.oldJava.LoginBackend;

public class LoginActivity extends AppCompatActivity {

    // the part that is commented out still works
    // for debug and using ease it is commented out
    // sort of a pain in the butt to keep adding
    // user credentials each time

    /*** this class is the primary login activity
     *  it is disabled for convenience
     *  leads to either the quiz on login
     *  or the registration page
     */

    private Button mLb;
    private Button mRb;
    private EditText eTUn;
    private EditText eTPa;
    private String mUserNameReturn;
    private String mPasswordReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLb = (Button) findViewById(R.id.loginbtnid);
        mRb = (Button) findViewById(R.id.regbtnid);

        eTUn = (EditText)findViewById(R.id.eTUnLogin);
        eTPa = (EditText)findViewById(R.id.eTPaLogin2);
        mLb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(LoginActivity.this, quizSelection.class);
                startActivity(intent1);
                finish();
                //ToDo login disabled turn it back on
            }
        });


        mRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, AccountReg.class);
                startActivity(intent2);
                finish();
            }
        });
//
//
//
    }

}

