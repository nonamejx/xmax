package com.nicestflower.xmax.data;

import android.content.Context;

import com.nicestflower.xmax.data.db.DbHelper;
import com.nicestflower.xmax.data.network.ApiHelper;
import com.nicestflower.xmax.data.network.model.AccountResponse;
import com.nicestflower.xmax.data.network.model.ApiHeader;
import com.nicestflower.xmax.data.network.model.AuthenticationResponse;
import com.nicestflower.xmax.data.network.model.LoginRequest;
import com.nicestflower.xmax.data.prefs.PreferencesHelper;
import com.nicestflower.xmax.di.ApplicationContext;
import com.nicestflower.xmax.ui.lesson.model.Lesson;
import com.nicestflower.xmax.ui.main.category.model.Category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

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

    @Override
    public Observable<List<Category>> getCategoryList() {
        return mDbHelper.getCategoryList();
    }

    @Override
    public Observable<List<Lesson>> getLessonList() {
        return mDbHelper.getLessonList();
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Single<AuthenticationResponse> authenticate(LoginRequest.AuthenticationRequest request) {
        return mApiHelper.authenticate(request);
    }

    @Override
    public Single<AccountResponse> getAccountInformation() {
        return mApiHelper.getAccountInformation();
    }

    @Override
    public String getAuthenticationToken() {
        return mPreferencesHelper.getAuthenticationToken();
    }

    @Override
    public void setAuthenticationToken(String authenticationToken) {
        mPreferencesHelper.setAuthenticationToken(authenticationToken);
    }
}
