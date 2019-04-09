package com.itql.module.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itql.module.util.ViewUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class BaseFragment extends Fragment {
	protected static final String TAG = BaseFragment.class.getSimpleName();
	private View mView;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (mView == null) {
			mView = inflater.inflate(getViewLayout(), container, false);
		}
		ViewUtil.removeViewFromParent(mView);
		return mView;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initData();
		initView();
	}

	protected abstract int getViewLayout();

	protected void initData() {}

	protected void initView() {}

	protected boolean onBackPress(){
		return false;
	}
}
