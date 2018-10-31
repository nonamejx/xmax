package com.nicestflower.xmax.ui.lesson.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LessonDetailActivity extends BaseActivity implements LessonDetailMvpView {

    private static final String TAG = "LessonDetailActivity";

    @Inject
    LessonDetailPresenter<LessonDetailMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {

    }
}
