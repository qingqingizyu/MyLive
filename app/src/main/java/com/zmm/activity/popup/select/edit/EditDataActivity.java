package com.zmm.activity.popup.select.edit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class EditDataActivity extends BaseActivity implements View.OnClickListener {

    private TextView sexShow;
    private TextView nameShow;
    private SimpleDraweeView ivHeadImg;

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.edit_data_bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //控件初始化：性别、昵称、头像
        sexShow = (TextView) findViewById(R.id.et_data_tv_sex_show);
        nameShow = (TextView) findViewById(R.id.et_data_tv_name_show);
        ivHeadImg = (SimpleDraweeView) findViewById(R.id.et_data_iv_head_img);
        findViewById(R.id.et_data_tv_name).setOnClickListener(this);//昵称
        findViewById(R.id.et_data_rl).setOnClickListener(this);//头像
        findViewById(R.id.et_data_tv_sex).setOnClickListener(this);//性别
        findViewById(R.id.et_data_tv_sign).setOnClickListener(this);//个性签名
        findViewById(R.id.et_data_tv_home);//家乡
        findViewById(R.id.et_data_tv_emotion);//情感
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_data;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //跳转到昵称修改的页面
            case R.id.et_data_tv_name:
                startActivity(new Intent(this, EditNameActivity.class));
                break;
            //跳转到个性签名修改的页面
            case R.id.et_data_tv_sign:
                startActivity(new Intent(this, EditSignActivity.class));
                break;
            //跳转到性别修改的页面
            case R.id.et_data_tv_sex:
                startActivity(new Intent(this, EditSexActivity.class));
                break;
            //跳转到头像修改的页面
            case R.id.et_data_rl:
                startActivity(new Intent(this, EditHeadImgActivity.class));
                break;
        }
    }

    @Override
    public void loadData() {
        super.loadData();
        sexShow.setText(MyApp.getGender());
        nameShow.setText(MyApp.getNickname());
        ivHeadImg.setImageURI(Uri.parse(MyApp.getFigureurl()));
    }
}
