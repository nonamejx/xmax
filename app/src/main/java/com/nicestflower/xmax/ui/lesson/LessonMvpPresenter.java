package com.nicestflower.xmax.ui.lesson;

import com.nicestflower.xmax.ui.base.MvpPresenter;

public interface LessonMvpPresenter<V extends LessonMvpView> extends MvpPresenter<V> {

    void initData();

    void onLessonClick(LessonRowView lessonRowView, int position, Lesson lesson);

}
