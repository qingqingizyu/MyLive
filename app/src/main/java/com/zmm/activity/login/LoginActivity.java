package com.zmm.activity.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zmm.Constant;
import com.zmm.app.MyApp;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private Tencent mTencent;
    //回调接口
    private IUiListener loginListener;
    private IUiListener userInfoListener;
    private String SCOPE = "all";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initQqLogin();
    }


    public void qqLogin(View view) {
        //第三方登录方法
        qqLogin();
    }

    public void phoneLogin(View view) {
        Intent intent = new Intent(this, PhoneLoginActivity.class);
        startActivity(intent);
    }

    //初始化QQ登录分享的需要的资源
    private void initQqLogin() {
        mTencent = Tencent.createInstance(Constant.APP_ID, getApplicationContext());
        //创建QQ登录回调接口
        loginListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                //登录成功后回调该方法
                UIManager.showSnackbar(LoginActivity.this, "登录成功");
                //设置openid，如果不设置这一步的话无法获取用户信息
                JSONObject jo = (JSONObject) o;
                String openID;
                try {
                    openID = jo.getString("openid");
                    Log.e("TAG", "我的ID   " + openID);
                    Log.e("TAG", "我的json   " + jo);
                    String accessToken = jo.getString("access_token");
                    String expires = jo.getString("expires_in");
                    mTencent.setOpenId(openID);
                    mTencent.setAccessToken(accessToken, expires);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(UiError uiError) {
                //登录失败后回调该方法
                UIManager.showSnackbar(LoginActivity.this, "登录失败");
                Log.e("LoginError:", uiError.toString());
            }

            @Override
            public void onCancel() {
                //取消登录后回调该方法
                UIManager.showSnackbar(LoginActivity.this, "取消登录");
            }
        };
        //获取用户信息的回调接口
        userInfoListener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                JSONObject jo = (JSONObject) o;
                Log.e("COMPLETE:", jo.toString());
                try {
                    JSONObject info = (JSONObject) o;
                    Log.e("TAG", jo.toString());
                    //获取QQ信息
                    String nickName = info.getString("nickname");
                    String gender = info.getString("gender");
                    String city = info.getString("city");
                    String figureurl = info.getString("figureurl_qq_2");
                    //保存QQ信息
                    MyApp.setNickname(nickName);
                    MyApp.setGender(gender);
                    MyApp.setCity(city);
                    MyApp.setFigureurl(figureurl);
                    UIManager.startMain(LoginActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onError(UiError uiError) {
            }
            @Override
            public void onCancel() {
            }
        };
    }

    //qq登录功能
    public void qqLogin() {
        mTencent.login(this, SCOPE, loginListener);
    }

    //获取用户信息
    private void getUserInfo() {
        UserInfo info = new UserInfo(this, mTencent.getQQToken());
        info.getUserInfo(userInfoListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                getUserInfo();
                MyApp.login();

            }
        }
    }

    private int mCount = 0;
    private long fastTime;

    //处理返回键的方法
    @Override
    public void onBackPressed() {
        if (mCount != 0 && System.currentTimeMillis() - fastTime < 2000) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();//两次点击返回键小于两秒就退出程序，否则不退出
            } else {
                finish();
            }
        } else {
            fastTime = System.currentTimeMillis();
            //获取第一次点击返回键的系统时间
            UIManager.showSnackbar(this, "再次点击退出程序！");
            mCount++;
        }
    }
}
