package com.zmm.activity.actor.view;

import com.zmm.activity.actor.model.User;
import com.zmm.base.IBaseView;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public interface ActorView extends IBaseView {
    //获取接口连接
    String getPath();
    //数据加载成功
    void addActor(User user);
    //加载失败
    void showLoadFailMsg();
}
