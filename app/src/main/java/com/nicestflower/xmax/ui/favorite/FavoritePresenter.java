package com.nicestflower.xmax.ui.favorite;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class FavoritePresenter<V extends FavoriteMvpView> extends BasePresenter<V> implements FavoriteMvpPresenter<V> {

    @Inject
    public FavoritePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
