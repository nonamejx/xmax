package com.nicestflower.xmax.ui.main.category;

import com.nicestflower.xmax.ui.base.MvpView;
import com.nicestflower.xmax.ui.main.category.model.Category;

import java.util.List;

public interface CategoryMvpView extends MvpView {

    void updateCategoryList(List<Category> categories);

    void openLessonActivity(Category category);

}
