package com.roka.rokanotes.common;

import android.app.Application;

import com.roka.rokanotes.di.AppComponent;
import com.roka.rokanotes.di.AppModule;
import com.roka.rokanotes.di.DaggerAppComponent;

/**
 * Created by Roka on 5/19/2017.
 */

public class RokaNotes extends Application {
    protected String TAG = getClass().getSimpleName();
    private RokaNotes mApplication;
    private AppComponent mAppComponent;

    public RokaNotes getmApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initDagger();
    }

    private void initDagger() {
        mAppComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .build();
        mAppComponent.inject(this);
    }
}
