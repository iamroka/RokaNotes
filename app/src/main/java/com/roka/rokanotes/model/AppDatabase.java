package com.roka.rokanotes.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Roka on 6/4/2017.
 */

@Database(entities = {NotesEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NotesDAO notesDAO();
}