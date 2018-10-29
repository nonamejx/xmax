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

public class RecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Book> mData;

    public RecyclerViewAdapter(List<Book> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.item_cardview_book, parent, false);
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

    public void addItems(final List<Book> books) {
        mData.addAll(books);
        notifyDataSetChanged();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.book_title_id)
        TextView tv_book_title;

        @BindView(R.id.book_img_id)
        ImageView img_book_thumbnail;

        @BindView(R.id.cardView)
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
            final Book book = mData.get(position);
            if (book.getTitle() != null) {
                tv_book_title.setText(book.getTitle());
            }
            if (book.getThumbnail() != 0) {
                img_book_thumbnail.setImageResource(book.getThumbnail());
            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }


}
