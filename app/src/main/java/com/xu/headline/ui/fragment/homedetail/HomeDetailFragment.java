package com.xu.headline.ui.fragment.homedetail;

import android.os.Bundle;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public class HomeDetailFragment extends BaseFragment<IHomeDetailContract.IHomeDetailPresenter> implements IHomeDetailContract.IHomeDetailView {

    public static HomeDetailFragment newInstance(String channelID) {
        Bundle args = new Bundle();
        args.putString("channelID", channelID);
        HomeDetailFragment homeDetailFragment = new HomeDetailFragment();
        homeDetailFragment.setArguments(args);
        return homeDetailFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home_detail;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IHomeDetailContract.IHomeDetailPresenter createPresenter() {
        return new HomeDetailPresenter();
    }
}
