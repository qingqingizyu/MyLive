package com.zmm.activity.popup.devote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zmm.Constant;
import com.zmm.mylive.view.FragmentFactory;

/**
 * Created by Lenovo on 2016/10/14.
 */

class DevoteAdapter extends FragmentPagerAdapter {

    public DevoteAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Constant.DEVOTE_TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.cerateDevoteFragment(position);
    }

    @Override
    public int getCount() {
        return Constant.DEVOTE_TITLES.length;
    }
}
