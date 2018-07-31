package com.github.sergemart.mobile.beatbox.viewmodel;

import android.content.Context;

import com.github.sergemart.mobile.beatbox.model.AssetRepository;
import com.github.sergemart.mobile.beatbox.model.Sound;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;


public class SoundViewModelTest {

    private SoundViewModel mSubject;
    private Sound mSound;
    private AssetRepository mAssetRepository;


    // --------------------------- Set up

    @Before
    public void setUp() {
        // Prepare mocks
        mAssetRepository = mock(AssetRepository.class);

        mSound = mock(Sound.class);
        when(mSound.getName()).thenReturn("sound_name");

        // Prepare CuT
        mSubject = new SoundViewModel(mAssetRepository);                                            // use special constructor with the direct injection
        mSubject.setSound(mSound);
    }


    // --------------------------- Tests

    @Test
    public void exposes_Sound_Name_As_Title() {
        assertThat(mSubject.getItemTitle(), is( mSound.getName() ));
    }


    @Test
    public void calls_Repository_Play_On_Button_Clicked() {
        mSubject.onButtonClicked();
        verify(mAssetRepository).playSound(mSound);
    }
}