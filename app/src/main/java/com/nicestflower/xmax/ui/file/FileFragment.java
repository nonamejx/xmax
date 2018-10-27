package com.nicestflower.xmax.ui.file;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nicestflower.xmax.R;
import com.nicestflower.xmax.di.component.ActivityComponent;
import com.nicestflower.xmax.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class FileFragment extends BaseFragment implements FileMvpView {

    public static final String TAG = "FileFragment";

    @Inject
    FileMvpPresenter<FileMvpView> mPresenter;

    public static FileFragment newInstance() {
        Bundle args = new Bundle();
        FileFragment fragment = new FileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file, container, false);

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
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
