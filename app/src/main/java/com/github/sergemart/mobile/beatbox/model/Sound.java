package com.github.sergemart.mobile.beatbox.model;

public class Sound {

    private String mAssetPath;                                                                      // full file name
    private String mName;                                                                           // sound name got from the file name
    private Integer mSoundId;                                                                       // ID for the SoundPool


    Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] assetPathParts = mAssetPath.split("/");
        String fileName = assetPathParts[assetPathParts.length - 1];
        mName = fileName.replace(".wav", "");
    }


    // --------------------------- Getters/ setters

    public String getAssetPath() {
        return mAssetPath;
    }


    public String getName() {
        return mName;
    }


    public int getSoundId() {
        return mSoundId;
    }


    public void setSoundId(int soundId) {
        mSoundId = soundId;
    }


}
