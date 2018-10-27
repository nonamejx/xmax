package com.nicestflower.xmax.ui.splash;

import android.os.Handler;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        getMvpView().showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().hideLoading();
                getMvpView().openMainActivity();
            }
        }, 1);

    }

}
