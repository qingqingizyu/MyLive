package com.zmm.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;

import com.zmm.mylive.R;
import com.zmm.widget.SwipeBackLayout;

/**
 * 随之手势右滑退出activity
 *
 */
public class SwipeBackActivity extends AppCompatActivity {
	protected SwipeBackLayout layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
				R.layout.base, null);
		layout.attachToActivity(this);
		Log.i("TAG","sssssssssssssss2sssssssssssssssssss1");
		String [] ss = new String[]{Manifest.permission.CAMERA
				,Manifest.permission.ACCESS_COARSE_LOCATION
				,Manifest.permission.ACCESS_FINE_LOCATION
				,Manifest.permission.ACCESS_WIFI_STATE
		,Manifest.permission.ACCESS_NETWORK_STATE
		,Manifest.permission.CHANGE_WIFI_STATE
		,Manifest.permission.READ_PHONE_STATE
		,Manifest.permission.WRITE_EXTERNAL_STORAGE
		,Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS
		,Manifest.permission.WAKE_LOCK
		,Manifest.permission.KILL_BACKGROUND_PROCESSES};
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
			int i = ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA);
			if (i!= PackageManager.PERMISSION_GRANTED){
				ActivityCompat.requestPermissions(this,ss,1);
				Log.i("TAG","ssssssssssssssssssssssssssssssssss1");
			}else {

				Log.i("TAG","ssssssssssssssssssew3ssssssssssssssss1");
				return;
			}

		}
	}
	
	
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
	}




	// Press the back button in mobile phone
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, R.anim.base_slide_right_out);
	}


}
