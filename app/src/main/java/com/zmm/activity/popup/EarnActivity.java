package com.zmm.activity.popup;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class EarnActivity extends BaseActivity {

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.earn_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_earn;
    }
}
