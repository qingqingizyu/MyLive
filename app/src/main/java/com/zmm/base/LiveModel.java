package com.zmm.base;

/**
 * 加载网路数据的接口
 * String url 网络请求的地址
 * Class<? extends Object> clazz 具体的实体类 的class 文件 需要通过class文件 进行不同的json解析
 * OnLoadLiveListListener listener 获取网络数据的监听
 */

public interface LiveModel extends IBaseModle{
    void loadLives(String url, Class<? extends Object> clazz, OnLoadLiveListListener listener);
}
