package com.zmm.mylive.view.nearby;


import com.zmm.app.MyApp;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseFragment;

/**
 * 附近的直播
 *
 */
public class NearbyFragment extends BaseFragment {
    NearbyPath path = new NearbyPath();
    @Override
    public  int getSpanCount() {
        return 3;
    }

    @Override
    public BaseAdapter getAdapter() {
        return new NearbyAdapter(getActivity());
    }

    @Override
    public String getPath() {
        return  path.getNearbyPath(MyApp.getLikeRead());
    }

    @Override
    public Class<?> getBean() {
        return Nearby.class;
    }
}
