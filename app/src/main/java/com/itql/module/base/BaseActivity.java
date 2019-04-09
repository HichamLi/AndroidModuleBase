package com.itql.module.base;

import android.os.Bundle;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public abstract class BaseActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initBeforeSetContentView();
		setContentView(getViewLayout());
		initData();
		initView();
	}

	protected void initBeforeSetContentView() {}

	protected abstract int getViewLayout();

	protected void initData() {}

	protected void initView() {}

	protected boolean banOnBackPress() {return false;}

	@Override
	public void onBackPressed() {
		boolean flagSuperBackPress = true;
		FragmentManager manager = getSupportFragmentManager();
		List<Fragment> fragmentList = manager.getFragments();
		if (fragmentList.size() > 0) {
			Fragment fragment = fragmentList.get(0);
			if (fragment instanceof BaseFragment) {
				BaseFragment baseFragment = (BaseFragment) fragment;
				if (baseFragment.onBackPress()) flagSuperBackPress = false;
			}
		}
		if (flagSuperBackPress && !banOnBackPress()) super.onBackPressed();
	}
}
