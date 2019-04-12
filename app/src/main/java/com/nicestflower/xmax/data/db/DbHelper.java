package com.nicestflower.xmax.data.db;

import com.nicestflower.xmax.ui.lesson.Lesson;
import com.nicestflower.xmax.ui.main.category.Category;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    // todo: this is just for demo, please remove or replace probably
    Observable<List<Category>> getCategoryList();

    // todo: this is just for demo, please remove or replace probably
    Observable<List<Lesson>> getLessonList();
}
