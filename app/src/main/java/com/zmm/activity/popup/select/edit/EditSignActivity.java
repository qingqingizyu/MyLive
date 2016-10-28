package com.zmm.activity.popup.select.edit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;

public class EditSignActivity extends BaseActivity implements View.OnClickListener {


    private EditText etName;

    @Override
    protected void initView() {
        //输入的个性签名
        etName = (EditText) findViewById(R.id.et_et_sign);
        if (MyApp.getSignature().equals(null)) {

        } else if (MyApp.getSignature().equals("Ta 好像忘记写签名了...")) {

        } else {

            etName.setText(MyApp.getSignature());
        }
        findViewById(R.id.et_sign_tv_cancel).setOnClickListener(this);//取消
        findViewById(R.id.et_sign_tv_save).setOnClickListener(this);//保存
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_sign;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //取消，关闭
            case R.id.et_sign_tv_cancel:
                finish();
                break;
            case R.id.et_sign_tv_save:
                MyApp.setSignature(etName.getText().toString().trim());
                finish();
                break;
        }
    }
}
