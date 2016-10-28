package com.zmm.activity.actor.view;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.activity.actor.model.User;
import com.zmm.activity.actor.presenter.ActorPresenter;
import com.zmm.activity.attention.UserDao;
import com.zmm.app.MyApp;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;
import com.zmm.utlis.DrawableSetting;
import com.zmm.utlis.FormatPathUtil;
import com.zmm.utlis.MyTextUtils;
import com.zmm.utlis.UIManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorInfActivity extends BaseActivity implements View.OnClickListener, ActorView {


    private ImageView levelImage;
    private TextView nickText, descText;
    private ListView listView;
    private CheckBox likeButton, hiteButton, chatButon;
    private ActorPresenter actorPresenter;
    private SimpleDraweeView simpleDraweeView;
    private Toolbar toolbar;
    private TextView barTitle;
    private TextView veri;
    private List<String> actorValue;
    private List<String> actorKey;
    private String[] key;
    private List<Map<String, String>> data;
    private Map<String, String> map;
    private boolean isLikeTrue = true;
    private boolean isHiteTrue = true;
    private String description;
    private String verified_reason;
    private int gender;
    private String nick;
    private String portrait;
    private String id;
    private UserDao dao;
    private int level;
    private int resID;

    @Override
    protected void initView() {
        //头像
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.actor_logo);
        nickText = (TextView) findViewById(R.id.actor_nick);//昵称
        levelImage = (ImageView) findViewById(R.id.actor_level);//等级
        veri = (TextView) findViewById(R.id.actor_veri_inf);//实名认证
        descText = (TextView) findViewById(R.id.actor_description);//描述，签名
        listView = (ListView) findViewById(R.id.actor_lisview);
        likeButton = (CheckBox) findViewById(R.id.actor_like);//关注
        hiteButton = (CheckBox) findViewById(R.id.actor_hite);//拉黑
        chatButon = (CheckBox) findViewById(R.id.actor_chat);//私信
        toolbar = (Toolbar) findViewById(R.id.actor_bar);
        barTitle = (TextView) findViewById(R.id.actor_bartitle);//Toolbar上的名字
        //设置RadioButton
        new DrawableSetting(this, likeButton, hiteButton, chatButon, 70, 70);
        //livePresenter负责完成View与Model间的逻辑和交互
        actorPresenter = new ActorPresenter(this);
        actorPresenter.loadData();//加载网络数据
        //监听
        setListener();
        //数据集合
        actorKey = new ArrayList<>();
        actorValue = new ArrayList<>();
        data = new ArrayList<>();
        keyValue();
        dao = new UserDao(this);

    }

    @Override
    public int getLayoutId() {
        return com.zmm.mylive.R.layout.activity_actor_inf;
    }

    //按钮
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actor_like:
                //可以通过获取数据库 里的值
                if (isLikeTrue) {
                    likeButton.setText("已关注");
                    isLikeTrue = false;
                    UIManager.showSnackbar(this, "已关注");
                    //将存入数据库
                    MyApp.setAttentionPath(getPath());
                } else {
                    UIManager.showSnackbar(this, "取消关注");
                    likeButton.setText("关注");
                    isLikeTrue = true;
                }
                save();
                break;
            case R.id.actor_hite:
                if (isHiteTrue) {
                    hiteButton.setText("已拉黑");
                    isHiteTrue = false;
                    UIManager.showSnackbar(this, "已拉黑");

                } else {
                    UIManager.showSnackbar(this, "取消拉黑");
                    hiteButton.setText("拉黑");
                    isHiteTrue = true;
                }
                break;

        }
    }

    private void save() {
        String sql = "select * from user where id = ?";
        Cursor select = dao.select(sql, new String[]{String.valueOf(id)});
        if (select != null) {
            if (select.moveToNext()) {
                //删除表中数据
                int columnIndex = select.getColumnIndex("id");
                String uid = select.getString(columnIndex);

                String whereClause = "id = ?";
                dao.delete("user", whereClause, new String[]{uid});
//                Toast.makeText(ActorInfActivity.this, "取消关注!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        ContentValues values = new ContentValues();
        values.put("id", String.valueOf(id));
        values.put("nick", nick);
        values.put("description", description);
        values.put("portrait", portrait);
        values.put("gender", String.valueOf(gender));
        values.put("resID",String.valueOf(resID));
        long insert = dao.insert("user", values);
        if (insert > 0) {
//            Toast.makeText(ActorInfActivity.this, "关注成功!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String getPath() {
        return getIntent().getStringExtra("path");
    }

    @Override
    public void addActor(User user) {
        //个人信息详情
        String birth = user.getUser().getBirth();
        //真实年龄
        String realAge = setAge(birth);
        //情感状态
        String emotion = user.getUser().getEmotion().trim();
        //家乡
        String hometown = user.getUser().getHometown().trim();
        //职业
        String profession = user.getUser().getProfession().trim();
        id = user.getUser().getId() + "";
        //个性签名
        description = user.getUser().getDescription().trim();
        verified_reason = user.getUser().getVerified_reason();
        //性别
        gender = user.getUser().getGender();
        String[] key = {realAge, emotion, hometown, profession, id, description};
        for (int i = 0; i < 6; i++) {
            String s = key[i];
            checked(s, i);
        }
        for (int j = 0; j < actorKey.size(); j++) {
            Map<String, String> mapKey = new HashMap<>();
            String rKey = actorKey.get(j);
            String rValue = actorValue.get(j);
            mapKey.put("value", rValue);
            mapKey.put("key", rKey);
            data.add(mapKey);
        }
        setAdapter();
        //头像
        Uri xiaoImg = FormatPathUtil.getXiaoImg(user.getUser().getPortrait());
        portrait = xiaoImg.toString();
        simpleDraweeView.setImageURI(xiaoImg);
        //别名
        nick = user.getUser().getNick();
        nickText.setText(nick);
        //设置toobaar
        barTitle.setText(nick);
        //设置主播等级
        //根据文件名获取图片id
        level = user.getUser().getLevel();
        resID = getResources().getIdentifier("rank_" + level, "mipmap", "com.zmm.mylive");
        levelImage.setImageResource(resID);
        String veri_info = user.getUser().getVeri_info();
        veri.setText(veri_info);
        descText.setText(description);

        String sql = "select * from user where id = ?";
        Cursor select = dao.select(sql, new String[]{String.valueOf(id)});
        if (select!=null && select.moveToNext()) {
            String uid = select.getString(select.getColumnIndex("id"));
            if (id.equals(uid)) {
                likeButton.setText("已关注");
                likeButton.setChecked(true);
            }

        } else {
            likeButton.setText("关注");
            likeButton.setChecked(false);
        }
    }

    @Override
    public void showLoadFailMsg() {
        UIManager.showSnackbar(this, "网路异常");
    }


    //监听
    private void setListener() {
        likeButton.setOnClickListener(this);
        hiteButton.setOnClickListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //listView 适配器
    private void setHomeAdapter() {
        //数据

    }

    //判断user数据
    private void checked(String vaule, int index) {

        if (!vaule.equals("0") && !vaule.equals("")) {
            actorValue.add(vaule);
        } else {
            actorKey.remove(index);
        }

    }

    //actorKey 值
    private void keyValue() {
        actorKey.add("年龄 ");
        actorKey.add("情感状态 ");
        actorKey.add(" 家乡");
        actorKey.add(" 职业");
        actorKey.add(" 映客号");
        actorKey.add(" 个性签名");
    }


    //设置listView适配器
    private void setAdapter() {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.actor_home, new String[]{"key", "value"}, new int[]{R.id.actor_home_key, R.id.actor_home_value});
        listView.setAdapter(simpleAdapter);
    }

    //处理年龄
    private String setAge(String date) {
        String[] split = date.split("-");
        String year = split[0];
        int y = Integer.parseInt(year);
        String month = split[1];
        int m = Integer.parseInt(month);
        String day = split[2];
        int d = Integer.parseInt(day);
        int age = MyTextUtils.getAge(y, m, d);
        String constellation = MyTextUtils.getConstellation(m, d);
        String sAge = String.valueOf(age);
        String ageInfor = sAge + " , " + constellation;
        return ageInfor;
    }

}
