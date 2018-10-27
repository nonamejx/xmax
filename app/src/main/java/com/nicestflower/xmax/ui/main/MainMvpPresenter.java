package com.nicestflower.xmax.ui.main;

import com.nicestflower.xmax.ui.base.MvpPresenter;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void onCategoryMenuClick();

    void onFavoriteMenuClick();

    void onFileMenuClick();

}
