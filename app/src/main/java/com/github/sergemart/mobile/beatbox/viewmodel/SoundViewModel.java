package com.github.sergemart.mobile.beatbox.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.github.sergemart.mobile.beatbox.model.Sound;


public class SoundViewModel extends BaseObservable {

    private Sound mSound;


    // --------------------------- Getters/ setters

    public Sound getSound() {
        return mSound;
    }


    public void setSound(Sound sound) {
        mSound = sound;
        this.notifyChange();
    }


    // --------------------------- Bindable methods to use in layouts

    @Bindable
    public String getItemTitle() {
        return mSound.getName();
    }
}
