package com.zmm.mylive.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zmm.activity.actor.model.User;
import com.zmm.base.LiveModel;
import com.zmm.base.OnLoadLiveListListener;
import com.zmm.mylive.view.hot.Hot;
import com.zmm.mylive.view.nearby.Nearby;
import com.zmm.mylive.view.recommend.Recommend;
import com.zmm.utlis.OkHttpClientUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 加载网络数据 具体的实现类
 * 利用RxJava 写的
 */

public class LiveModelImpl implements LiveModel {
    @Override
    public void loadLives(final String url, final Class<? extends Object> clazz, final OnLoadLiveListListener listener) {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    //网路请求返回json字符串
                    String json = OkHttpClientUtils.getStringFromUrl(url);
                    //传递最后的结果
                    subscriber.onNext(json);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    e.printStackTrace();
                    subscriber.onError(e);//传递错误信息
                }
            }
        })
                .subscribeOn(Schedulers.newThread())//声明网络请求在工作线程
                .observeOn(AndroidSchedulers.mainThread())//声明subscribe在UI线程
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        try {
                            JSONObject object = new JSONObject(s);
                            if (clazz == Hot.class) {//根据提供的字节码不同进行不同的解析和封装集合
                                String lives = object.getString("lives");
                                Gson gson = new Gson();
                                List<Hot> list = gson.fromJson(lives, new TypeToken<List<Hot>>() {
                                }.getType());
                                //将封装好的集合回调给访问网络成功的接口
                                listener.onSuccess(list);
                            }else if (clazz == Nearby.class){
                                String lives = object.getString("lives");
                                Gson gson = new Gson();
                                List<Nearby> list = gson.fromJson(lives, new TypeToken<List<Nearby>>() {
                                }.getType());
                                //将封装好的集合回调给访问网络成功的接口
                                listener.onSuccess(list);
                            }else if(clazz == User.class){
                                String user = object.getString("user");
                                Gson gson = new Gson();
                                List<User> list = gson.fromJson(user, new TypeToken<List<User>>() {
                                }.getType());
                                //将封装好的集合回调给访问网络成功的接口
                                listener.onSuccess(list);
                            }else if(clazz == Recommend.class){
                                Gson gson = new Gson();
                                Recommend recommend = gson.fromJson(s, Recommend.class);
                                List<Recommend> list = new ArrayList<>();
                                list.add(recommend);
                                //将封装好的集合回调给访问网络成功的接口
                                listener.onSuccess(list);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //将异常回调给访问网络失败的接口
                            listener.onFailure("数据解析异常", e);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //将异常回调给访问网络失败的接口
                        listener.onFailure("网路异常",throwable );
                    }
                });
    }
}
