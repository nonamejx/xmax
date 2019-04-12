package com.nicestflower.xmax.ui.lesson;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liulishuo.okdownload.DownloadContext;
import com.liulishuo.okdownload.DownloadContextListener;
import com.liulishuo.okdownload.DownloadTask;
import com.liulishuo.okdownload.core.cause.EndCause;
import com.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.liulishuo.okdownload.core.listener.DownloadListener1;
import com.liulishuo.okdownload.core.listener.assist.Listener1Assist;
import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseActivity;
import com.nicestflower.xmax.ui.lesson.detail.LessonDetailActivity;
import com.nicestflower.xmax.ui.lesson.model.Lesson;
import com.nicestflower.xmax.ui.main.category.model.Category;
import com.nicestflower.xmax.ui.main.category.CategoryFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonActivity extends BaseActivity implements LessonMvpView {

    private static final String TAG = "LessonActivity";

    @Inject
    LessonMvpPresenter<LessonMvpView> mPresenter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.recyclerViewLesson)
    RecyclerView rvLessonList;

    private LessonAdapter lessonAdapter;
    private Category category;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        this.category = getIntent().getParcelableExtra(CategoryFragment.SELECTED_CATEGORY_KEY);

        setUp();
    }

    @Override
    protected void setUp() {
        // set title
        setTitle(this.category == null ?
                getResources().getString(R.string.app_name) : this.category.getTitle()
        );

        // setup adapter
        lessonAdapter = new LessonAdapter(new ArrayList<Lesson>(), mPresenter);

        // setup recycler view
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvLessonList.setLayoutManager(mLayoutManager);
        rvLessonList.setItemAnimator(new DefaultItemAnimator());
        rvLessonList.setAdapter(lessonAdapter);

        // init data for recycler view
        mPresenter.initData();

    }

    @Override
    public void updateLessons(List<Lesson> lessons) {
        lessonAdapter.addItems(lessons);
    }

    @Override
    public void updateDownloadStatusAt(int position) {
        lessonAdapter.updateDownloadStatusAt(position);
    }

    @Override
    public void downloadFiles(final LessonRowView lessonRowView, final int position, final Lesson lesson) {
        showLoading();
        final DownloadContext.Builder builder = new DownloadContext.QueueSet()
                .setParentPath(this.getExternalFilesDir("").getPath())
                .setMinIntervalMillisCallbackProcess(150)
                .commit();

        // bind URLs
        if (lesson.getFileLinks() != null) {
            for (final String url : lesson.getFileLinks()) {
                builder.bind(url);
            }
        }

        builder.setListener(new DownloadContextListener() {
            @Override
            public void taskEnd(@NonNull DownloadContext context, @NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, int remainCount) {
            }

            @Override
            public void queueEnd(@NonNull DownloadContext context) {
                // update icon
                lessonRowView.setDownloadButtonBackground(R.drawable.ic_download_done);

                // update state of item
                updateDownloadStatusAt(position);

                hideLoading();
            }
        });

        DownloadContext context = builder.build();
        context.startOnSerial(new DownloadListener1() {
            @Override
            public void taskStart(@NonNull DownloadTask task, @NonNull Listener1Assist.Listener1Model model) {
            }

            @Override
            public void retry(@NonNull DownloadTask task, @NonNull ResumeFailedCause cause) {
            }

            @Override
            public void connected(@NonNull DownloadTask task, int blockCount, long currentOffset, long totalLength) {
            }

            @Override
            public void progress(@NonNull DownloadTask task, long currentOffset, long totalLength) {
            }

            @Override
            public void taskEnd(@NonNull DownloadTask task, @NonNull EndCause cause, @Nullable Exception realCause, @NonNull Listener1Assist.Listener1Model model) {
            }
        });
    }

    @Override
    public void openLessonDetailActivity(Lesson lesson) {
        Intent intent = new Intent(this, LessonDetailActivity.class);
        startActivity(intent);
    }
}
