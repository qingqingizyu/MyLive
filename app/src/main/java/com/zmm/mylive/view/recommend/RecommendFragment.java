package com.zmm.mylive.view.recommend;


import android.support.v4.app.Fragment;

import com.zmm.Constant;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment {
    @Override
    public int getSpanCount() {
        return 1;
    }

    @Override
    public BaseAdapter getAdapter() {

        return new RecommendAdapter(getActivity());
    }

    @Override
    public String getPath() {
        return Constant.RECOMMEND_PATH;
    }

    @Override
    public Class<?> getBean() {
        return Recommend.class;
    }

}
