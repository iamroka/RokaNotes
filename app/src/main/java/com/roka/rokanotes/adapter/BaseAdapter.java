package com.roka.rokanotes.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.roka.rokanotes.adapter.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by Roka on 5/19/2017.
 */

abstract public class BaseAdapter<T, V extends BaseViewHolder> extends RecyclerView.Adapter<V> {
    protected String TAG = getClass().getSimpleName();
    protected List<T> data;

    public BaseAdapter(List<T> data) {
        this.data = data;
    }

    @Override
    public void onBindViewHolder(V holder, int position) {
        holder.setData(data.get(position));

    }


    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }
}
