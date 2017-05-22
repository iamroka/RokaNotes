package com.roka.rokanotes.views.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.rokanotes.views.activity.BaseActivity;
import com.roka.rokanotes.views.iview.IBaseView;

import butterknife.ButterKnife;

/**
 * Created by Roka on 5/19/2017.
 */

abstract public class BaseFragment extends Fragment implements IBaseView {
    protected String TAG = getClass().getSimpleName();
    private View vParentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }


    private void injectViews(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        injectViews(view);
        bindViews();
        bindPresenter();
    }

    protected abstract void bindViews();

    protected abstract void bindPresenter();

    @LayoutRes
    protected abstract int getLayoutId();

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void dismissProgressbar() {

    }
}
