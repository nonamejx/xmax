package com.nicestflower.xmax.ui.lesson.detail;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LessonDetailPresenter<V extends LessonDetailMvpView> extends BasePresenter<V> implements LessonDetailMvpPresenter<V> {

    @Inject
    public LessonDetailPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
