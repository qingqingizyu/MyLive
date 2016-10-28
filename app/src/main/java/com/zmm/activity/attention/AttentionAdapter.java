package com.zmm.activity.attention;

import android.content.Context;

import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseRecyclerViewHolder;
import com.zmm.mylive.R;
import com.zmm.mylive.view.recommend.Recommend;

/**
 * Created by zouzouzou1 on 2016/10/15.
 */

public class AttentionAdapter extends BaseAdapter<Recommend> {
    private Context mContext;

    public AttentionAdapter(Context context) {
        this.mContext = context;
    }
    @Override
    public int setItemLayoutId() {
        return R.id.child_item_user_layout;
    }

    @Override
    public void bindConvert(BaseRecyclerViewHolder holder, int position, Recommend item) {

    }
}
