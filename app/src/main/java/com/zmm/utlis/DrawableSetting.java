package com.zmm.utlis;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;

import com.zmm.mylive.R;

/**
 * Package_Name: com.zmm.utlis
 * Description :
 * author: HellPermanent
 * date:  2016/10/11 19:27
 * remarks：
 */
public class DrawableSetting {
    private Context mContext;
    private CheckBox mLikeButton;
    private  CheckBox mHiteButton;
    private  int x;
    private  int y;
    private  CheckBox mChatButton;
    public  DrawableSetting(Context context, CheckBox likeButton , CheckBox hiteButton,CheckBox chatButton, int x, int y){
        mContext = context;
        mHiteButton =hiteButton;
        mLikeButton = likeButton;
        mChatButton = chatButton;
        this.x =x;
        this.y = y;
        setting();
    }
    private void  setting(){
        Drawable likeDrawable = mContext.getResources().getDrawable(R.drawable.actor_like);
        likeDrawable.setBounds(0,0,x,y);
       mLikeButton.setCompoundDrawables(likeDrawable,null,null,null);
        Drawable hiteDrawable = mContext.getResources().getDrawable(R.drawable.actorhite);
     hiteDrawable.setBounds(0,0,x,y);
        mHiteButton.setCompoundDrawables(hiteDrawable,null,null,null);
        Drawable chat = mContext.getResources().getDrawable(R.drawable.actor_messges);
            chat.setBounds(0,0,x,y);
        mChatButton.setCompoundDrawables(chat,null,null,null);

    }
}
