package com.nicestflower.xmax.ui.main.category;

import com.nicestflower.xmax.ui.base.MvpView;

import java.util.List;

public interface CategoryMvpView extends MvpView {

    void updateCategoryList(List<Category> categories);

    void openLessonActivity();

}
