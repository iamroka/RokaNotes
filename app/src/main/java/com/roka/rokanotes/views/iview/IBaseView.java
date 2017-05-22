package com.roka.rokanotes.views.iview;

import android.app.Activity;

/**
 * Created by Roka on 5/19/2017.
 */

public interface IBaseView {
    void showMessage(String message);

    void showMessage(int resId);

    void showProgressbar();

    void dismissProgressbar();

    Activity getActivity();
}
