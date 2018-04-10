package com.xu.headline.ui.fragment.video;

import android.os.Bundle;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.response.VideoChannelBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class VideoFragment extends BaseFragment<IVideoContract.IVideoPresenter> implements IVideoContract.IVideoView {

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
        return R.layout.fragment_home_and_video;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IVideoContract.IVideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void loadVideoChannel(List<VideoChannelBean> channelList) {

    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
