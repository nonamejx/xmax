package com.nicestflower.xmax.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.nicestflower.xmax.di.ApplicationContext;
import com.nicestflower.xmax.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}
