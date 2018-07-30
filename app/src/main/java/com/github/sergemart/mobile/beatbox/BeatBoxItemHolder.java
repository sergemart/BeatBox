package com.github.sergemart.mobile.beatbox;

import android.support.v7.widget.RecyclerView;

import com.github.sergemart.mobile.beatbox.databinding.ListItemSoundBinding;


class BeatBoxItemHolder extends RecyclerView.ViewHolder {

    private ListItemSoundBinding mBinding;


    BeatBoxItemHolder(ListItemSoundBinding binding) {
        super( binding.getRoot() );
        mBinding = binding;
    }

}