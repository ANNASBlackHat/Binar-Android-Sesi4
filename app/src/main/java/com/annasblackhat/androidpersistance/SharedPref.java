package com.annasblackhat.androidpersistance;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private SharedPreferences sp;
    private SharedPreferences.Editor spe;

    public static String KEY_IS_LOGIN = "is_login";

    public SharedPref(Context context) {
        sp = context.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        spe = sp.edit();
    }

    //save to local data
    public void saveBoolean(boolean value, String key){
        spe.putBoolean(key, value);
        spe.commit();
    }

    public boolean getBoolean(String key){
        return sp.getBoolean(key, false);
    }
}
