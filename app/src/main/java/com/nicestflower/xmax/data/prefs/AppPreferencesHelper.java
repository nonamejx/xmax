package com.nicestflower.xmax.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.nicestflower.xmax.di.ApplicationContext;
import com.nicestflower.xmax.di.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_AUTHENTICATION_TOKEN = "PREF_AUTHENTICATION_TOKEN";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAuthenticationToken() {
        return mPrefs.getString(PREF_AUTHENTICATION_TOKEN, null);
    }

    @Override
    public void setAuthenticationToken(final String authenticationToken) {
        mPrefs.edit().putString(PREF_AUTHENTICATION_TOKEN, authenticationToken).apply();
    }

}
