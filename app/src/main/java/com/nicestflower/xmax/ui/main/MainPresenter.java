package com.nicestflower.xmax.ui.main;

import com.nicestflower.xmax.data.DataManager;
import com.nicestflower.xmax.data.network.model.CategoryResponse;
import com.nicestflower.xmax.ui.base.BasePresenter;
import com.nicestflower.xmax.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    MainPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCategoryMenuClick() {
        getMvpView().showCategoryFragment();

        // todo: please remove this, we just show the token for debug
        getMvpView().showMessage(getDataManager().getAuthenticationToken());

        // todo: please remove this, we just get all categories for debug
        getCompositeDisposable().add(
                getDataManager()
                        .getAllCategories()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<List<CategoryResponse>>() {
                            @Override
                            public void accept(List<CategoryResponse> categoryResponses) throws Exception {
                                Timber.d(categoryResponses.toString());
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Timber.e(throwable);
                            }
                        })
        );
    }

    @Override
    public void onFavoriteMenuClick() {
        getMvpView().showFavoriteFragment();
    }

    @Override
    public void onFileMenuClick() {
        getMvpView().showFileFragment();
    }
}
