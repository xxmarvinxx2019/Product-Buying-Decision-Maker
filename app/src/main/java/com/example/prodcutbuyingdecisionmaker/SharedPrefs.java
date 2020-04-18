package com.example.prodcutbuyingdecisionmaker;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    final static String FileName = "CaptainCode";

    public static String readSharedSetting(Context ctx,String settingName,String defaultValue){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        return sharedPreferences.getString(settingName,defaultValue);
    }
    public static void saveSharedSetting(Context ctx,String settingName,String settingValue){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(FileName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(settingName,settingValue);
        editor.apply();
    }
}
