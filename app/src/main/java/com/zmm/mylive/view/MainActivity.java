package com.zmm.mylive.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.Constant;
import com.zmm.activity.attention.AttentionActivity;
import com.zmm.activity.popup.AccountActivity;
import com.zmm.activity.popup.EarnActivity;
import com.zmm.activity.popup.LevelActivity;
import com.zmm.activity.popup.devote.DevoteActivity;
import com.zmm.activity.popup.select.SelectActivity;
import com.zmm.activity.popup.select.edit.EditDataActivity;
import com.zmm.app.MyApp;
import com.zmm.leliving.LeLiveMainActivity;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mVp;
    private TabLayout mTab;
    private DrawerLayout dl;
    private Toolbar mTb;
    private TextView tvTb;
    private SimpleDraweeView ivImg;
    private TextView tvName;
    private ImageView mIvGender;
    private TextView tvSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        overridePendingTransition(R.anim.welcome_open, R.anim.activity_cloes);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void setUserInfo() {
        ivImg.setImageURI(Uri.parse(MyApp.getFigureurl()));
        tvName.setText(MyApp.getNickname());
        tvSrc.setText(MyApp.getSignature());
        switch (MyApp.getGender()) {
            case "男"://表示男
                mIvGender.setImageResource(R.mipmap.global_icon_male);
                break;
            default://默认女
                mIvGender.setImageResource(R.mipmap.global_icon_female);
                break;
        }
    }

    protected void initView() {

        mVp = (ViewPager) findViewById(R.id.main_vp);
        mTab = (TabLayout) findViewById(R.id.main_tab);

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        mTb = (Toolbar) findViewById(R.id.tool_bar);
        tvTb = (TextView) findViewById(R.id.tv_toolbar);
        tvTb.setText(Constant.LIKE_TITLE[MyApp.getLikeRead()]);
        tvTb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UIManager.intentPopup(MainActivity.this);
            }
        });
        initAdadpter();//初始化适配器
        toolBarListener();//抽屉开关监听方法
        Intent intent = getIntent();
        //判断是否是登录跳转的
        String login = intent.getStringExtra("login");
        if (login == null) {
            UIManager.intentWelcome(MainActivity.this);//如果不是登录就跳转到欢迎页面
        } else {
            UIManager.showSnackbar(this, "欢迎:" + MyApp.getNickname());
        }
        //抽屉控件初始化
        initDrawer();
    }

    //抽屉开关监听方法
    private void toolBarListener() {
        //开关抽屉
        mTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dl.isDrawerOpen(GravityCompat.START)) {
                    dl.openDrawer(GravityCompat.START);
                } else {
                    dl.closeDrawers();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置用户信息
        setUserInfo();
        tvTb.setText(Constant.LIKE_TITLE[MyApp.getLikeRead()]);
    }

    private void initAdadpter() {
        //把TabLayout和ViewPager关联起来
        mVp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mTab.setupWithViewPager(mVp, true);
        mVp.setCurrentItem(1);//默认显示热门
        mVp.setOffscreenPageLimit(2);//预加载
    }

    private int mCount = 0;
    private long fastTime;

    //处理返回键的方法
    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawers();
        } else if (mCount != 0 && System.currentTimeMillis() - fastTime < 2000) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                finishAffinity();//两次点击返回键小于两秒就退出程序，否则不退出
            } else {
                finish();
            }


        } else {
            fastTime = System.currentTimeMillis();
            //获取第一次点击返回键的系统时间
//            Toast.makeText(MainActivity.this, "再次点击退出程序", Toast.LENGTH_SHORT).show();
            UIManager.showSnackbar(this, "再次点击退出程序！");
            mCount++;
        }
    }

    //抽屉控件初始化
    private void initDrawer() {
        findViewById(R.id.tv_devote).setOnClickListener(this);//贡献榜
        findViewById(R.id.tv_earn).setOnClickListener(this);//收益
        findViewById(R.id.tv_select).setOnClickListener(this);//设置
        findViewById(R.id.tv_level).setOnClickListener(this);//等级
        findViewById(R.id.tv_account).setOnClickListener(this);//账户
        findViewById(R.id.bt_live).setOnClickListener(this);//直播
        findViewById(R.id.bt_attention).setOnClickListener(this);//关注
        findViewById(R.id.bt_fans).setOnClickListener(this);//粉丝
        ivImg = (SimpleDraweeView) findViewById(R.id.iv_img);
        ivImg.setOnClickListener(this);
        tvName = (TextView) findViewById(R.id.tv_name);//昵称
        //签名
        tvSrc = (TextView) findViewById(R.id.tv_src);
        mIvGender = (ImageView) findViewById(R.id.iv_gender);//头像
        //foaltbutton
        findViewById(R.id.floatbutton).setOnClickListener(this);


    }


    //抽屉里的跳转点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击头像跳转到编辑资料
            case R.id.iv_img:
                startActivity(new Intent(this, EditDataActivity.class));
                break;
            case R.id.bt_live:
                //拉流地址rtmp://13299.mpull.live.lecloud.com/live/2222
            //打开直播界面
            UIManager.startLive(this, "rtmp://13299.mpull.live.lecloud.com/live/2222", "直播啦");
            break;
            case R.id.bt_attention:
                //打开关注页面
                startActivity(new Intent(this, AttentionActivity.class));
//                UIManager.showSnackbar(this,"打开关注页面！");
                break;
            case R.id.bt_fans:
                //打开粉丝页面
                UIManager.showSnackbar(this, "打开粉丝页面！");
                break;
            case R.id.tv_devote:
                //打开贡献榜页面
                startActivity(new Intent(this, DevoteActivity.class));
                break;
            case R.id.tv_earn:
                //打开收益界面
                startActivity(new Intent(this, EarnActivity.class));
                break;
            case R.id.tv_account:
                //打开账户界面
                startActivity(new Intent(this, AccountActivity.class));
                break;
            case R.id.tv_level:
                //打开等级界面
                startActivity(new Intent(this, LevelActivity.class));
                break;
            case R.id.tv_select:
                //打开设置界面
                startActivity(new Intent(this, SelectActivity.class));
                break;
            case R.id.floatbutton:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String[] suf = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

                    int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
                    int i1 = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    int i2 = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                    int i3 = ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);
                    if (i != PackageManager.PERMISSION_GRANTED && i1 != PackageManager.PERMISSION_GRANTED && i2 != PackageManager.PERMISSION_GRANTED && i3 != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO);
                        ActivityCompat.requestPermissions(this, suf, 3);
                        return;
                    } else {
                        startActivity(new Intent(this, LeLiveMainActivity.class));
                    }
                }
                startActivity(new Intent(this, LeLiveMainActivity.class));


        }
        dl.closeDrawers();
    }

}
