package com.zmm.leliving;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zmm.base.SwipeBackActivity;
import com.zmm.leliving.view.CameraView;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;


public class LeLiveMainActivity extends SwipeBackActivity {
    //设置推流地址
    private  String path ="rtmp://13299.mpush.live.lecloud.com/live/2222";
    //拉流地址rtmp://13299.mpull.live.lecloud.com/live/2222
    private CameraView cameraView;
    private ImageButton listenerImageButton;
    private TextView textView;
    private ImageButton flashButton;
    private ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.activity_letvmain);
        overridePendingTransition(R.anim.activity_open,R.anim.activity_cloes);

        CameraView.setBaseContext(this);
        cameraView = (CameraView) findViewById(R.id.camera_view);
        startButton = (ImageButton) findViewById(R.id.open) ;
        startButton.setOnClickListener(listener);// 开始推流点击事件
        flashButton = (ImageButton) findViewById(R.id.change_flash);
        flashButton.setOnClickListener(listener);//闪光灯点击事件
        findViewById(R.id.switch_filter).setOnClickListener(listener);//滤镜点击事件
        findViewById(R.id.switch_camera).setOnClickListener(listener);//切换摄像头点击事件
        listenerImageButton = (ImageButton) findViewById(R.id.set_volume);
        textView = (TextView) findViewById(R.id.letvtitle);
        listenerImageButton.setOnClickListener(listener);//声音点击事件
        cameraView.init(this,false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cameraView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cameraView.onDestroy();
    }




    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.open://开始推流以及结束推流
                    cameraView.publish(path,textView,startButton);
                    break;
                case R.id.change_flash://切换闪光灯
                    cameraView.changeFlash(flashButton);
                    break;
                case R.id.switch_filter: //切换滤镜效果
         UIManager.showSnackbar(LeLiveMainActivity.this,"滤镜更换成功");
                    cameraView.switchFilter();
                    break;
                case R.id.switch_camera://切换前后置摄像头
                    cameraView.switchCamera();
                    break;
                case R.id.set_volume://切换声音
                    cameraView.setVolume(listenerImageButton);
                    break;
            }
        }
    };






}
