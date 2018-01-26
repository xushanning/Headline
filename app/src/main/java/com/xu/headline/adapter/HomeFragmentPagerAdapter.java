package com.xu.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.orhanobut.logger.Logger;
import com.xu.headline.bean.ShowApiChannelListBean;
import com.xu.headline.ui.fragment.homelist.HomeListFragment;

import java.util.List;

/**
 * @author xu
 */

public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<ShowApiChannelListBean.ChannelListBean> channels;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<ShowApiChannelListBean.ChannelListBean> channels) {
        super(fm);
        this.channels = channels;
    }

    @Override
    public Fragment getItem(int position) {
        return HomeListFragment.newInstance(channels.get(position).getChannelId());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channels.get(position).getChannelName();
    }

    @Override
    public int getCount() {
        return channels != null ? channels.size() : 0;
    }
}
