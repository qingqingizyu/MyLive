package com.zmm.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zmm.mylive.R;
import com.zmm.mylive.presenter.LivePresenter;
import com.zmm.utlis.UIManager;

import java.util.List;

/**
 * BaseFragment 需要子类实现为实现的方法
 */
public abstract class BaseFragment extends Fragment implements LiveView<Object>, SwipeRefreshLayout.OnRefreshListener {
    private SwipeRefreshLayout mSwipeRefreshWidget;
    private BaseAdapter mAdapter;
    private LivePresenter livePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);//初始化
        //livePresenter负责完成View与Model间的逻辑和交互
        livePresenter = new LivePresenter(this);
        //首次打开加载数据
//        onRefresh();
    }

    private void initView(View view) {
        //下拉刷新
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light, android.R.color.holo_orange_light);
        mSwipeRefreshWidget.setOnRefreshListener(this);//设置下拉刷新监听
        //recycleView
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        //布局管理器 需要子类实现getSpanCount()抽象方法 提供列数
        GridLayoutManager manager = new GridLayoutManager(getActivity(), getSpanCount());
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        //添加适配器 因为每个子类显示的内容有差异所有适配器需要子类实现getAdapter() 这个方法
        mAdapter = getAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        //得到焦点的时候加载数据
        onRefresh();
    }

    //设置列数
    public abstract int getSpanCount();

    //添加适配器
    public abstract BaseAdapter getAdapter();
    //加载网络数据
    @Override
    public void onRefresh() {
        //加载网络数据
        livePresenter.loadData();
    }
    //显示进度
    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);
    }
    //取消进度
    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
    }
    //数据加载成功
    @Override
    public void addLives(List<Object> list) {
        if (list != null) {
            mAdapter.setData(list);
        }
    }
    //加载失败
    @Override
    public void showLoadFailMsg() {
        UIManager.showSnackbar(getActivity(),"网络异常！");
    }
}
