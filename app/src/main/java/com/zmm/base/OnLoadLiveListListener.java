package com.zmm.base;

import java.util.List;

/**
 * 加载网路数据成功或者失败的监听
 */

public interface OnLoadLiveListListener {
    void onSuccess(List<? extends Object> list);
    void onFailure(String msg, Throwable e);
}
