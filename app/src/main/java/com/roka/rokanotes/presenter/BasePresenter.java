package com.roka.rokanotes.presenter;

import android.os.Bundle;

import com.roka.rokanotes.presenter.ipresenter.IPresenter;
import com.roka.rokanotes.views.iview.IBaseView;

/**
 * Created by Roka on 5/20/2017.
 */

public class BasePresenter implements IPresenter {
    protected String TAG = getClass().getSimpleName();
    private IBaseView iBaseView;

    public BasePresenter(IBaseView iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
