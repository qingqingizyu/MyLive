package com.zmm.mylive.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.zmm.app.MyApp;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.welcome_open,R.anim.activity_cloes);
        setContentView(R.layout.activity_welcome);

        ImageView imageView = (ImageView) findViewById(R.id.welcome_pic);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (MyApp.isLogin()) {
                    finish();
                }else {
                    UIManager.startLogin(WelcomeActivity.this);
                }
            }
        };
        timer.schedule(task, 1000 * 3); // 1秒后
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.welcome_open,R.anim.activity_cloes);

    }
    //返回键不处理，返回键就没有效果
    @Override
    public void onBackPressed() {
    }
}
