package com.zmm.mylive.view.recommend;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.base.BaseAdapter;
import com.zmm.base.BaseRecyclerViewHolder;
import com.zmm.mylive.R;
import com.zmm.utlis.FormatPathUtil;
import com.zmm.utlis.UIManager;

import java.util.ArrayList;

/**
 * 因为这个接口十分复杂 所以我直接把他封装成了一个对象了，
 * 接下来要用一个对象显示所有数据，写的可能非常low，见谅！！！
 */

public class RecommendAdapter extends BaseAdapter<Recommend> implements View.OnClickListener {
    private Context mContext;

    public RecommendAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int setItemLayoutId() {
        return R.layout.recommend_list_item;
    }

    @Override
    public void bindConvert(BaseRecyclerViewHolder holder, int position, Recommend item) {
        //得到母布局
        LinearLayout linearLayout = holder.getView(R.id.recommend_layout);
        // 给要加载的布局设置参数
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        // 放布局的list
        ArrayList<View> listViews = new ArrayList<View>();
        for (int i = 0; i < item.getLive_nodes().size(); i++) {//for循环Live对像集合
            // 调inflate方法把布局转化成对象
            View title = View.inflate(mContext, R.layout.child_recommend_item_title, null);//直播集合标题
            View live = View.inflate(mContext, R.layout.child_recommend_item_live, null);//直播
            listViews.add(title);
            listViews.add(live);
        }
        for (int i = 0; i < item.getUser_nodes().size(); i++) {//for循环用户对像集合
            View title = View.inflate(mContext, R.layout.child_recommend_item_title, null);//用户标题
            listViews.add(title);
            Recommend.UserNodesBean userNodesBean = item.getUser_nodes().get(i);
            for (int i1 = 0; i1 < userNodesBean.getUsers().size(); i1++) {
                View user = View.inflate(mContext, R.layout.child_recommend_item_user, null);//用户对象
                listViews.add(user);
            }
        }
        boolean flag = true;//定义一个标记
        linearLayout.removeAllViews();//移除所有子布局
        for (int i = 0; i < listViews.size(); i++) {
            if (i < item.getLive_nodes().size()) {
                for (int i1 = 0; i1 < item.getLive_nodes().size(); i1++) {
                    LinearLayout layout = (LinearLayout) listViews.get(i);//找到list中的布局
                    LinearLayout layout_title = (LinearLayout) layout.inflate(mContext, R.layout.child_recommend_item_title, null);//布局转化成对象
                    //得到布局中的标题控件
                    TextView tvTitle = getTextView(layout_title, R.id.child_item_title_msg);
                    String title = item.getLive_nodes().get(i1).getTitle();
                    tvTitle.setText(title);
                    //设置点击事件
                    TextView tvMore = getTextView(layout_title, R.id.child_item_title_more);
                    tvMore.setTag(title);
                    tvMore.setOnClickListener(this);
                    linearLayout.addView(layout_title, params);//把布局放到源布局中
                    i++;
                    //live布局
                    layout = (LinearLayout) listViews.get(i);//找到list中的布局
                    LinearLayout layout_live = (LinearLayout) layout.inflate(mContext, R.layout.child_recommend_item_live, null);//布局转化成对象
                    //绑定图片
                    Recommend.LiveNodesBean.LivesBean livesBean1 = item.getLive_nodes().get(i1).getLives().get(0);
                    SimpleDraweeView simpleDraweeView1 = getSimpleDraweeView(layout_live, R.id.child_item_live_sdv1);
                    simpleDraweeView1.setImageURI(FormatPathUtil.getZhongImg(livesBean1.getCreator().getPortrait()));
                    simpleDraweeView1.setTag(livesBean1);
                    simpleDraweeView1.setOnClickListener(this);
                    //绑定在线人数
                    getTextView(layout_live, R.id.child_item_live_online1).setText(livesBean1.getOnline_users() + "人");

                    //绑定图片
                    Recommend.LiveNodesBean.LivesBean livesBean2 = item.getLive_nodes().get(i1).getLives().get(1);
                    SimpleDraweeView simpleDraweeView2 = getSimpleDraweeView(layout_live, R.id.child_item_live_sdv2);
                    simpleDraweeView2.setImageURI(FormatPathUtil.getZhongImg(livesBean2.getCreator().getPortrait()));
                    simpleDraweeView2.setTag(livesBean2);
                    simpleDraweeView2.setOnClickListener(this);
                    //绑定在线人数
                    getTextView(layout_live, R.id.child_item_live_online2).setText(livesBean2.getOnline_users() + "人");

                    //绑定图片
                    Recommend.LiveNodesBean.LivesBean livesBean3 = item.getLive_nodes().get(i1).getLives().get(2);
                    SimpleDraweeView simpleDraweeView3 = getSimpleDraweeView(layout_live, R.id.child_item_live_sdv3);
                    simpleDraweeView3.setImageURI(FormatPathUtil.getZhongImg(livesBean3.getCreator().getPortrait()));
                    simpleDraweeView3.setTag(livesBean3);
                    simpleDraweeView3.setOnClickListener(this);
                    //绑定在线人数
                    getTextView(layout_live, R.id.child_item_live_online3).setText(livesBean3.getOnline_users() + "人");
                    linearLayout.addView(layout_live, params);//把布局放到源布局中
                }
            } else {
                if (flag) {//true的时候表示是title的布局
                    flag = false;
                    LinearLayout layout = (LinearLayout) listViews.get(i);//找到list中的布局
                    LinearLayout layout_title = (LinearLayout) layout.inflate(mContext, R.layout.child_recommend_item_title, null);//布局转化成对象
                    //得到布局中的标题控件
                    TextView tvTitle = getTextView(layout_title, R.id.child_item_title_msg);
                    tvTitle.setText(item.getUser_nodes().get(0).getTitle());
                    //隐藏more的控件
                    TextView tvMore = getTextView(layout_title, R.id.child_item_title_more);
                    tvMore.setVisibility(View.INVISIBLE);
                    linearLayout.addView(layout_title, params);//把布局放到源布局中
                } else {//其余的就是user的布局
                    for (int i1 = 0; i1 < item.getUser_nodes().get(0).getUsers().size(); i1++) {
                        LinearLayout layout = (LinearLayout) listViews.get(i);//找到list中的布局
                        LinearLayout layout_user = (LinearLayout) layout.inflate(mContext, R.layout.child_recommend_item_user, null);//布局转化成对象
                        Recommend.UserNodesBean.UsersBean usersBean = item.getUser_nodes().get(0).getUsers().get(i1);
                        //绑定头像
                        SimpleDraweeView simpleDraweeView = getSimpleDraweeView(layout_user, R.id.child_item_user_sdv);
                        simpleDraweeView.setImageURI(FormatPathUtil.getXiaoImg(usersBean.getUser().getPortrait()));
                       //绑定昵称
                        TextView tvNick = getTextView(layout_user, R.id.child_item_user_nick);
                        tvNick.setText(usersBean.getUser().getNick());
                        //绑定性别
                        ImageView imageView = getImageView(layout_user, R.id.child_item_user_gender);
                        switch (usersBean.getUser().getGender()){
                            case 0://表示女
                                imageView.setImageResource(R.mipmap.global_icon_female);
                                break;
                            case 1://表示男
                                imageView.setImageResource(R.mipmap.global_icon_male);
                                break;
                            default://默认女
                                imageView.setImageResource(R.mipmap.global_icon_female);
                                break;
                        }
                        //绑定等级
                        ImageView imageView1 = getImageView(layout_user, R.id.child_item_user_level);
                        //根据文件名获取图片id
                        int resID = mContext.getResources().getIdentifier("rank_" + usersBean.getUser().getLevel(), "mipmap", "com.zmm.mylive");
                        imageView1.setImageResource(resID);

                        //绑定推荐理由
                        TextView textView = getTextView(layout_user, R.id.child_item_user_reason);
                        textView.setText(usersBean.getReason());

//                        点击事件
                        LinearLayout layoutClick = (LinearLayout) layout_user.findViewById(R.id.child_item_user_click);
                        layoutClick.setTag(usersBean.getUser().getId());
                        layoutClick.setOnClickListener(this);

                        linearLayout.addView(layout_user, params);//把布局放到源布局中
                        i++;
                        if (i>= listViews.size()){
                            break;
                        }
                    }
                }
            }
        }
    }


    //获取TextView控件
    private TextView getTextView(LinearLayout layout_title, int id) {
        return (TextView) layout_title.findViewById(id);
    }

    //获取SimpleDraweeView控件
    private SimpleDraweeView getSimpleDraweeView(LinearLayout layout_title, int id) {
        return (SimpleDraweeView) layout_title.findViewById(id);
    }

    //获取ImageView控件
    private ImageView getImageView(LinearLayout layout_title, int id) {
        return (ImageView) layout_title.findViewById(id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.child_item_title_more://跳转到更多的界面
                String title = (String) v.getTag();//得到标题
                UIManager.startMore(mContext, FormatPathUtil.getMorePath(title), title);
                break;
            case R.id.child_item_live_sdv1://跳转到对应的主播间
                Recommend.LiveNodesBean.LivesBean livesBean1 = (Recommend.LiveNodesBean.LivesBean) v.getTag();
                UIManager.startLive(mContext, livesBean1.getStream_addr(), livesBean1.getCreator().getNick());
                break;
            case R.id.child_item_live_sdv2://跳转到对应的主播间
                Recommend.LiveNodesBean.LivesBean livesBean2 = (Recommend.LiveNodesBean.LivesBean) v.getTag();
                UIManager.startLive(mContext, livesBean2.getStream_addr(), livesBean2.getCreator().getNick());
                break;
            case R.id.child_item_live_sdv3://跳转到对应的主播间
                Recommend.LiveNodesBean.LivesBean livesBean3 = (Recommend.LiveNodesBean.LivesBean) v.getTag();
                UIManager.startLive(mContext, livesBean3.getStream_addr(), livesBean3.getCreator().getNick());
                break;
            case R.id.child_item_user_click://跳转到主播详情界面
                int id = (int) v.getTag();
                UIManager.startActor(mContext,FormatPathUtil.getStartRecomPath(id));
                break;
        }
    }
}
