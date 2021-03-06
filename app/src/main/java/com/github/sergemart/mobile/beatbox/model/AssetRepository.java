package com.github.sergemart.mobile.beatbox.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
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
    private static final int MAX_SOUNDS = 5;
    public static final int INITIAL_PLAYBACK_SPEED = 100;

    private static AssetRepository sAssetRepository;

    private AssetManager mAssetManager;
    private List<Sound> mSounds;
    private SoundPool mSoundPool;
    private int mPlaybackSpeed = 100;


    /**
     * Private constructor
     */
    private AssetRepository(Context context) {
        mAssetManager = context.getAssets();
        mSounds = new ArrayList<>();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);              // deprecated, but needed for compatibility
        this.loadSounds();
    }


    /**
     * Factory method
     */
    public static AssetRepository get(Context context) {
        if (sAssetRepository == null) {
            sAssetRepository = new AssetRepository(context);
        }
        return sAssetRepository;
    }


    // --------------------------- Getters/ setters

    public void setPlaybackSpeed(int playbackSpeed) {
        mPlaybackSpeed = playbackSpeed;
    }


    // --------------------------- Sound CRUD

    public List<Sound> getSounds() {
        return mSounds;
    }


    @SuppressWarnings("ConstantConditions")
    public void playSound(Sound sound) {
        Integer soundId = sound.getSoundId();
        if (soundId == null) return;
        float rate = mPlaybackSpeed/100.0f;                                                         // to avoid integer division and a double result
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, rate);
    }


    // --------------------------- Media controls

    /**
     * Load a list of Sounds into the member variable and the media files into the SoundPool
     */
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
            try {
                AssetFileDescriptor assetFileDescriptor = mAssetManager.openFd(sound.getAssetPath());
                Integer soundId = mSoundPool.load(assetFileDescriptor, 1);
                sound.setSoundId(soundId);                                                          // enrich the Sound with its media ID
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + fileName, ioe);
            }
        }
    }

}
