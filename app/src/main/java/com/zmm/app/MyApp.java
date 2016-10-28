package com.zmm.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.zmm.utlis.OkHttpClientUtils;
import com.zmm.widget.CrashHandler;

/**
 * Created by Administrator on 2016/10/9 0009.
 */

public class MyApp extends Application {
    public static SharedPreferences sp;
    public LocationClient mClient;
    public double latitude, longitude;
    private static SharedPreferences.Editor editor;

    //设置用户喜欢看的类型
    public static void setLikeRead(int likeRead) {
        editor.putInt("likeRead", likeRead);
        editor.apply();
    }

    //读取用户喜欢看的类型
    public static int getLikeRead() {
        return sp.getInt("likeRead", 0);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttp();//初始化OKHttp
        initLocation();//初始化定位
        //必须在setContentView()方法之前初始化.图片加载库
        Fresco.initialize(this);
        //初始化播放器
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

    }

    private void initOkHttp() {
        OkHttpClientUtils.getOkHttpClientUtils(this);
        OkHttpClientUtils.getOkHttpClient();
    }

    private void initLocation() {
        //存储定位信息
        sp = getSharedPreferences("config", MODE_PRIVATE);
        editor = sp.edit();
        //①.创建定位客户端
        mClient = new LocationClient(this);
        //②.添加定位监听
        mClient.registerLocationListener(new MyLocationListener());
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 100000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mClient.setLocOption(option);
        //开始定位
        mClient.start();
    }

    //获取纬度
    public static String getLatitude() {
        return sp.getString("latitude", "40.063133");
    }

    //获取经度
    public static String getLongitude() {
        return sp.getString("longitude", "116.345276");
    }

    //实现百度的定位监听
    class MyLocationListener implements BDLocationListener {
        //接受定位结果
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            //纬度
            latitude = bdLocation.getLatitude();
            //经度
            longitude = bdLocation.getLongitude();
            if (latitude!=longitude){
                editor.putString("latitude", String.valueOf(latitude));
                editor.putString("longitude", String.valueOf(longitude));
                editor.apply();
            }

        }
    }
    //是否登录
    public static boolean isLogin(){
       return sp.getBoolean("isLogin",false);
    }
    //登录
    public static void login(){
        editor.putBoolean("isLogin",true);
        editor.commit();
    }
    //退出登录
    public static void cancle(){
        editor.putBoolean("isLogin",false);
        editor.commit();
    }
    public static String getNickname(){
        return sp.getString("nickname"," ");
    }
    public static void setNickname(String nickname){
        editor.putString("nickname",nickname);
        editor.commit();
    }
    //获取性别
    public static String getGender(){
        return sp.getString("gender","男");
    }
    public static void setGender(String gender){
        editor.putString("gender",gender);
        editor.commit();
    }
    //获取城市
    public static String getCity(){
        return sp.getString("city","火星");
    }
    public static void setCity(String city){
        editor.putString("city",city);
        editor.commit();
    }
    //获取头像
    public static String getFigureurl(){
        return sp.getString("figureurl"," ");
    }
    public static boolean setFigureurl(String figureurl){
        editor.putString("figureurl",figureurl);
       return editor.commit();
    }
    //个性签名
    public static String getSignature(){
        return sp.getString("signature","Ta 好像忘记写签名了...");
    }
    public static void setSignature(String signature){
        editor.putString("signature",signature);
        editor.commit();
    }
    public static String getAttentionPath(){
        return sp.getString("attentionPath","");
    }
    public static void setAttentionPath(String attentionPath){
        editor.putString("attentionPath",attentionPath);
        editor.commit();
    }
}
