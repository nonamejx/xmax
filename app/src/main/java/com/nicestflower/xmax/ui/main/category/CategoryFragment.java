package com.nicestflower.xmax.ui.main.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.di.component.ActivityComponent;
import com.nicestflower.xmax.ui.base.BaseFragment;
import com.nicestflower.xmax.ui.lesson.LessonActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends BaseFragment implements CategoryMvpView, RecyclerViewAdapter.Callback {

    public static final String TAG = "CategoryFragment";

    public static final String SELECTED_CATEGORY_KEY = "SELECTED_CATEGORY_KEY";

    @Inject
    CategoryMvpPresenter<CategoryMvpView> mPresenter;

    @Inject
    RecyclerViewAdapter rvCategoryAdapter;

    @BindView(R.id.rvCategory)
    RecyclerView rvCategory;

    public static CategoryFragment newInstance() {
        Bundle args = new Bundle();
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * An util method to calculate the number of columns for a grid base on the item width (dp).
     *
     * @param context       the app context
     * @param columnWidthDp the width of item(dp)
     * @return the number of columns
     */
    public static int calculateNoOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5); // +0.5 for correct rounding to int.
        return noOfColumns;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            rvCategoryAdapter.setCallback(this);
        }

        return view;
    }

    @Override
    protected void setUp(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // setup category recycler view
        rvCategory.setLayoutManager(new GridLayoutManager(getContext(), calculateNoOfColumns(getContext(), 180f)));
        rvCategory.setItemAnimator(new DefaultItemAnimator());
        rvCategory.setAdapter(rvCategoryAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void updateCategoryList(List<Category> categories) {
        rvCategoryAdapter.addItems(categories);
    }

    @Override
    public void openLessonActivity(Category category) {
        Intent intent = new Intent(getContext(), LessonActivity.class);
        intent.putExtra(SELECTED_CATEGORY_KEY, category);
        startActivity(intent);
    }

    @Override
    public void onCategoryClick(Category category) {
        mPresenter.onCategoryClick(category);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
