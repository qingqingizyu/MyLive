package com.zmm.activity.city;

import android.content.Context;

import com.zmm.base.BaseRecyclerViewHolder;
import com.zmm.mylive.view.hot.Hot;
import com.zmm.mylive.view.hot.HotAdapter;

/**
 * 城市界面适配器，
 * 本界面跟热门界面大致相同就是点击事件不一样所以需要重写一下点击事件
 */

public class CityAdapter extends HotAdapter{

    private Context mContext;
    public CityAdapter(Context context) {
        super(context);
        this.mContext=context;
    }

    @Override
    public void starCity(BaseRecyclerViewHolder holder, Hot item) {

    }
}
