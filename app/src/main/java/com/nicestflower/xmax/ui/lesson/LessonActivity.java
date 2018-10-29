package com.nicestflower.xmax.ui.lesson;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LessonActivity extends BaseActivity implements LessonMvpView {

    @Inject
    LessonMvpPresenter<LessonMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
    }
}
