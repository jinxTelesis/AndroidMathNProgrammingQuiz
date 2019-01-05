package com.example.dre.individualprojectquest2v1.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.dre.individualprojectquest2v1.Constants.Constant;

public class SharedPrefLogin {

    private final Context ctx;
    private final SharedPreferences LoginPref;


    public SharedPrefLogin(Context ctx) {
        this.ctx = ctx;
        LoginPref = ctx.getSharedPreferences(Constant.PREFS_LOGIN,0);
        SharedPreferences.Editor editor = LoginPref.edit();
    }

    public void addUser(String username, String userPassword)
    {

    }

    public boolean removeUser()
    {
        return false;
    }

    public boolean userFound()
    {
        return false;
    }
}
