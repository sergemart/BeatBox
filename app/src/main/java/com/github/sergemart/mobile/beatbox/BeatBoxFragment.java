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
import android.widget.SeekBar;

import com.github.sergemart.mobile.beatbox.databinding.FragmentBeatBoxBinding;
import com.github.sergemart.mobile.beatbox.model.AssetRepository;


public class BeatBoxFragment extends Fragment {

    FragmentBeatBoxBinding mFragmentBinding;


    // --------------------------- Override fragment event handlers

    /**
     * View-unrelated startup actions
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);                                                                    // retain the fragment between the hosting activity lives
        AssetRepository.get(this.getActivity()).setPlaybackSpeed(AssetRepository.INITIAL_PLAYBACK_SPEED); // init singleton if needed
    }


    /**
     * View-related startup actions
     * @return Inflated content view of the fragment
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container,false);

        this.setWidgetAttributes();
        this.setWidgetListeners();

        return mFragmentBinding.getRoot();
    }


    // --------------------------- Widget controls

    private void setWidgetAttributes() {
        mFragmentBinding.recyclerViewMainGrid.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        mFragmentBinding.recyclerViewMainGrid.setAdapter(new BeatBoxItemAdapter( this.getActivity() ));

        mFragmentBinding.seekBarPlaybackSpeed.setMax(AssetRepository.INITIAL_PLAYBACK_SPEED * 2);
        mFragmentBinding.seekBarPlaybackSpeed.setProgress(AssetRepository.INITIAL_PLAYBACK_SPEED);
        mFragmentBinding.labelSeekbarValue.setText(String.valueOf(AssetRepository.INITIAL_PLAYBACK_SPEED));
    }


    /**
     * Set listeners to widgets
     */
    private void setWidgetListeners() {

        // Set a listener to the "Speed Playback" seek bar
        // Make it change the sound playback speed
        mFragmentBinding.seekBarPlaybackSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mFragmentBinding.labelSeekbarValue.setText(String.valueOf(progress));
                AssetRepository.get(BeatBoxFragment.this.getActivity()).setPlaybackSpeed(progress);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Nothing to do here
            }


            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Nothing to do here
            }

        });


        // Set a listener to the "Speed Playback" label
        // Make it reset the sound playback speed
        mFragmentBinding.labelSeekbarPrefix.setOnClickListener((view) -> {
            mFragmentBinding.seekBarPlaybackSpeed.setProgress(AssetRepository.INITIAL_PLAYBACK_SPEED);
            mFragmentBinding.labelSeekbarValue.setText(String.valueOf(AssetRepository.INITIAL_PLAYBACK_SPEED));
            AssetRepository.get(BeatBoxFragment.this.getActivity()).setPlaybackSpeed(AssetRepository.INITIAL_PLAYBACK_SPEED);
        });
    }

    // --------------------------- Static encapsulation-leveraging methods

    /**
     * Create BeatBoxFragment provided with arguments containing the given crime UUID
     */
    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }



}
