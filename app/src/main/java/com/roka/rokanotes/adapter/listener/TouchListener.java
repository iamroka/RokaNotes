package com.roka.rokanotes.adapter.listener;

/**
 * Created by Roka on 5/22/2017.
 */

public interface TouchListener<T> {
    void onClick(T data);

    void onLongClick(T data);
}
