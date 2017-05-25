package com.roka.rokanotes.views.iview;

import android.os.Bundle;
import android.view.View;

import com.roka.rokanotes.adapter.NotesAdapter;
import com.roka.rokanotes.model.common.NotesModel;

/**
 * Created by Roka on 5/20/2017.
 */

public interface IHomeView extends IBaseView {
    void setNotesAdapter(NotesAdapter notesAdapter);

    //void openNote(Bundle notesData);

    void openNote(int adapterPosition, NotesModel data, View itemView);
}
