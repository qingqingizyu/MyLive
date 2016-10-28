package com.zmm.leliving.view;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

import com.letv.recorder.bean.AudioParams;
import com.letv.recorder.bean.CameraParams;
import com.letv.recorder.callback.ISurfaceCreatedListener;
import com.letv.recorder.callback.PublishListener;
import com.letv.recorder.controller.CameraSurfaceView;
import com.letv.recorder.controller.Publisher;
import com.letv.recorder.ui.logic.RecorderConstance;
import com.zmm.mylive.R;
import com.zmm.utlis.UIManager;

/**
 * 移动直播
 * 注意,这个类仅供参考,如果逻辑与产品设置不符合,建议复制一份时候或者直接修改
 * 还需要自己监听网络、来电、
 */
public class CameraView extends CameraSurfaceView implements ISurfaceCreatedListener{
    private Context mContext;
    private Publisher publisher;
    private CameraParams cameraParams;
    private AudioParams audioParams;
    private final static String TAG = "CameraView";
    private boolean isBack = false;//后台标志,在进入后台之前正在推流设置为true。判断是否在后台回来时继续推流
    private String url;
    private TextView textView;//推流时间显示
    private int time = 0;
    public  ImageButton imageButton;
    private static AppCompatActivity co;

    public CameraView(Context context) {
        super(context);
    }

    public CameraView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public  static  void setBaseContext(AppCompatActivity  context){
        co = context;
    }
    public void init(Activity context,boolean isLandscape){
        this.mContext = context;
        publisher = Publisher.getInstance();
        publisher.initPublisher((Activity) mContext);
        publisher.getRecorderContext().setUseLanscape(isLandscape);//告诉推流器使用横屏推流还是竖屏推流
        cameraParams = publisher.getCameraParams();
        audioParams = publisher.getAudioParams();
        publisher.setPublishListener(listener);//设置推流状态监听器
        //绑定Camera显示View,要求必须是CameraSurfaceView
        publisher.getVideoRecordDevice().bindingGLView(this);
        //设置CameraSurfaceView 监听器,当CameraSurfaceView 创建成功的时候回回调onGLSurfaceCreatedListener,这个时候才能开启摄像头
        publisher.getVideoRecordDevice().setSurfaceCreatedListener(this);
        //////////////////以下设置必须在在推流之前设置,也可以不设置////////////////////////////////////////
        if(isLandscape){//设置流分辨率。要求宽度必须是16的整倍数,高度没有要求
            cameraParams.setWidth(640);
            cameraParams.setHeight(368);
        }else{
            cameraParams.setWidth(368);
            cameraParams.setHeight(640);
        }
        cameraParams.setCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT); //开启默认前置摄像头
        cameraParams.setVideoBitrate(2000*2000); //设置码率
        audioParams.setEnableVolumeGain(false);//开启音量调节,注意,这一点会影响性能,如果没有必要,设置为false
        cameraParams.setFocusOnTouch(false);//关闭对焦功能
        cameraParams.setFocusOnAnimation(false);//关闭对焦动画
        //publisher.getVideoRecordDevice().setFocusView(new View(getContext()));//设置对焦图片。如果需要对焦功能和对焦动画,请打开上边两个设置,并且在这里传入一个合适的View
        /////////////////////////////////////////////////////////////////////////////////////////////
    }

    @Override
    public void onPause() {
        super.onPause();
        if(publisher.isRecording()) { //正在推流
            isBack = true;
            publisher.stopPublish();//停止推流
        }
        //关闭摄像头
        publisher.getVideoRecordDevice().stop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        publisher.release();//销毁推流器
    }

    @Override
    public void onGLSurfaceCreatedListener() {
        publisher.getVideoRecordDevice().start();//打开摄像头
        if(isBack) {
            isBack = false;
            publish(url,textView,imageButton);
        }
    }

    /**
     * 开始推流
     * @param url 推流地址
     */
    public void publish(String url ,TextView textView,ImageButton imageButton){
        this.url = url;
        time = 0;
        this.textView =textView;
        this.imageButton = imageButton;
        if(!publisher.isRecording() && url != null){
            textView.setText("正在直播");
            publisher.setUrl(url);//设置推流地址
            publisher.publish();//在摄像头打开以后才能开始推流
            imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_stop));
            textView.setText("正在直播"+" "+ time);
        }else{
            textView.setText("直播结束");
            publisher.stopPublish(); //结束推流
            imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_stop));
        }
    }

    /**
     * 切换摄像头,需要注意,切换摄像头不能太频繁,如果太频繁会导致应用程序崩溃。建议最快10秒一次
     */

    boolean isSwitch = false;
    public void switchCamera(){
        if(isSwitch){
            UIManager.showSnackbar( co,"切换摄像头不能太频繁哦,等待10秒后在切换吧");
            return;
        }
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isSwitch = false;
            }
        },10*1000);
        isSwitch = true;
        int cameraID ;
        if(cameraParams.getCameraId() == Camera.CameraInfo.CAMERA_FACING_FRONT){
            cameraID = Camera.CameraInfo.CAMERA_FACING_BACK;
        }else{
            cameraID = Camera.CameraInfo.CAMERA_FACING_FRONT;
            if(flag) flag = !flag;//切换前置摄像头会自动关闭闪光灯
        }
        publisher.getVideoRecordDevice().switchCamera(cameraID);//切换摄像头
    }

    /**
     * 开启闪光灯。注意,当使用前置摄像头时不能打开闪光灯
     */
    boolean flag = false;
    public void changeFlash(ImageButton imageButton){
        if(cameraParams.getCameraId() != Camera.CameraInfo.CAMERA_FACING_FRONT) {
            flag = !flag;
            publisher.getVideoRecordDevice().setFlashFlag(flag);//切换闪关灯
            if (flag) {
                imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_flash_blue));
            }else {
                imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_flash_white));

            }
        }else{
            UIManager.showSnackbar(co,"前置摄像头不能打开闪关灯");
        }
    }

    /**
     * 切换滤镜,设置为0为关闭滤镜
     */
    int model = CameraParams.FILTER_VIDEO_NONE;//无效果
    public void switchFilter(){
        if(model == CameraParams.FILTER_VIDEO_NONE){
            model = CameraParams.FILTER_VIDEO_DEFAULT; //默认的美颜效果
        }else if (model == CameraParams.FILTER_VIDEO_DEFAULT){
            model = CameraParams.FILTER_VIDEO_CALM;//无效果
        }else  if (model == CameraParams.FILTER_VIDEO_CALM){
            model = CameraParams.FILTER_VIDEO_ROMANCE;
        }else if (model == CameraParams.FILTER_VIDEO_ROMANCE){
            model = CameraParams.FILTER_VIDEO_WARM;
        }else if (model ==CameraParams.FILTER_VIDEO_WARM){
            model = CameraParams.FILTER_VIDEO_NONE;
        }
        publisher.getVideoRecordDevice().setFilterModel(model);//切换滤镜
    }

    /**
     * 设置声音大小,必须对setEnableVolumeGain设置为true
     * @param volume 0-1为缩小音量,1为正常音量,大于1为放大音量
     */
    int volume = 1;
    public void setVolume(ImageButton imageButton){
        if(volume == 1){
            volume = 0;
            UIManager.showSnackbar( co,"已静音");
            imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_mic_white));
        }else{
            volume = 1;
            UIManager.showSnackbar(co,"正常音量");
            imageButton.setImageDrawable(getResources().getDrawable(R.mipmap.letv_recorder_mic_blue));
        }
        publisher.setVolumeGain(volume);//设置声音大小
    }
    private PublishListener listener = new PublishListener() {
        @Override
        public void onPublish(int code, String msg, Object... obj) {
            Message message = mHandler.obtainMessage(code);
            message.obj = msg;
            mHandler.sendMessage(message);
        }
    };
    private Handler mHandler = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            switch (msg.what){
                case RecorderConstance.RECORDER_OPEN_URL_SUCESS:
                    textView.setText("连接成功");
                    break;
                case RecorderConstance.RECORDER_OPEN_URL_FAILED:
                    textView.setText("连接失败");
                    break;
                case RecorderConstance.RECORDER_PUSH_FIRST_SIZE:
                    timerHandler.postDelayed(timerRunnable,1000);
                    break;
                case RecorderConstance.RECORDER_PUSH_AUDIO_PACKET_LOSS_RATE:
                    break;
                case RecorderConstance.RECORDER_PUSH_VIDEO_PACKET_LOSS_RATE:
                    UIManager.showSnackbar(co,"网速太慢了。。。");
                    break;
                case RecorderConstance.RECORDER_PUSH_ERROR:
                    UIManager.showSnackbar(co,"请检查网络");
                    textView.setText("推流出错");
                    break;
                case RecorderConstance.RECORDER_PUSH_STOP_SUCCESS:
                    textView.setText("直播结束");
                    break;
            }
        }
    };

    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if(publisher.isRecording()){
                time++;
                textView.setText("时间:"+time);
                timerHandler.postDelayed(timerRunnable,1000);
            }
        }
    };

}
