package com.xu.headline.ui.fragment.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeFragmentPagerAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.ChannelsBean;

import java.util.List;

import butterknife.BindView;

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

    private String[] channels = new String[]{"关注", "推荐", "新时代", "北京", "视频", "热点", "娱乐", "问答", "科技", "军事", "段子"};

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
//        for (int i = 0; i < channels.length; i++) {
//            tabLayoutHome.addTab(tabLayoutHome.newTab().setText(channels[i]));
//        }

    }

    @Override
    public IHomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void loadData(List<ChannelsBean.ChannelListBean> list) {
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


}
