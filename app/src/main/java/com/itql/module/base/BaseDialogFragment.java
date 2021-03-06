package com.itql.module.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public abstract class BaseDialogFragment extends DialogFragment {
    protected static final String TAG = BaseFragment.class.getSimpleName();
    protected View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getViewLayout(), container, false);
        }
        ViewGroup viewGroup = (ViewGroup) mView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(mView);
        }
        beforeReturnView();
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBundle();
        initView();
        initData();
    }

    protected abstract int getViewLayout();

    protected void beforeReturnView() {}

    protected void initBundle() {}

    protected void initView() {}

    protected void initData() {}

    protected boolean interceptBackPress() {
        return false;
    }
}

