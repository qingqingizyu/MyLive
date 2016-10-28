package com.zmm.base;

import java.util.List;

/**
 * （1）加载数据的过程中需要提示“正在加载”的反馈信息给用户

 （2）加载成功后，将加载得到的数据填充到RecyclerView展示给用户

 （3）加载成功后，需要将“正在加载”反馈信息取消掉

（4）若加载数据失败，如无网络连接，则需要给用户提示信息
 */

public interface LiveView<T> extends IBaseView{
    //显示进度
    void showProgress();
    //获取接口连接
    String getPath();
    //获取实体bean
    Class<? extends Object> getBean();
    //数据加载成功
    void addLives(List<T> list);
    //取消进度
    void hideProgress();
    //加载失败
    void showLoadFailMsg();
}
