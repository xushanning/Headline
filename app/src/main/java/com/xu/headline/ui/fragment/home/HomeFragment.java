package com.xu.headline.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeFragmentPagerAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.ui.activity.search.SearchActivity;
import com.xu.headline.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomeFragment extends BaseFragment<IHomeContract.IHomePresenter> implements IHomeContract.IHomeView {


    @BindView(R.id.tab_layout_home)
    TabLayout tabLayoutHome;
    @BindView(R.id.vp_home)
    ViewPager vpHome;

    private HomeFragmentPagerAdapter homeFragmentPagerAdapter;

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
        mPresenter.getChannelInfo();
    }

    @Override
    public IHomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void loadData(List<String> list) {
        if (list != null) {
            //这里用getChildFragmentManager()，获取的是子容器的manager，而getFragmentManager是获取的父容器的manager
            homeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(), list);
            vpHome.setAdapter(homeFragmentPagerAdapter);
            vpHome.setCurrentItem(1, false);
            tabLayoutHome.setupWithViewPager(vpHome);
        } else {
            Logger.d("获取频道失败");
        }
    }


    @OnClick({R.id.vSearch, R.id.img_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vSearch:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.img_add:
                ToastUtil.toastShort(getActivity(), "增加频道!");
                break;
            default:
                break;
        }
    }
}
