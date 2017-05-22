package com.roka.rokanotes.views.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.roka.rokanotes.views.iview.IBaseView;

import butterknife.ButterKnife;

/**
 * Created by Roka on 5/19/2017.
 */

abstract public class BaseActivity extends AppCompatActivity implements IBaseView {
    protected String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        injectViews();
        bindViews();
        bindPresenter();
    }

    /**
     * Injecting the views to butterknife.
     */

    private void injectViews() {
        ButterKnife.bind(this);
    }

    abstract protected void bindViews();

    abstract protected void bindPresenter();

    @LayoutRes
    abstract protected int getLayoutId();

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void dismissProgressbar() {

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
