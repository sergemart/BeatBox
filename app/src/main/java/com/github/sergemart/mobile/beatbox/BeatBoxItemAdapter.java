package com.github.sergemart.mobile.beatbox;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.sergemart.mobile.beatbox.databinding.ListItemSoundBinding;


class BeatBoxItemAdapter extends RecyclerView.Adapter<BeatBoxItemHolder> {

    private Activity mActivity;


    BeatBoxItemAdapter(Activity activity) {
        mActivity = activity;
    }


    // --------------------------- Overrides

    @NonNull
    @Override
    public BeatBoxItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        ListItemSoundBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, parent, false);
        return new BeatBoxItemHolder(binding);
    }


    // Should be lightweight to smooth scrolling
    @Override
    public void onBindViewHolder(@NonNull BeatBoxItemHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return 0;
    }
}