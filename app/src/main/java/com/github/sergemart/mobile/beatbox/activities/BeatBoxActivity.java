package com.github.sergemart.mobile.beatbox.activities;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.sergemart.mobile.beatbox.BeatBoxFragment;
import com.github.sergemart.mobile.beatbox.R;


public class BeatBoxActivity extends GenericActivity {

    // --------------------------- Implement generic abstracts

    /**
     * Specifies an activity layout
     */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_one_pane;
    }


    /**
     *  Specifies a fragment to use in the parent activity
     */
    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
