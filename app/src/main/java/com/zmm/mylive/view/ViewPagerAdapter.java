package com.zmm.mylive.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zmm.Constant;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    //生成标题
    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.TITLES[position];
    }
    //生产Fragment
    @Override
    public Fragment getItem(int position) {
        return  FragmentFactory.cerateFragment(position);
    }
    //生成标题数量
    @Override
    public int getCount() {
        return Constant.TITLES.length;
    }
}
