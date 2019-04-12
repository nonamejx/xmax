package com.nicestflower.xmax.ui.main.category;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private Callback callback;
    private List<Category> mData;

    public RecyclerViewAdapter(List<Category> mData) {
        this.mData = mData;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.item_cardview_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItems(final List<Category> categories) {
        mData.addAll(categories);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onCategoryClick(Category category);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.category_title)
        TextView tvCategoryTitle;

        @BindView(R.id.category_description)
        TextView tvCategoryDescription;

        @BindView(R.id.img_category_thumbnail)
        ImageView imgCategoryThumbnail;

        @BindView(R.id.card_category_item)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
        }

        @Override
        public void onBind(int position) {
            final Category category = mData.get(position);
            if (category.getTitle() != null) {
                tvCategoryTitle.setText(category.getTitle());
                tvCategoryDescription.setText(category.getTitle());
            }
            if (category.getThumbnail() != 0) {
                imgCategoryThumbnail.setImageResource(category.getThumbnail());
            }
        }

        @OnClick(R.id.card_category_item)
        void onCardViewClick() {
            if (callback != null) {
                callback.onCategoryClick(mData.get(this.getAdapterPosition()));
            }
        }
    }


}
