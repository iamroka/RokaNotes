package com.roka.rokanotes.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.roka.rokanotes.common.RokaNotes;
import com.roka.rokanotes.model.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Roka on 6/4/2017.
 */
@Module
public class AppModule {
    private RokaNotes mRokaNotes;

    public AppModule(RokaNotes mRokaNotes) {
        this.mRokaNotes = mRokaNotes;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mRokaNotes;
    }

    @Provides
    @Singleton
    AppDatabase providesDatabase(Context context){
        return Room.databaseBuilder(context,
                AppDatabase.class, "roka-notes_v1").build();
    }
}
