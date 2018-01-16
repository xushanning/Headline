package com.xu.headline.ui.fragment.video;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class VideoFragment extends BaseFragment<IVideoContract.IVideoPresenter> implements IVideoContract.IVideoView {
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
}
