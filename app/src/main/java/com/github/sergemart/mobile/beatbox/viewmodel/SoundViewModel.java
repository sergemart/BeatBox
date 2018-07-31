package com.github.sergemart.mobile.beatbox.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.github.sergemart.mobile.beatbox.model.AssetRepository;
import com.github.sergemart.mobile.beatbox.model.Sound;


public class SoundViewModel extends BaseObservable {

    private Sound mSound;
    private AssetRepository mAssetRepository;


    /**
     * General purpose constructor
     */
    public SoundViewModel(Context context) {
        mAssetRepository = AssetRepository.get(context);                                            // refactored injection to avoid using the static singleton getter; needed for mocking the class in unit tests
    }


    /**
     * Constructor only for unit testing. Using the direct singleton injection
     */
    SoundViewModel(AssetRepository assetRepository) {
        mAssetRepository = assetRepository;
    }


    // --------------------------- Getters/ setters

    public Sound getSound() {
        return mSound;
    }


    public void setSound(Sound sound) {
        mSound = sound;
        this.notifyChange();
    }


    // --------------------------- Bindable data methods to use in layouts

    @Bindable
    public String getItemTitle() {
        return mSound.getName();
    }


    // --------------------------- Event handlers to use in layouts

    public void onButtonClicked() {
        mAssetRepository.playSound(mSound);
    }
}
