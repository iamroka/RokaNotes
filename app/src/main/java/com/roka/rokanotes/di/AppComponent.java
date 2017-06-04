package com.roka.rokanotes.di;

import com.roka.rokanotes.common.RokaNotes;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Roka on 6/4/2017.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(RokaNotes rokaNotes );
}
