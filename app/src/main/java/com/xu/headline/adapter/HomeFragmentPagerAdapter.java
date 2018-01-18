package com.xu.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xu.headline.bean.ChannelsBean;
import com.xu.headline.ui.fragment.homedetail.HomeDetailFragment;

import java.util.List;

/**
 * @author xu
 */

public class HomeFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<ChannelsBean.ChannelListBean> channels;

    public HomeFragmentPagerAdapter(FragmentManager fm, List<ChannelsBean.ChannelListBean> channels) {
        super(fm);
        this.channels = channels;
    }

    @Override
    public Fragment getItem(int position) {
        String originString = channels.get(position).getChannelId();
        //去掉焦点或者最新
        String resultString = originString.replace("焦点", "").replace("最新", "");
        return HomeDetailFragment.newInstance(resultString);
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
