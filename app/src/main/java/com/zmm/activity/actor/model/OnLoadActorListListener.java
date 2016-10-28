package com.zmm.activity.actor.model;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public interface OnLoadActorListListener  {
    //加载成功
    void onSuccess(User user);
    //加载失败
    void onFailure(String msg, Throwable e);
}
