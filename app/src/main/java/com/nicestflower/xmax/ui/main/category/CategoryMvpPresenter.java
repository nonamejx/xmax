package com.nicestflower.xmax.ui.main.category;

import com.nicestflower.xmax.ui.base.MvpPresenter;
import com.nicestflower.xmax.ui.main.category.model.Category;

public interface CategoryMvpPresenter<V extends CategoryMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

    void onCategoryClick(Category category);

}
