package com.xu.headline.ui.fragment.video;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.VideoChannelBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class VideoFragment extends BaseFragment<IVideoContract.IVideoPresenter> implements IVideoContract.IVideoView {

    @BindView(R.id.tl_video)
    TabLayout tlVideo;
    @BindView(R.id.vp_video)
    ViewPager vpVideo;

    /**
     * 实例化
     *
     * @return VideoFragment
     */
    public static VideoFragment newInstance() {
        VideoFragment videoFragment = new VideoFragment();
        Bundle args = new Bundle();
        videoFragment.setArguments(args);
        return videoFragment;
    }


    @Override
    public int setLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IVideoContract.IVideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void loadVideoChannel(List<VideoChannelBean.TypesBean> channelList) {

    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
