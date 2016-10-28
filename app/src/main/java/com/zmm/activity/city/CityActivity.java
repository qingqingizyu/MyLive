package com.zmm.activity.city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class CityActivity extends BaseActivity {


    @Override
    protected void initView() {
        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");//得到标题
        String path = intent.getStringExtra("path");//得到网络访问的地址
        Toolbar toolBar = (Toolbar) findViewById(R.id.city_tool_bar);
        TextView tvTitle = (TextView) findViewById(R.id.city_tvTitle);
        tvTitle.setText(title);//添加标题

        //绑定Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        CityFragment fragment = new CityFragment();
        //传值
        Bundle args = new Bundle();
        args.putString("path", path);
        fragment.setArguments(args);
        transaction.replace(R.id.city_layout,fragment);
        transaction.commit();
        //处理返回按钮
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_city;
    }
}
