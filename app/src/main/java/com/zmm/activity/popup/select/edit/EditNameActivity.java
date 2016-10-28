package com.zmm.activity.popup.select.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class EditNameActivity extends BaseActivity implements View.OnClickListener{


    private EditText etName;

    @Override
    protected void initView() {

        //输入的昵称
        etName = (EditText) findViewById(R.id.et_et_name);
        etName.setText(MyApp.getNickname());
        findViewById(R.id.et_name_tv_cancel).setOnClickListener(this);//取消
        findViewById(R.id.et_name_tv_save).setOnClickListener(this);//保存

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_name;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //取消，关闭
            case R.id.et_name_tv_cancel:
                finish();
                break;
            case R.id.et_name_tv_save:
                MyApp.setNickname(etName.getText().toString().trim());
                finish();
                break;
        }
    }
}
