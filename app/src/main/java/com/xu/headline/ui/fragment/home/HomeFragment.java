package com.xu.headline.ui.fragment.home;

import android.os.Bundle;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomeFragment extends BaseFragment<IHomeContract.IHomePresenter> implements IHomeContract.IHomeView {


    /**
     * 实例化
     *
     * @return HomeFragment实例
     */
    public static HomeFragment newInstance() {
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        homeFragment.setArguments(args);
        return homeFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void initOthers() {

    }

    @Override
    public IHomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }
}
