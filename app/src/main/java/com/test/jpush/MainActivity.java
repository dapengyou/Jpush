package com.test.jpush;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View mLayout;
    private Button mStopJpush;
    private Button mStartJpush;
    NotificationsUtils notificationsUtils = new NotificationsUtils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.ll_conversation_prompt);
        mLayout.setOnClickListener(this);

        mStopJpush = (Button) findViewById(R.id.stopJpush);
        mStopJpush.setOnClickListener(this);

    }

    public static void getMessage(String message) {
    }

    /**
     * 跳到设置页
     */
    protected void requestPermission() {
        // TODO Auto-generated method stub
        // 6.0以上系统才可以判断权限

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        }
        return;
    }

    /**
     * 跳到通知栏设置页
     */
    private void toSetting() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction(Intent.ACTION_VIEW);
            localIntent.setClassName("com.android.settings", "com.android.setting.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", getPackageName());
        }
        startActivity(localIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_conversation_prompt:
                if (!notificationsUtils.isNotificationEnabled(this)) {
//                    requestPermission();
                    toSetting();
                }
                break;
            case R.id.stopJpush:
                //停止推送，重装后才可再次接收
                JPushInterface.stopPush(getApplicationContext());
                break;
        }
    }
}
