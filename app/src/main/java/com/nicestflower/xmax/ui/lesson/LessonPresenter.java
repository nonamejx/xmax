package com.nicestflower.xmax.ui.lesson;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class LessonPresenter<V extends LessonMvpView> extends BasePresenter<V> implements LessonMvpPresenter<V> {

    @Inject
    public LessonPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void initData() {
        getCompositeDisposable().add(getDataManager()
                .getLessonList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<Lesson>>() {
                    @Override
                    public void accept(List<Lesson> lessons) throws Exception {
                        if (lessons != null) {
                            getMvpView().updateLessons(lessons);
                        }
                    }
                })
        );
    }

    @Override
    public void onLessonClick(final LessonRowView lessonRowView, final int position, final Lesson lesson) {
        if (!lesson.getDownloaded()) {
            getMvpView().downloadFiles(lessonRowView, position, lesson);
        } else {
            getMvpView().openLessonDetailActivity(lesson);
        }
    }
}
