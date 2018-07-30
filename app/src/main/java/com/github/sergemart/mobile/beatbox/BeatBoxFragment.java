package com.github.sergemart.mobile.beatbox;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.sergemart.mobile.beatbox.databinding.FragmentBeatBoxBinding;


public class BeatBoxFragment extends Fragment {

    FragmentBeatBoxBinding mFragmentBinding;


    // --------------------------- Override fragment event handlers

    /**
     * View-related startup actions
     * @return Inflated content view of the fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container,false);

        this.setWidgetAttributes();

        return mFragmentBinding.getRoot();
    }


    // --------------------------- Widget controls

    private void setWidgetAttributes() {
        mFragmentBinding.recyclerViewMainGrid.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
    }


    // --------------------------- Static encapsulation-leveraging methods

    /**
     * Create BeatBoxFragment provided with arguments containing the given crime UUID
     */
    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }


}
