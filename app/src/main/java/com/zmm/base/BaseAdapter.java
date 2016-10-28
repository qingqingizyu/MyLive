package com.zmm.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * 通用适配器
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder>  {
    private List<T> mList;

    public void setData(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(setItemLayoutId(), parent, false);
        return new BaseRecyclerViewHolder(view);
    }

    //通过子类传递布局id
   public abstract int setItemLayoutId();

    /**
     * 绑定每一个itemView的具体数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        //抽象方法，让子类去具体的实现
        bindConvert(holder, position, mList != null ? mList.get(position) : null);
    }
    //抽象方法，让子类去具体的实现
    public abstract void bindConvert(BaseRecyclerViewHolder holder, int position, T item);
}
