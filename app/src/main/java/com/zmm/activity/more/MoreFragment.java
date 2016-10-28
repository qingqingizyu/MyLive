package com.zmm.activity.more;

import android.os.Bundle;

import com.zmm.mylive.view.hot.HotFragment;

/**
 * 更多界面的Fragment
 */

public class MoreFragment extends HotFragment {

    @Override
    public String getPath() {
        //获取activity传过来的地址
        Bundle arguments = getArguments();
        return arguments.getString("path");
    }
}
