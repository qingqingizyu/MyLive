package com.zmm.activity.login;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zmm.app.MyApp;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.RequestSMSCodeListener;
import cn.bmob.v3.listener.SaveListener;

public class PhoneLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName_et, verification_et;
    private Button Message_btn, register_btn;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_phone_login);
        //初始化Bomb云
        initBomb();
        //初始化控件
        initView();
        //设置按钮点击事件
        initEvent();
    }
    //设置点击事件
    private void initEvent() {
        register_btn.setOnClickListener(this);
        Message_btn.setOnClickListener(this);
    }
    //初始化Bmob
    private void initBomb() {
        Bmob.initialize(PhoneLoginActivity.this, "6bf3502ceb6a2b5e3bb4da2e5041a7f3");
    }

    //设置按钮点击事件
    @Override
    public void onClick(View v) {
        Log.e("MESSAGE:", "1");
        //获取输入的手机号
        userName = userName_et.getText().toString();
        switch (v.getId()) {
            case R.id.Message_btn:
                Log.e("MESSAGE:", "2");
                if (userName.length() != 11) {
                    Toast.makeText(this, "请输入11位有效手机号码", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("MESSAGE:", "3");
                    //进行获取验证码操作和倒计时1分钟操作
                    BmobSMS.requestSMSCode(this, userName, "短信模板", new RequestSMSCodeListener() {
                        @Override
                        public void done(Integer integer, BmobException e) {
                            if (e == null) {
                                //发送成功时，让获取验证码按钮不可点击，且为灰色
                                Message_btn.setClickable(false);
                                Message_btn.setBackgroundColor(Color.GRAY);
                                Toast.makeText(PhoneLoginActivity.this, "验证码发送成功，请尽快使用", Toast.LENGTH_SHORT).show();
                                new CountDownTimer(60000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        Message_btn.setBackgroundResource(R.drawable.button_shape01);
                                        Message_btn.setText(millisUntilFinished / 1000 + "秒");
                                    }

                                    @Override
                                    public void onFinish() {
                                        Message_btn.setClickable(true);
                                        Message_btn.setBackgroundResource(R.drawable.button_shape);
                                        Message_btn.setText("重新发送");
                                    }
                                }.start();
                                Log.e("MESSAGE:", "4");
                            } else {
                                Toast.makeText(PhoneLoginActivity.this, "验证码发送失败，请检查网络连接", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                break;
            case R.id.register_btn:
                if (verification_et.length() != 6 || userName.length() != 11) {
                    Toast.makeText(this, "手机号或验证码输入不合法", Toast.LENGTH_SHORT).show();
                } else {
                    BmobUser user = new BmobUser();
                    user.setUsername(userName);
                    user.setPassword("000000");
                    user.signUp(this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(PhoneLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            MyApp.setNickname(userName);
                            MyApp.login();
                            UIManager.startMain(PhoneLoginActivity.this);
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            reLogin();
                        }

                    });
                }
                break;
        }
    }

    //初始化控件
    private void initView() {
        userName_et = (EditText) findViewById(R.id.userName_et);
        verification_et = (EditText) findViewById(R.id.verification_et);
        Message_btn = (Button) findViewById(R.id.Message_btn);
        register_btn = (Button) findViewById(R.id.register_btn);
    }
    private void reLogin() {
        // 获取用户输入的用户名和密码
        String password = "000000";
        // 非空验证
            // 使用BmobSDK提供的登录功能
            BmobUser user = new BmobUser();
            //用户名(手机号)
            user.setUsername(userName);
            //默认密码
            user.setPassword(password);
            user.login(PhoneLoginActivity.this, new SaveListener() {
                @Override
                public void onSuccess() {
                    MyApp.setNickname(userName);
                    MyApp.login();
                    UIManager.startMain(PhoneLoginActivity.this);
                }
                @Override
                public void onFailure(int i, String s) {
                    Toast.makeText(PhoneLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            });

    }
}