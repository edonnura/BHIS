package com.example.edon.bhis.Custom.Helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionHelper {
    private static Context context;
    private final static String PREFS_NAME = "bhis_app";
    private final static String TOKEN="token";
    private final static String ID="id";

    public SessionHelper(Context _context){
        this.context = _context;
    }
    public static void setToken(String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, value);
        editor.apply();
    }
    public static String getToken() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TOKEN,null);
    }



    public static void setId(Integer value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ID, value);
        editor.apply();
    }

    public static Integer  getId() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
        return sharedPreferences.getInt(ID, 0);
    }
}
