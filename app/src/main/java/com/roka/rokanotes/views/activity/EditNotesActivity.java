package com.roka.rokanotes.views.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.roka.rokanotes.R;
import com.roka.rokanotes.common.Constants;
import com.roka.rokanotes.model.common.NotesModel;
import com.roka.rokanotes.views.iview.IEditNotesView;

import butterknife.BindView;

public class EditNotesActivity extends BaseActivity implements IEditNotesView {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.et_title_edit_note)
    EditText vEtNoteTitle;
    @BindView(R.id.et_body_edit_note)
    EditText vEtNoteBody;

    @Override
    protected void bindViews() {
        setSupportActionBar(mToolbar);
        //supportPostponeEnterTransition();
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Bundle extras = getIntent().getExtras();
        NotesModel notesModel = extras.getParcelable(Constants.BundleKeys.NOTES_DATA);
        vEtNoteTitle.setText(notesModel.getNoteTitle());
        vEtNoteBody.setTransitionName(extras.getString(Constants.BundleKeys.EXTRA_TITLE_TRANSITION_NAME));
      /*  if (notesModel.getNotesMessage().size()==1)
        vEtNoteBody.setText(notesModel.getNotesMessage().get(0));*/
    }

    @Override
    protected void bindPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit_notes;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        supportFinishAfterTransition();
    }
}
