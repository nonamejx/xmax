package com.nicestflower.xmax.ui.main.category;

import com.nicestflower.xmax.ui.base.MvpPresenter;

public interface CategoryMvpPresenter<V extends CategoryMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}
