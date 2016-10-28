package com.zmm.mylive.view.hot;


import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseRecyclerViewHolder;
import com.zmm.mylive.R;
import com.zmm.utlis.FormatPathUtil;
import com.zmm.utlis.UIManager;

/**
 * 热门界面的适配器
 * BaseAdapter<Hot> 泛型是自己依赖的实体对象
 * 点击事件需要在适配器中写
 */


public class HotAdapter extends BaseAdapter<Hot> {
    private Context mContext;

    public HotAdapter(Context context) {
        this.mContext = context;
    }

    //给父类一个布局id
    @Override
    public int setItemLayoutId() {
        return R.layout.hot_list_item;
    }

    //处理绑定布局
    @Override
    public void bindConvert(BaseRecyclerViewHolder holder, int position, final Hot item) {
        //绑定头像
        SimpleDraweeView ivHead = holder.getView(R.id.hot_sdv_head);
        ivHead.setImageURI(FormatPathUtil.getXiaoImg(item.getCreator().getPortrait()));
        //绑定昵称
        TextView tvNick = holder.getView(R.id.hot_tv_nick);
        tvNick.setText(item.getCreator().getNick());
        //绑定城市
        final TextView tvCity = holder.getView(R.id.hot_tv_city);
        tvCity.setText(getCityName(item.getCity()));

        //绑定在线观看人数
        TextView tvOnline = holder.getView(R.id.hot_tv_online_users);
        tvOnline.setText("" + item.getOnline_users());
        //绑定直播间图片
        SimpleDraweeView ivRoom = holder.getView(R.id.hot_sdv_room);

        ivRoom.setImageURI(FormatPathUtil.getDaImg(item.getCreator().getPortrait()));
        //绑定主播的评论 有的主播可能没有评论
        TextView tvMsg = holder.getView(R.id.hot_tv_msg);
        String msg = item.getName();
        if (!"".equals(msg)) {
            tvMsg.setVisibility(View.VISIBLE);
            tvMsg.setText(msg);
        } else {
            tvMsg.setVisibility(View.GONE);
        }
        //头像点击事件
        ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.startActor(mContext,FormatPathUtil.getStartPath(item.getCreator().getId()));
            }
        });
        //第一个相对布局的点击事件
        //跳到该城市的activity
        starCity(holder, item);

        //第二个相对布局的点击事件
        //跳到该主播的直播间
        starLiveRoom(holder, item);
    }

    //第二个相对布局的点击事件
    //跳到该主播的直播间
    private void starLiveRoom(BaseRecyclerViewHolder holder, final Hot item) {
        holder.getView(R.id.hot_lout2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIManager.startLive(mContext, item.getStream_addr(),item.getCreator().getNick());//打开直播界面
            }
        });
    }

    //第一个相对布局的点击事件
    public void starCity(BaseRecyclerViewHolder holder, final Hot item) {
        holder.getView(R.id.hot_lout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //根据城市名字生成对应的请求地址
                String cityPath = FormatPathUtil.getCityPath(getCityName(item.getCity()));
                //打开城市所在的activity，传入参数 城市名字和 城市网络请求的地址
                UIManager.startCity(mContext, cityPath, getCityName(item.getCity()));
            }
        });
    }

    //得到城市名字的方法
    private String getCityName(String city) {
        return "".equals(city) || city == null ? "火星" : city;
    }
}