package com.zmm.utlis;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.zmm.activity.actor.view.ActorInfActivity;
import com.zmm.activity.city.CityActivity;
import com.zmm.activity.live.LiveActivity;
import com.zmm.activity.login.LoginActivity;
import com.zmm.activity.more.MoreActivity;
import com.zmm.activity.popup.PopupActivity;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;
import com.zmm.mylive.view.MainActivity;
import com.zmm.mylive.view.WelcomeActivity;

/**
 * 页面跳转管理器
 */

public class UIManager {
    /**
     * 打开cityActivity
     * @param context
     */
    public static void startCity(Context context, String path,String title){
        Intent intent = new Intent();
        intent.putExtra("path",path);
        intent.putExtra("title",title);
        intent.setClass(context, CityActivity.class);
        context.startActivity(intent);
    }
    public static void startMore(Context context, String path,String title){
        Intent intent = new Intent();
        intent.putExtra("path",path);
        intent.putExtra("title",title);
        intent.setClass(context, MoreActivity.class);
        context.startActivity(intent);
    }
    public  static  void startActor(Context context,String path){
        Intent intent = new Intent(context, ActorInfActivity.class);
        intent.putExtra("path",path);
        context.startActivity(intent);

    }
    public static void startLive(Context context,String path,String title){
        Intent intent = new Intent();
        intent.putExtra("path",path);
        intent.putExtra("title",title);
        intent.setClass(context, LiveActivity.class);
        context.startActivity(intent);
    }
    public static void intentWelcome(Context context){
        Intent intent = new Intent(context, WelcomeActivity.class);
        context.startActivity(intent);
    }
    //顶部snackbar的封装方法
    public static void showSnackbar(FragmentActivity context, String msg) {
        TSnackbar snackbar = TSnackbar
                .make(context.findViewById(android.R.id.content), msg, TSnackbar.LENGTH_SHORT).setActionTextColor(Color.WHITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#55BEFB"));//背景
        ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(Color.WHITE);//修改字体颜色
        snackbar.show();
    }
    //顶部snackbar的封装方法
    public static void showSnackbar(BaseActivity context, String msg) {
        TSnackbar snackbar = TSnackbar
                .make(context.findViewById(android.R.id.content), msg, TSnackbar.LENGTH_SHORT).setActionTextColor(Color.WHITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#55BEFB"));//背景
        ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(Color.WHITE);//修改字体颜色
        snackbar.show();
    }
    public static void intentPopup(Context context){
        Intent intent = new Intent(context,PopupActivity.class);
        context.startActivity(intent);
    }
    public static void startMain(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra("login","login");
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    public static void startLogin(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
    public static void showSnackbar(AppCompatActivity context, String msg) {
        TSnackbar snackbar = TSnackbar
                .make(context.findViewById(android.R.id.content), msg, TSnackbar.LENGTH_SHORT).setActionTextColor(Color.WHITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.parseColor("#55BEFB"));//背景
        ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(Color.WHITE);//修改字体颜色
        snackbar.show();
    }

}
