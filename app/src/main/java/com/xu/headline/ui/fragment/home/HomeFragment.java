package com.xu.headline.ui.fragment.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomeFragment extends BaseFragment<IHomeContract.IHomePresenter> implements IHomeContract.IHomeView {


    @BindView(R.id.tab_layout_home)
    TabLayout tabLayoutHome;

    private String[] channels = new String[]{"关注", "推荐", "新时代", "北京", "视频", "热点", "娱乐", "问答", "科技", "军事", "段子"};

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
        for (int i = 0; i < channels.length; i++) {
            tabLayoutHome.addTab(tabLayoutHome.newTab().setText(channels[i]));
        }

    }

    @Override
    public IHomeContract.IHomePresenter createPresenter() {
        return new HomePresenter();
    }

}
