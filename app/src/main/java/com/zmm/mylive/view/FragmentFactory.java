package com.zmm.mylive.view;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.zmm.activity.popup.devote.DataFragment;
import com.zmm.activity.popup.devote.TotalFragment;
import com.zmm.mylive.view.hot.HotFragment;
import com.zmm.mylive.view.nearby.NearbyFragment;
import com.zmm.mylive.view.recommend.RecommendFragment;


/**
 * 生产fragment的工厂
 */
public class FragmentFactory {
    private static final int FRAGMENT_RECOMMEND = 0;
    private static final int FRAGMENT_HOT= 1;
    private static final int FRAGMENT_NEARBY = 2;
    private static SparseArray<Fragment> fragments = new SparseArray<>();
    //映票贡献榜
    private static final int FRAGMENT_DEVOTE_ONE = 0;
    private static final int FRAGMENT_DEVOTE_TWO= 1;
    private static SparseArray<Fragment> devoteFragments = new SparseArray<>();

    //创建一个工厂方法,用来创建一个Fragment对象
    public static Fragment cerateFragment(int index){
        Fragment fragment = fragments.get(index);
        if (fragment == null){
            switch (index) {
                case FRAGMENT_RECOMMEND:
                    fragment = new RecommendFragment();
                    break;
                case FRAGMENT_HOT:
                    fragment = new HotFragment();
                    break;
                case FRAGMENT_NEARBY:
                    fragment = new NearbyFragment();
                    break;
            }
        }
        return fragment;
    }
    //贡献榜的创建工厂方法
    public static Fragment cerateDevoteFragment(int index){
        Fragment fragment = fragments.get(index);
        if (fragment == null){
            switch (index) {
                case FRAGMENT_DEVOTE_ONE:
                    fragment = new DataFragment();
                    break;
                case FRAGMENT_DEVOTE_TWO:
                    fragment = new TotalFragment();
                    break;
            }
        }
        return fragment;
    }
}
