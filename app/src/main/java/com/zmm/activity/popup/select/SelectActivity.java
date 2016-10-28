package com.zmm.activity.popup.select;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;

public class SelectActivity extends BaseActivity implements View.OnClickListener{
    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.select_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.select_textView_one).setOnClickListener(this);//账号与安全
        findViewById(R.id.select_textView_two).setOnClickListener(this);//黑名单
        findViewById(R.id.select_textView_three).setOnClickListener(this);//开播提醒
        findViewById(R.id.select_textView_four).setOnClickListener(this);//未关注人私信
        findViewById(R.id.select_textView_five).setOnClickListener(this);//清除缓存
        findViewById(R.id.select_textView_six).setOnClickListener(this);//帮助的反馈
        findViewById(R.id.select_textView_seven).setOnClickListener(this);//关于我们
        findViewById(R.id.select_textView_eight).setOnClickListener(this);//网络诊断
        findViewById(R.id.select_btn).setOnClickListener(this);//退出登录
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.select_textView_one:
                    UIManager.showSnackbar(this,"设置账号与安全");
                    break;
                case R.id.select_textView_two:
                    UIManager.showSnackbar(this,"设置黑名单");
                    break;
                case R.id.select_textView_three:
                    UIManager.showSnackbar(this,"设置开播提醒");
                    break;
                case R.id.select_textView_four:
                    UIManager.showSnackbar(this,"设置未关注人私信");
                    break;
                case R.id.select_textView_five:
                    UIManager.showSnackbar(this,"设置清除缓存");
                    break;
                case R.id.select_textView_six:
                    UIManager.showSnackbar(this,"设置帮助的反馈");
                    break;
                case R.id.select_textView_seven:
                    UIManager.showSnackbar(this,"设置关于我们");
                    break;
                case R.id.select_textView_eight:
                    UIManager.showSnackbar(this,"设置网络诊断");
                    break;
                case R.id.select_btn:
                    MyApp.cancle();
                    UIManager.startLogin(this);
                    break;
            }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_select;
    }
}
