package com.zmm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.zmm.mylive.R;

/**
 * Created by zhonghang on 16/8/31.
 */

public abstract  class BaseActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,WindowManager.LayoutParams. FLAG_FULLSCREEN);
        initView();
        overridePendingTransition(R.anim.activity_open,R.anim.activity_cloes);


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public  void loadData(){

    };

    @Override
    public void onResume() {
        super.onResume();
        //做数据统计
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //做数据统计
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract void initView();

    public abstract int getLayoutId();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_open,R.anim.activity_cloes);
    }
}
