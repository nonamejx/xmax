package com.nicestflower.xmax.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseActivity;
import com.nicestflower.xmax.ui.category.CategoryFragment;
import com.nicestflower.xmax.ui.favorite.FavoriteFragment;
import com.nicestflower.xmax.ui.file.FileFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        setUpBottomNavigationView();
        mPresenter.onCategoryMenuClick();
    }

    private void setUpBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.navigation_category:
                        mPresenter.onCategoryMenuClick();
                        break;
                    case R.id.navigation_favorite:
                        mPresenter.onFavoriteMenuClick();
                        break;
                    case R.id.navigation_file:
                        mPresenter.onFileMenuClick();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void showCategoryFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.container, CategoryFragment.newInstance(), CategoryFragment.TAG)
                .commit();
    }

    @Override
    public void showFavoriteFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.container, FavoriteFragment.newInstance(), FavoriteFragment.TAG)
                .commit();
    }

    @Override
    public void showFileFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.container, FileFragment.newInstance(), FileFragment.TAG)
                .commit();
    }
}
