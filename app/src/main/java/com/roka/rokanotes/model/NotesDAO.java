package com.roka.rokanotes.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Roka on 6/4/2017.
 */
@Dao
public interface NotesDAO {
    @Query("SELECT * FROM notes_entity")
    List<NotesEntity> getAll();

    @Query("SELECT * FROM notes_entity WHERE notesId IN (:notesId)")
    List<NotesEntity> loadAllByIds(int[] notesId);

  /*  @Query("SELECT * FROM notes_entity WHERE first_name LIKE :first AND "
            + "last_name LIKE :last LIMIT 1")
    NotesEntity findByName(String first, String last);*/

    @Insert
    void insertAll(NotesEntity... users);

    @Delete
    void delete(NotesEntity user);
}
