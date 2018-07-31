package com.github.sergemart.mobile.beatbox.model;

public class Sound {

    private String mAssetPath;                                                                      // full file name
    private String mName;                                                                           // sound name got from the file name


    Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] assetPathParts = mAssetPath.split("/");
        String fileName = assetPathParts[assetPathParts.length - 1];
        mName = fileName.replace(".wav", "");
    }

    // --------------------------- Getters

    public String getAssetPath() {
        return mAssetPath;
    }


    public String getName() {
        return mName;
    }
}
