package com.xu.headline.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xu.headline.bean.response.VideoChannelBean;
import com.xu.headline.ui.fragment.videolist.VideoListFragment;

import java.util.List;

/**
 * Created by xusn10 on 2018/2/5.
 *
 * @author xu
 */

public class VideoFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<VideoChannelBean> channelList;

    public VideoFragmentPagerAdapter(FragmentManager fm, List<VideoChannelBean> channelList) {
        super(fm);
        this.channelList = channelList;
    }

    @Override
    public Fragment getItem(int position) {
        return VideoListFragment.newInstance(channelList.get(position).getCategory());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return channelList.get(position).getName();
    }

    @Override
    public int getCount() {
        return channelList != null ? channelList.size() : 0;
    }
}
