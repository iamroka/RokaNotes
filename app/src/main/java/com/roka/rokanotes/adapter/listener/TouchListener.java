package com.roka.rokanotes.adapter.listener;

import android.view.View;

import com.roka.rokanotes.model.common.NotesModel;

/**
 * Created by Roka on 5/22/2017.
 */

public interface TouchListener<T> {
    void onClick(T data);

    void onLongClick(T data);

    void animateNoteClick(int adapterPosition, T data, View itemView);
}
