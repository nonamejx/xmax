package com.nicestflower.xmax.ui.main;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCategoryMenuClick() {
        getMvpView().showCategoryFragment();

        // todo: please remove this, we just show the token for debug
        getMvpView().showMessage(getDataManager().getAuthenticationToken());
    }

    @Override
    public void onFavoriteMenuClick() {
        getMvpView().showFavoriteFragment();
    }

    @Override
    public void onFileMenuClick() {
        getMvpView().showFileFragment();
    }
}
