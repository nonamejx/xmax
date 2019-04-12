package com.nicestflower.xmax.ui.splash;

import com.nicestflower.xmax.BuildConfig;
import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.data.network.model.AuthenticationResponse;
import com.nicestflower.xmax.data.network.model.LoginRequest;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();

        // todo: please check if the token's expired then request to authenticate
        getCompositeDisposable().add(
                getDataManager()
                        .authenticate(
                                new LoginRequest.AuthenticationRequest(
                                        BuildConfig.API_USERNAME, BuildConfig.API_PASSWORD, true)
                        )
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<AuthenticationResponse>() {
                            @Override
                            public void accept(AuthenticationResponse authenticationResponse) throws Exception {
                                // set authentication token
                                getDataManager().setAuthenticationToken(authenticationResponse.getIdToken());
                                getMvpView().hideLoading();
                                getMvpView().openMainActivity();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Timber.e(throwable);
                                getMvpView().hideLoading();
                                getMvpView().openMainActivity();
                            }
                        })
        );

    }
}
