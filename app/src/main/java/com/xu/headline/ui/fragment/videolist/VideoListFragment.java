package com.xu.headline.ui.fragment.videolist;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class VideoListFragment extends BaseFragment<IVideoListContract.IVideoListPresenter> implements IVideoListContract.IVideoListView {
    @Override
    public int setLayoutId() {
        return R.layout.fragment_video_detail;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IVideoListContract.IVideoListPresenter createPresenter() {
        return new VideoListPresenter();
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
