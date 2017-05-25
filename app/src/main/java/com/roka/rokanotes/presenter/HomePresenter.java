package com.roka.rokanotes.presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.roka.rokanotes.R;
import com.roka.rokanotes.adapter.NotesAdapter;
import com.roka.rokanotes.adapter.listener.TouchListener;
import com.roka.rokanotes.common.Constants;
import com.roka.rokanotes.model.common.NotesModel;
import com.roka.rokanotes.presenter.ipresenter.IHomePresenter;
import com.roka.rokanotes.views.activity.BaseActivity;
import com.roka.rokanotes.views.iview.IHomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roka on 5/20/2017.
 */

public class HomePresenter extends BasePresenter implements IHomePresenter {
    private IHomeView iHomeView;
    private ActionMode mActionMode;
    private List<NotesModel> selectedList = new ArrayList<>();
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.multiselect, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.delete:
                    selectedList.clear();
                    actionMode.finish();
                    actionMode=null;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            selectedList.clear();
            actionMode.finish();
            mActionMode = null;
        }
    };
    private TouchListener<NotesModel> notesTouchListener = new TouchListener<NotesModel>() {
        @Override
        public void onClick(NotesModel data) {
            /*if (mActionMode != null) {
                toggleItem(data);
            }else{
                Bundle notesBundle=new Bundle();
                notesBundle.putParcelable(Constants.BundleKeys.NOTES_DATA,data);
                iHomeView.openNote(notesBundle);
            }*/
        }

        @Override
        public void onLongClick(NotesModel data) {
            if (mActionMode == null) {
                mActionMode = ((BaseActivity) iHomeView.getActivity()).startSupportActionMode(actionModeCallback);
            }
            toggleItem(data);
        }

        @Override
        public void animateNoteClick(int adapterPosition, NotesModel data, View itemView) {
            if (mActionMode != null) {
                toggleItem(data);
            }else{
                Bundle notesBundle=new Bundle();
                notesBundle.putParcelable(Constants.BundleKeys.NOTES_DATA,data);
                iHomeView.openNote(adapterPosition,data,itemView);
            }
        }
    };

    public HomePresenter(IHomeView iHomeView) {
        super(iHomeView);
        this.iHomeView = iHomeView;
    }

    private void toggleItem(NotesModel data) {
        data.setSelected(!data.isSelected());
        if (data.isSelected())
            selectedList.add(data);
        else
            selectedList.remove(data);
        if (selectedList.size() > 0)
            mActionMode.setTitle(selectedList.size() + " Items Selected");
        else {
            mActionMode.finish();
            mActionMode = null;
        }
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {
        generateDummyNotes();
    }

    private void generateDummyNotes() {
        ArrayList<NotesModel> notes = new ArrayList<>();
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        notes.add(new NotesModel("Title1", null, true, false, Color.BLUE));
        NotesAdapter notesAdapter = new NotesAdapter(notes);
        notesAdapter.setListener(notesTouchListener);
        iHomeView.setNotesAdapter(notesAdapter);
    }

    @Override
    public void dismissActionMode() {
        if (mActionMode != null) {
            selectedList.clear();
            mActionMode.finish();
            mActionMode = null;
        }
    }
}
