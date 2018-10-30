package com.nicestflower.xmax.data;

import android.content.Context;

import com.nicestflower.xmax.data.db.DbHelper;
import com.nicestflower.xmax.data.network.ApiHelper;
import com.nicestflower.xmax.data.prefs.PreferencesHelper;
import com.nicestflower.xmax.di.ApplicationContext;
import com.nicestflower.xmax.ui.lesson.Lesson;
import com.nicestflower.xmax.ui.main.category.Book;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

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
    public Observable<List<Book>> getCategoryList() {
        return mDbHelper.getCategoryList();
    }

    @Override
    public Observable<List<Lesson>> getLessonList() {
        return mDbHelper.getLessonList();
    }
}
