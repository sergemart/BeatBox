package com.github.sergemart.mobile.beatbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.github.sergemart.mobile.beatbox.databinding.ListItemSoundBinding;
import com.github.sergemart.mobile.beatbox.model.Sound;
import com.github.sergemart.mobile.beatbox.viewmodel.SoundViewModel;


class BeatBoxItemHolder extends RecyclerView.ViewHolder {

    private ListItemSoundBinding mBinding;
    private Context mContext;


    BeatBoxItemHolder(ListItemSoundBinding listItemSoundBinding, Context context) {
        super( listItemSoundBinding.getRoot() );

        mContext = context;
        mBinding = listItemSoundBinding;
        mBinding.setSoundViewModel( new SoundViewModel(mContext) );
    }


    // --------------------------- Public methods

    public void bind(Sound sound) {
        mBinding.getSoundViewModel().setSound(sound);
        mBinding.executePendingBindings();                                                          // to update the view faster than normal
    }
}