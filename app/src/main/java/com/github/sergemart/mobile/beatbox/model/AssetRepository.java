package com.github.sergemart.mobile.beatbox.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Singleton Asset repository
 */
public class AssetRepository {

    private static final String TAG = "AssetRepository";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private static AssetRepository sAssetRepository;

    private AssetManager mAssetManager;
    private List<Sound> mSounds;


    /**
     * Private constructor
     */
    private AssetRepository(Context context) {
        mAssetManager = context.getAssets();
        mSounds = new ArrayList<>();
        this.loadSounds();
    }


    /**
     * Factory method
     */
    public static AssetRepository get(Context context) {
        if(sAssetRepository == null) {
            sAssetRepository = new AssetRepository(context);
        }
        return sAssetRepository;
    }


    // --------------------------- Sound CRUD

    public List<Sound> getSounds() {
        return mSounds;
    }


    // --------------------------- Local subroutines

    private void loadSounds() {
        String[] fileNames;
        try {
            fileNames = mAssetManager.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + fileNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }

        for (String fileName : fileNames) {
            String assetPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }

}
