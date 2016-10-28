package com.zmm.activity.popup.devote;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class DevoteActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.devote_bar);
        mTab = (TabLayout) findViewById(R.id.devote_tab);
        mVp = (ViewPager) findViewById(R.id.devote_vp);
        mVp.setAdapter(new DevoteAdapter(getSupportFragmentManager()));
        mTab.setupWithViewPager(mVp,true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_devote;
    }
}
