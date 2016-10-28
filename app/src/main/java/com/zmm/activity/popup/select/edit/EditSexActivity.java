package com.zmm.activity.popup.select.edit;

import android.view.View;
import android.widget.RadioButton;

import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;


public class EditSexActivity extends BaseActivity implements View.OnClickListener{

    private RadioButton etFemale;
    private RadioButton etMale;

    @Override
    protected void initView() {

        //初始化对象
        etFemale = (RadioButton) findViewById(R.id.et_sex_female);
        etMale = (RadioButton) findViewById(R.id.et_sex_male);
        if(MyApp.getGender().equals("女")){
            etFemale.setChecked(true);
        }else {
            etMale.setChecked(true);
        }
        //点击监听
        findViewById(R.id.et_sex_female).setOnClickListener(this);
        findViewById(R.id.et_sex_male).setOnClickListener(this);
        findViewById(R.id.et_sex_tv_cancel).setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_sex;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击调用setGender方法，抽屉里的图标变成女
            case R.id.et_sex_female:
                MyApp.setGender("女");
                finish();
                break;
            //点击调用setGender方法，抽屉里的图标变成男
            case R.id.et_sex_male:
                MyApp.setGender("男");
                finish();
                break;
            //点击退出Activity
            case R.id.et_sex_tv_cancel:
                finish();
                break;
        }
    }
}
