package com.nicestflower.xmax.ui.lesson;

import com.nicestflower.xmax.ui.base.MvpView;

import java.util.List;

public interface LessonMvpView extends MvpView {

    void updateLessons(List<Lesson> lessons);

    void updateDownloadStatusAt(int position);

    void downloadFiles(final LessonRowView lessonRowView, final int position, final Lesson lesson);

}
