package com.zmm.activity.attention;

import android.database.Cursor;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zmm.base.BaseActivity;
import com.zmm.mylive.R;
import com.zmm.utlis.FormatPathUtil;
import com.zmm.utlis.UIManager;

public class AttentionActivity extends BaseActivity {

    private ListView mLv;
    private Cursor cursor;

    @Override
    protected void initView() {
        mLv = (ListView) findViewById(R.id.recycle_view_attention);
        Toolbar toolBar = (Toolbar) findViewById(R.id.activity_attention_tool_bar);
        //处理返回按钮
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        UserDao dao = new UserDao(this);
        final String sql = "select * from user ";
        cursor = dao.select(sql, null);
        final SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.child_recommend_item_user,
                cursor, new String[]{"nick", "description","portrait","gender","resID"}, new int[]{R.id.child_item_user_nick, R.id.child_item_user_reason,R.id.child_item_user_sdv,R.id.child_item_user_gender,R.id.child_item_user_level}, SimpleCursorAdapter.FLAG_AUTO_REQUERY);
        mLv.setAdapter(mAdapter);
        mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                if (view.getId() == R.id.child_item_user_sdv){
                    String portrait = cursor.getString(cursor.getColumnIndex("portrait"));
                    ((SimpleDraweeView)view).setImageURI(FormatPathUtil.getXiaoImg(portrait));
                }
                if (view.getId() == R.id.child_item_user_nick){
                    String nick = cursor.getString(cursor.getColumnIndex("nick"));
                    ((TextView) view).setText(nick);
                }
                if (view.getId() == R.id.child_item_user_reason){
                    String description = cursor.getString(cursor.getColumnIndex("description"));
                    ((TextView) view).setText(description);
                }
                if (view.getId() == R.id.child_item_user_gender){
                    ImageView view1 = (ImageView) view;
                    int gender = cursor.getInt(cursor.getColumnIndex("gender"));
                    switch (gender){
                        case 0://表示女
                            view1.setImageResource(R.mipmap.global_icon_female);
                            break;
                        case 1://表示男
                            view1.setImageResource(R.mipmap.global_icon_male);
                            break;
                        default://默认女
                            view1.setImageResource(R.mipmap.global_icon_female);
                            break;
                    }
                }
                if (view.getId() == R.id.child_item_user_level){
                    ImageView view2 = (ImageView) view;
                    int resID = cursor.getInt(cursor.getColumnIndex("resID"));
                    view2.setImageResource(resID);
                }

                return true;
            }
        });
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                int uid = cursor.getInt(cursor.getColumnIndex("id"));
                UIManager.startActor(AttentionActivity.this, FormatPathUtil.getStartPath(uid));
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_attention;
    }
}
