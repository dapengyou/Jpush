package com.test.jpush;

import android.app.Application;
import android.app.Notification;

import cn.jpush.android.api.BasicPushNotificationBuilder;
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
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(getApplicationContext());
        builder.statusBarDrawable = R.drawable.jpush_ic_richpush_actionbar_back;
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
//                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);

    }
}
