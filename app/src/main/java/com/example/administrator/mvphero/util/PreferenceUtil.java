package com.example.administrator.mvphero.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtil {
    private static final String USER_ID = "user_id";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public PreferenceUtil(Context context) {
        preferences = context.getSharedPreferences("mvp_test", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setUid(String uid){
        editor.putString(USER_ID, uid);
        editor.commit();
    }

    public String getUid(){
        return preferences.getString(USER_ID, "");
    }
}
