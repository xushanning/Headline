package com.xu.headline.ui.fragment.personalcenter;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class PersonalCenterFragment extends BaseFragment<IPersonalCenterContract.IPersonalCenterPresenter> implements IPersonalCenterContract.IPersonalCenterView {
    @Override
    public int setLayoutId() {
        return R.layout.fragment_personal_center;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IPersonalCenterContract.IPersonalCenterPresenter createPresenter() {
        return new PersonalCenterPresenter();
    }
}
