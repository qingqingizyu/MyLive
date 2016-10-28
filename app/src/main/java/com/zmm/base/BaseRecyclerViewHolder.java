package com.zmm.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * BaseRecyclerViewHolder 提供一个通用的绑定控件的方法
 */

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> arrayView;
    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
        arrayView = new SparseArray<>();
    }

    /**
     * 通过填写的itemId来获取具体的View的对象
     * @param itemId  R.id.***
     * @param <T> 必须是View的子类
     * @return
     */
    public <T extends View> T getView(int itemId){
        //arrayVie类似于Map容器，get(key)取出的是value值
        View mView = arrayView.get(itemId);
        if(mView == null){
            //实例化具体的View类型
            mView = itemView.findViewById(itemId);
            arrayView.put(itemId,mView);
        }
        return (T) mView;
    }
}
