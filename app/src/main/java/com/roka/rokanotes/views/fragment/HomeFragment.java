package com.roka.rokanotes.views.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.transition.TransitionInflater;
import android.view.View;

import com.roka.rokanotes.R;
import com.roka.rokanotes.adapter.NotesAdapter;
import com.roka.rokanotes.common.Constants;
import com.roka.rokanotes.model.common.NotesModel;
import com.roka.rokanotes.presenter.HomePresenter;
import com.roka.rokanotes.presenter.ipresenter.IHomePresenter;
import com.roka.rokanotes.views.activity.EditNotesActivity;
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
/*
    @Override
    public void openNote(Bundle notesData) {
        Intent notesIntent= new Intent(getActivity(), EditNotesActivity.class);
        notesIntent.putExtra(Constants.BundleKeys.NOTES,notesData);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, (View)ivProfile, "profile");
        startActivity(notesIntent, options.toBundle());
    }*/

    @Override
    public void openNote(int adapterPosition, NotesModel data, View itemView) {
        /*Intent intent = new Intent(getActivity(), EditNotesActivity.class);
        intent.putExtra(Constants.BundleKeys.NOTES_DATA, data);
        intent.putExtra(Constants.BundleKeys.EXTRA_TITLE_TRANSITION_NAME, ViewCompat.getTransitionName(itemView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                getActivity(),
                itemView,
                ViewCompat.getTransitionName(itemView));

        startActivity(intent, options.toBundle());*/


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Inflate transitions to apply
            Transition changeTransform = TransitionInflater.from(getActivity()).
                    inflateTransition(R.transition.change_image_transform);
            Transition fadeTransform = TransitionInflater.from(getActivity()).
                    inflateTransition(android.R.transition.explode);

            // Setup exit transition on first fragment
            setSharedElementReturnTransition(changeTransform);
            setExitTransition(fadeTransform);

            // Setup enter transition on second fragment
            EditNotesFragment editNotesFragment = new EditNotesFragment();
            editNotesFragment.setSharedElementEnterTransition(changeTransform);
            editNotesFragment.setSharedElementReturnTransition(changeTransform);
            editNotesFragment.setEnterTransition(fadeTransform);
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.BundleKeys.NOTES_DATA, data);
            bundle.putString(Constants.BundleKeys.EXTRA_TITLE_TRANSITION_NAME, ViewCompat.getTransitionName(itemView));
            editNotesFragment.setArguments(bundle);
            // Find the shared element (in Fragment A)
            //ImageView ivProfile = (ImageView) findViewById(R.id.ivProfile);

            // Add second fragment by replacing first
            getFragmentManager().beginTransaction()
                    .addSharedElement(itemView, ViewCompat.getTransitionName(itemView))
                    .replace(R.id.drawer_layout, editNotesFragment)
                    .addToBackStack("transaction")
                    .commit();


        }

/*        EditNotesFragment editNotesFragment= new EditNotesFragment();
        Bundle bundle= new Bundle();
        bundle.putParcelable(Constants.BundleKeys.NOTES_DATA, data);
        bundle.putString(Constants.BundleKeys.EXTRA_TITLE_TRANSITION_NAME, ViewCompat.getTransitionName(itemView));
        editNotesFragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(itemView, ViewCompat.getTransitionName(itemView))
                .addToBackStack(TAG)
                .replace(R.id.frame, editNotesFragment)
                .commit();*/

    }
}
