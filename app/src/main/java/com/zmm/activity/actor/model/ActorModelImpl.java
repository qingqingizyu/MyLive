package com.zmm.activity.actor.model;

import com.google.gson.Gson;
import com.zmm.utlis.OkHttpClientUtils;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class ActorModelImpl implements ActorModel {
    @Override
    public void loadLives(final String url, final OnLoadActorListListener listener) {
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
//                        try {
//                            JSONObject object = new JSONObject(s);
//                            String obj = object.getString("user");
                            Gson gson = new Gson();
                            User user = gson.fromJson(s, User.class);
                            //将封装好的集合回调给访问网络成功的接口
                                listener.onSuccess(user);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            //将异常回调给访问网络失败的接口
//                            listener.onFailure("数据解析异常", e);
//                        }
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
