package com.xu.headline.ui.fragment.smallheadline;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/16.
 * @author xu
 */

public class SmallHeadlineFragment extends BaseFragment<ISmallHeadline.ISmallHeadlinePresenter> implements ISmallHeadline.ISmallHeadlineView {
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
}
