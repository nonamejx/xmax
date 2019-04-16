package com.nicestflower.xmax.data.db;

import com.nicestflower.xmax.data.network.model.CategoryResponse;
import com.nicestflower.xmax.ui.lesson.model.Lesson;
import com.nicestflower.xmax.ui.main.category.model.Category;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    // todo: this is just for demo, please remove or replace probably
    Observable<List<Category>> getCategoryList();

    // todo: this is just for demo, please remove or replace probably
    Observable<List<Lesson>> getLessonList();

    /**
     * Save a list of categories to Db.
     *
     * @param categories the categories list
     * @return the observable of a Boolean
     */
    Observable<Boolean> saveCategoryList(List<CategoryResponse> categories);

    /**
     * Get all categories from Db.
     *
     * @return the observable of a list of categories
     */
    Observable<List<CategoryResponse>> getAllCategoriesFromDb();
}
