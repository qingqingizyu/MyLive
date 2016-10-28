package com.zmm.activity.city;

import android.os.Bundle;

import com.zmm.base.BaseAdapter;
import com.zmm.mylive.view.hot.HotFragment;

/**
 * 城市所在的直播
 */

public class CityFragment extends HotFragment {

    @Override
    public BaseAdapter getAdapter() {
        return new CityAdapter(getActivity());
    }

    @Override
    public String getPath() {
        //获取activity传过来的地址
        Bundle arguments = getArguments();
        return arguments.getString("path");
    }
}
