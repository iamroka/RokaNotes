package com.roka.rokanotes.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Roka on 5/19/2017.
 */

abstract public class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    protected String TAG = getClass().getSimpleName();
    private T data;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    abstract public void populateData(T data);

    public void setData(T data) {
        this.data = data;
        populateData(data);
    }
}
