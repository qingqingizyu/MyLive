package com.zmm.mylive.view.recommend;

import android.content.Context;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Package_Name: com.zmm.mylive.view.recommend
 * Description :
 * author: HellPermanent
 * date:  2016/10/11 11:58
 * remarks：
 */
public class ButtonSetting {
    private RadioGroup mRadioGroup;
    private RadioButton liveButton;
    private RadioButton meButton;
    private Context mContext;

    public ButtonSetting(Context context, RadioGroup radioGroup, RadioButton liveButton, RadioButton meButton){
        mRadioGroup = radioGroup;
        this.liveButton = liveButton;
        this.meButton = meButton;
        mContext = context;
        setting();
    }
    private void setting(){
//        Drawable iButton = mContext.getResources().getDrawable(R.drawable.mainlive);
//        iButton.setBounds(0,0,50,50);
//        liveButton.setCompoundDrawables(null,null,null,iButton);
//
//        Drawable mButton = mContext.getResources().getDrawable(R.drawable.mainme);
//        mButton.setBounds(0,0,50,50);
//        meButton.setCompoundDrawables(null,null,null,mButton);

    }
}
