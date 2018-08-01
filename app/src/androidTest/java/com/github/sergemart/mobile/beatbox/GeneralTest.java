package com.github.sergemart.mobile.beatbox;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(AndroidJUnit4.class)
public class GeneralTest {

    @Test
    public void context_Is_Up() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertThat(appContext.getPackageName(), is("com.github.sergemart.mobile.beatbox"));
    }
}
