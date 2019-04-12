package com.nicestflower.xmax.ui.lesson;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseViewHolder;
import com.nicestflower.xmax.ui.lesson.model.Lesson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> {

    private List<Lesson> lessonList;
    private LessonMvpPresenter<LessonMvpView> presenter;

    public LessonAdapter(List<Lesson> lessonList, LessonMvpPresenter<LessonMvpView> presenter) {
        this.lessonList = lessonList;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(presenter, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_view_lesson, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public void addItems(final List<Lesson> lessons) {
        lessonList.addAll(lessons);
        notifyDataSetChanged();
    }

    public void updateDownloadStatusAt(int position) {
        lessonList.get(position).setDownloaded(true);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder implements LessonRowView {

        @BindView(R.id.txtTitle)
        TextView txtTitle;

        @BindView(R.id.txtSize)
        TextView txtSize;

        @BindView(R.id.btnCloudDownload)
        ImageButton btnCloudDownload;

        public ViewHolder(final LessonMvpPresenter<LessonMvpView> presenter, View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.onLessonClick(ViewHolder.this, getAdapterPosition(), lessonList.get(getAdapterPosition()));
                }
            });
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            final Lesson lesson = lessonList.get(position);
            setTitle(lesson.getTitle());
            setSize(lesson.getSize());
            setDownloadButtonBackground(lesson.getDownloaded() ? R.drawable.ic_download_done : R.drawable.ic_download);

        }

        @Override
        protected void clear() {
            txtSize.setText("");
            txtTitle.setText("");
            btnCloudDownload.setImageResource(R.drawable.ic_download);
        }

        @Override
        public void setTitle(String title) {
            if (title != null) {
                txtTitle.setText(title);
            }
        }

        @Override
        public void setSize(String size) {
            if (size != null) {
                txtSize.setText(size);
            }
        }

        @Override
        public void setDownloadButtonBackground(int resId) {
            if (resId > 0) {
                btnCloudDownload.setImageResource(resId);
            }
        }
    }

}
