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
        initBundle();
        initView();
        initData();
    }

    protected void initBeforeSetContentView() {}

    protected abstract int getViewLayout();

    protected void initBundle() {}

    protected void initView() {}

    protected void initData() {}

    protected boolean interceptBackPress() {
        return false;
    }

    @Override
    public void onBackPressed() {
        boolean fragmentInterceptBackPress = false;
        FragmentManager manager = getSupportFragmentManager();
        List<Fragment> fragmentList = manager.getFragments();
        int size = fragmentList.size();
        if (size > 0) {
            Fragment fragment = fragmentList.get(size - 1);
            if (fragment instanceof BaseFragment) {
                BaseFragment baseFragment = (BaseFragment) fragment;
                if (baseFragment.interceptBackPress()) {
                    fragmentInterceptBackPress = true;
                }
            }
        }
        if (!fragmentInterceptBackPress && !interceptBackPress()) super.onBackPressed();
    }
}
