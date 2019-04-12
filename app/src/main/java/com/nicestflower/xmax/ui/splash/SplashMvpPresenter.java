package com.nicestflower.xmax.ui.splash;

import com.nicestflower.xmax.di.PerActivity;
import com.nicestflower.xmax.ui.base.MvpPresenter;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}
