package com.roka.rokanotes.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.roka.rokanotes.R;
import com.roka.rokanotes.adapter.listener.TouchListener;
import com.roka.rokanotes.adapter.viewholder.NotesViewHolder;
import com.roka.rokanotes.model.common.NotesModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by Roka on 5/20/2017.
 */

public class NotesAdapter extends BaseAdapter<NotesModel, NotesViewHolder> {
    private TouchListener<NotesModel> listener;

    public NotesAdapter(List<NotesModel> data) {
        super(data);
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_notes, parent, false),listener);
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void setListener(TouchListener<NotesModel> listener) {
        this.listener = listener;
    }

    /*@Override
    public int getItemViewType(int position) {
        *//*if (data.get(position).isChecked())
            return R.layout.adapter_item_checkbox;
        else
            return R.layout.adapter_item_text;*//*
        return
    }*/
}
