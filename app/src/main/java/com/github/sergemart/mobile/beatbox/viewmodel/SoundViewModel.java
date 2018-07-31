package com.github.sergemart.mobile.beatbox.viewmodel;

import com.github.sergemart.mobile.beatbox.model.Sound;


public class SoundViewModel {

    private Sound mSound;


    // --------------------------- Getters/ setters

    public Sound getSound() {
        return mSound;
    }


    public void setSound(Sound sound) {
        mSound = sound;
    }


    // --------------------------- Binding methods

    public String getItemTitle() {
        return mSound.getName();
    }
}
