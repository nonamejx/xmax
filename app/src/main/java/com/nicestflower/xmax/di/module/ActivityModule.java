package com.nicestflower.xmax.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.nicestflower.xmax.di.ActivityContext;
import com.nicestflower.xmax.di.PerActivity;
import com.nicestflower.xmax.ui.main.category.Book;
import com.nicestflower.xmax.ui.main.category.CategoryMvpPresenter;
import com.nicestflower.xmax.ui.main.category.CategoryMvpView;
import com.nicestflower.xmax.ui.main.category.CategoryPresenter;
import com.nicestflower.xmax.ui.main.category.RecyclerViewAdapter;
import com.nicestflower.xmax.ui.main.favorite.FavoriteMvpPresenter;
import com.nicestflower.xmax.ui.main.favorite.FavoriteMvpView;
import com.nicestflower.xmax.ui.main.favorite.FavoritePresenter;
import com.nicestflower.xmax.ui.main.file.FileMvpPresenter;
import com.nicestflower.xmax.ui.main.file.FileMvpView;
import com.nicestflower.xmax.ui.main.file.FilePresenter;
import com.nicestflower.xmax.ui.main.MainMvpPresenter;
import com.nicestflower.xmax.ui.main.MainMvpView;
import com.nicestflower.xmax.ui.main.MainPresenter;
import com.nicestflower.xmax.ui.splash.SplashMvpPresenter;
import com.nicestflower.xmax.ui.splash.SplashMvpView;
import com.nicestflower.xmax.ui.splash.SplashPresenter;
import com.nicestflower.xmax.utils.rx.AppSchedulerProvider;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    CategoryMvpPresenter<CategoryMvpView> provideCategoryPresenter(CategoryPresenter<CategoryMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    RecyclerViewAdapter provideCategoryAdapter() {
        return new RecyclerViewAdapter(new ArrayList<Book>());
    }

    @Provides
    @PerActivity
    FavoriteMvpPresenter<FavoriteMvpView> provideFavoritePresenter(FavoritePresenter<FavoriteMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    FileMvpPresenter<FileMvpView> provideFilePresenter(FilePresenter<FileMvpView> presenter) {
        return presenter;
    }
}
