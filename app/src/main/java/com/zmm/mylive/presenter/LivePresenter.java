package com.zmm.mylive.presenter;

import android.util.Log;

import com.zmm.base.IBasePresenter;
import com.zmm.mylive.model.LiveModelImpl;
import com.zmm.base.OnLoadLiveListListener;
import com.zmm.base.LiveView;

import java.util.List;

/**
 * 中间人
 */

public class LivePresenter implements IBasePresenter {
    //数据
    private LiveModelImpl impl;
    //视图
    private LiveView mView;

    public LivePresenter(LiveView view) {
        impl = new LiveModelImpl();
        this.mView = view;
    }
    //加载数据
    public void loadData() {
        //显示进度
        mView.showProgress();
        //加载数据
        impl.loadLives(mView.getPath(), mView.getBean(), new OnLoadLiveListListener() {
            @Override
            public void onSuccess(final List<? extends Object> list) {
                //添加集合数据
                mView.addLives(list);
                //隐藏进度条
                mView.hideProgress();
            }

            @Override
            public void onFailure(String msg, Throwable e) {
                Log.e("SSS", msg + e.getMessage());
                //加载失败显示的信息
                mView.showLoadFailMsg();
                //隐藏进度条
                mView.hideProgress();
            }
        });
    }
}
