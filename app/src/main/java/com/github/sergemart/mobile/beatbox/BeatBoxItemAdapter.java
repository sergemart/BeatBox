package com.github.sergemart.mobile.beatbox;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.sergemart.mobile.beatbox.databinding.ListItemSoundBinding;
import com.github.sergemart.mobile.beatbox.model.AssetRepository;
import com.github.sergemart.mobile.beatbox.model.Sound;


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
        ListItemSoundBinding listItemSoundBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, parent, false);
        return new BeatBoxItemHolder(listItemSoundBinding, mActivity);
    }


    // Should be lightweight to smooth scrolling
    @Override
    public void onBindViewHolder(@NonNull BeatBoxItemHolder holder, int position) {
        Sound sound = AssetRepository.get(mActivity).getSounds().get(position);
        holder.bind(sound);
    }


    @Override
    public int getItemCount() {
        return AssetRepository.get(mActivity).getSounds().size();
    }
}