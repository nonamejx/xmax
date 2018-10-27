package com.nicestflower.xmax.ui.category;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CategoryPresenter<V extends CategoryMvpView> extends BasePresenter<V> implements CategoryMvpPresenter<V> {

    @Inject
    public CategoryPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
