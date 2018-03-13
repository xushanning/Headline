package com.xu.headline.ui.fragment.personalcenter;

import android.os.Bundle;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.ui.fragment.home.HomeFragment;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class PersonalCenterFragment extends BaseFragment<IPersonalCenterContract.IPersonalCenterPresenter> implements IPersonalCenterContract.IPersonalCenterView {


    /**
     * 实例化
     *
     * @return PersonalCenterFragment实例
     */
    public static PersonalCenterFragment newInstance() {
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        Bundle args = new Bundle();
        personalCenterFragment.setArguments(args);
        return personalCenterFragment;
    }

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

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
