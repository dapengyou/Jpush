package com.test.jpush;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static TextView mTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTip = (TextView) findViewById(R.id.tv_conversation_tip);

    }
    public static void getMessage(String message){
        mTip.setText(message);
    }
}
