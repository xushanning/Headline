package com.xu.headline.ui.activity.main;

import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;

/**
 * @author xusn10
 */
public class MainActivity extends BaseActivity<IMainContract.IMainPresenter> implements IMainContract.IMainView {


    @Override
    public IMainContract.IMainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }
}
