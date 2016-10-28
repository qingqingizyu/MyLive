package com.zmm.activity.actor.presenter;

import android.util.Log;

import com.zmm.activity.actor.view.ActorView;
import com.zmm.activity.actor.model.OnLoadActorListListener;
import com.zmm.activity.actor.model.User;
import com.zmm.activity.actor.model.ActorModelImpl;
import com.zmm.base.IBasePresenter;

/**
 * Created by Administrator on 2016/10/11 0011.
 */

public class ActorPresenter implements IBasePresenter {
    //数据
    private ActorModelImpl impl;
    //视图
    private ActorView mView;
    public ActorPresenter(ActorView view) {
        impl = new ActorModelImpl();
        this.mView = view;
    }
    //加载数据
    public void loadData() {
        //加载数据
        impl.loadLives(mView.getPath(), new OnLoadActorListListener() {
            @Override
            public void onSuccess(User user) {
                mView.addActor(user);
            }

            @Override
            public void onFailure(String msg, Throwable e) {
                Log.e("SSS", msg + e.getMessage());
                //加载失败显示的信息
                mView.showLoadFailMsg();
            }
        } );
    }
}
