package com.roka.rokanotes.views.fragment;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.roka.rokanotes.R;
import com.roka.rokanotes.adapter.NotesAdapter;
import com.roka.rokanotes.presenter.HomePresenter;
import com.roka.rokanotes.presenter.ipresenter.IHomePresenter;
import com.roka.rokanotes.views.iview.IHomeView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements IHomeView {
    @BindView(R.id.rv_notes_home)
    RecyclerView vRvNotes;


    private IHomePresenter iHomePresenter;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    protected void bindViews() {
        vRvNotes.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        ItemTouchHelper.Callback callback= new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int dragFlags = ItemTouchHelper.START | ItemTouchHelper.END|ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                return makeMovementFlags( dragFlags,swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                ((NotesAdapter)recyclerView.getAdapter()).onItemMove(viewHolder.getAdapterPosition(),
                        target.getAdapterPosition());
                iHomePresenter.dismissActionMode();
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // TODO: 5/22/2017 add to archive function needed
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(vRvNotes);

    }

    @Override
    protected void bindPresenter() {
        iHomePresenter = new HomePresenter(this);
        iHomePresenter.onCreatePresenter(null);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @OnClick(R.id.fab_add_notes_main)
    void createNewNote(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void setNotesAdapter(NotesAdapter notesAdapter) {
        vRvNotes.setAdapter(notesAdapter);
    }
}
