package com.xu.headline.ui.fragment.videodetail;

import com.xu.headline.R;
import com.xu.headline.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class VideoDetailFragment extends BaseFragment<IVideoDetailContract.IVideoDetailPresenter> implements IVideoDetailContract.IVideoDetailView {
    @Override
    public int setLayoutId() {
        return R.layout.fragment_video_detail;
    }

    @Override
    public void initOthers() {

    }

    @Override
    public IVideoDetailContract.IVideoDetailPresenter createPresenter() {
        return new IVideoDetailPresenter();
    }
}
