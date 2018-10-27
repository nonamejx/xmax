package com.nicestflower.xmax.data;

import android.content.Context;

import com.nicestflower.xmax.data.db.DbHelper;
import com.nicestflower.xmax.data.network.ApiHelper;
import com.nicestflower.xmax.data.prefs.PreferencesHelper;
import com.nicestflower.xmax.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

}
