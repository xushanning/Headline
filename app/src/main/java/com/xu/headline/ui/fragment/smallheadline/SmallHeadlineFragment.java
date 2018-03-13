package com.xu.headline.ui.fragment.smallheadline;

import android.os.Bundle;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.ui.fragment.home.HomeFragment;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class SmallHeadlineFragment extends BaseFragment<ISmallHeadline.ISmallHeadlinePresenter> implements ISmallHeadline.ISmallHeadlineView {



    /**
     * 实例化
     *
     * @return SmallHeadlineFragment
     */
    public static SmallHeadlineFragment newInstance() {
        SmallHeadlineFragment smallHeadlineFragment = new SmallHeadlineFragment();
        Bundle args = new Bundle();
        smallHeadlineFragment.setArguments(args);
        return smallHeadlineFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_small_headline;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public ISmallHeadline.ISmallHeadlinePresenter createPresenter() {
        return new SmallHeadlinePresenter();
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
