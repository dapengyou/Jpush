package com.test.jpush;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by lady_zhou on 2017/8/21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
