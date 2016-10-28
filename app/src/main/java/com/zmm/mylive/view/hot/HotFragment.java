package com.zmm.mylive.view.hot;


import com.zmm.Constant;
import com.zmm.app.MyApp;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseFragment;

/**
 *热门的直播
 */
public class HotFragment extends BaseFragment {

    @Override
    public  int getSpanCount() {
        return 1;
    }

    @Override
    public BaseAdapter getAdapter() {
        return new HotAdapter(getActivity());
    }

    @Override
    public String getPath() {
        return Constant.HOT_PATH[MyApp.getLikeRead()];
    }

    @Override
    public Class<?> getBean() {
        return Hot.class;
    }
}
