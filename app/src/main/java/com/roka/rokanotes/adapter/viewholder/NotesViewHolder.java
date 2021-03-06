package com.roka.rokanotes.adapter.viewholder;

import android.support.v4.view.ViewCompat;
import android.view.View;

import com.roka.rokanotes.adapter.listener.TouchListener;
import com.roka.rokanotes.model.common.NotesModel;

/**
 * Created by Roka on 5/20/2017.
 */

public class NotesViewHolder extends BaseViewHolder<NotesModel> {
    private TouchListener<NotesModel> listener;

    public NotesViewHolder(View itemView, TouchListener<NotesModel> listener) {
        super(itemView);
        this.listener = listener;
    }

    @Override
    public void populateData(final NotesModel data) {
        ViewCompat.setTransitionName(itemView, data.getNoteTitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //listener.onClick(data);
                listener.animateNoteClick(getAdapterPosition(),data,itemView);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onLongClick(data);
                return true;
            }
        });
    }
}
