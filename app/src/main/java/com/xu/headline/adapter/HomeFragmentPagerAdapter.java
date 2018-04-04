package com.xu.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xu.headline.bean.NewsChannelListBean;
import com.xu.headline.ui.fragment.homelist.HomeListFragment;

import java.util.List;

/**
 * @author xu
 */

public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<NewsChannelListBean.ChannelBean> channels;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<NewsChannelListBean.ChannelBean> channels) {
        super(fm);
        this.channels = channels;
    }

    @Override
    public Fragment getItem(int position) {
        return HomeListFragment.newInstance(channels.get(position).getCategory());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channels.get(position).getName();
    }

    @Override
    public int getCount() {
        return channels != null ? channels.size() : 0;
    }
}
