package com.zmm.activity.live;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zmm.mylive.R;
import com.zmm.widget.NEMediaController;
import com.zmm.widget.NEVideoView;

//直播界面
public class LiveActivity extends AppCompatActivity {
    private NEVideoView mVideoView;
    private NEMediaController mMediaController;
    private ImageButton mPlayBack;
    private TextView mFileName; //文件名称
    private String mTitle, path;
    private boolean mHardware = true;
    private RelativeLayout mPlayToolbar;
    private View mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        overridePendingTransition(R.anim.welcome_open,R.anim.activity_cloes);
        setContentView(R.layout.activity_live);
        initView();
    }
    protected void initView() {
        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        playLive();
        setFileName(intent.getStringExtra("title"));

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLive();
    }

    private void playLive() {
        mPlayBack = (ImageButton) findViewById(R.id.player_exit);//退出播放
        mPlayBack.getBackground().setAlpha(0);
        mFileName = (TextView) findViewById(R.id.file_name);

        mPlayToolbar = (RelativeLayout) findViewById(R.id.play_toolbar);
        mPlayToolbar.setVisibility(View.INVISIBLE);

        mLoadingView = findViewById(R.id.buffering_prompt);

        mVideoView = (NEVideoView) findViewById(R.id.video_view);
        mMediaController = new NEMediaController(this);

    }



    private void loadLive() {
        mVideoView.setMediaController(mMediaController);
        mVideoView.setBufferingIndicator(mLoadingView);
        mVideoView.setMediaType("livestream");
        mVideoView.setHardwareDecoder(mHardware);
        mVideoView.setPauseInBackground(false);
        mVideoView.setVideoPath(path);
        mVideoView.requestFocus();
        mVideoView.start();

        mPlayBack.setOnClickListener(mOnClickEvent); //监听退出播放的事件响应
        mMediaController.setOnShownListener(mOnShowListener); //监听mediacontroller是否显示
        mMediaController.setOnHiddenListener(mOnHiddenListener); //监听mediacontroller是否隐藏
    }

    View.OnClickListener mOnClickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.player_exit) {
                finish();
            }
        }
    };

    NEMediaController.OnShownListener mOnShowListener = new NEMediaController.OnShownListener() {

        @Override
        public void onShown() {
            mPlayToolbar.setVisibility(View.VISIBLE);
            mPlayToolbar.requestLayout();
            mVideoView.invalidate();
            mPlayToolbar.postInvalidate();
        }
    };

    NEMediaController.OnHiddenListener mOnHiddenListener = new NEMediaController.OnHiddenListener() {

        @Override
        public void onHidden() {
            mPlayToolbar.setVisibility(View.INVISIBLE);
        }
    };

    public void setFileName(String name) { //设置文件名并显示出来
        mTitle = name;
        if (mFileName != null)
            mFileName.setText(mTitle);

        mFileName.setGravity(Gravity.CENTER);
    }

    @Override
    protected void onDestroy() {
        mVideoView.release_resource();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mVideoView.pause();
    }

    @Override
    public void onStart() {
        super.onStart();
        mVideoView.start();
    }
}
