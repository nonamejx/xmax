package com.nicestflower.xmax.ui.main.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.di.component.ActivityComponent;
import com.nicestflower.xmax.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends BaseFragment implements CategoryMvpView {

    public static final String TAG = "CategoryFragment";

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
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
        rvCategory.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvCategory.setItemAnimator(new DefaultItemAnimator());
        rvCategory.setAdapter(rvCategoryAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void updateCategoryList(List<Book> books) {
        rvCategoryAdapter.addItems(books);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
