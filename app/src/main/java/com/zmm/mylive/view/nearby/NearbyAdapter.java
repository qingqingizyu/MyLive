package com.zmm.mylive.view.nearby;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseRecyclerViewHolder;
import com.zmm.mylive.R;
import com.zmm.utlis.FormatPathUtil;
import com.zmm.utlis.UIManager;

/**
 * 附近界面的适配器
 * BaseAdapter<Nearby> 泛型是自己依赖的实体对象
 * 点击事件需要在适配器中写
 */

public class NearbyAdapter extends BaseAdapter<Nearby> {
    private Nearby mItem;
    private Context mContext;

    public NearbyAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int setItemLayoutId() {
        return R.layout.nearby_list_item;
    }

    @Override
    public void bindConvert(BaseRecyclerViewHolder holder, int position, final Nearby item) {
        mItem = item;
        //绑定图片
        SimpleDraweeView ivRoom = holder.getView(R.id.nearby_sdv_room);
        ivRoom.setImageURI(FormatPathUtil.getZhongImg(item.getCreator().getPortrait()));
        //绑定距离
        TextView tvDistance = holder.getView(R.id.nearby_tv_distance);
        //距离可能为空所以判断一下
        String distance = item.getDistance();
        if (distance == null || "".equals(distance)) {
            //当距离为空就绑定城市
            String city = item.getCity();
            //城市也可能为空所以判断下
            if (city == null || "".equals(city)) {//城市为空的话就给个默认的
                tvDistance.setText("火星");
            } else {
                tvDistance.setText(city);//绑定城市
            }
        } else {
            tvDistance.setText(distance);//绑定距离
        }
        //设置主播等级
        ImageView ivLevel = holder.getView(R.id.nearby_iv_level);
        //根据文件名获取图片id
        int resID = mContext.getResources().getIdentifier("rank_" + item.getCreator().getLevel(), "mipmap", "com.zmm.mylive");
        ivLevel.setImageResource(resID);
        //点击监听
        ivRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.startLive(mContext, item.getStream_addr(),item.getCreator().getNick());//打开直播界面
            }
        });
    }

}
