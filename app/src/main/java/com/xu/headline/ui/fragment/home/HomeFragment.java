package com.xu.headline.ui.fragment.home;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/16.
 */

public class HomeFragment extends BaseFragment<IHomeContract.IHomePresenter> implements IHomeContract.IHomeView {
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
