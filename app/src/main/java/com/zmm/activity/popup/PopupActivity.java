package com.zmm.activity.popup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class PopupActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.activity_open,R.anim.activity_cloes);
    }

    @Override
    protected void initView() {
        findViewById(R.id.pop_img).setOnClickListener(this);
        findViewById(R.id.pop_both).setOnClickListener(this);
        findViewById(R.id.pop_girl).setOnClickListener(this);
        findViewById(R.id.pop_boy).setOnClickListener(this);
        findViewById(R.id.pop_exit).setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_popup;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pop_img:
               finish();
                break;
            case R.id.pop_both:
                MyApp.setLikeRead(0);
                finish();
                break;
            case R.id.pop_girl:
                MyApp.setLikeRead(1);
                finish();
                break;
            case R.id.pop_boy:
                MyApp.setLikeRead(2);
                finish();
                break;
            case R.id.pop_exit:
                finish();
                break;
        }
    }
}
