package com.nicestflower.xmax.ui.lesson;

import com.nicestflower.xmax.ui.base.MvpPresenter;
import com.nicestflower.xmax.ui.lesson.model.Lesson;

public interface LessonMvpPresenter<V extends LessonMvpView> extends MvpPresenter<V> {

    void initData();

    void onLessonClick(LessonRowView lessonRowView, int position, Lesson lesson);

}
