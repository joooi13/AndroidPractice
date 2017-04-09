package com.example.joy.myapplication;

import android.util.Log;

/**
 * Created by yujoi on 2017/04/09.
 */

public class HelloImpl implements Hello{
    @Override
    public void say() {
        Log.d("TAG", "-------hello");
    }
}
