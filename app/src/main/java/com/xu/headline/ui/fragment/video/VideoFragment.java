package com.xu.headline.ui.fragment.video;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.VideoFragmentPagerAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.response.VideoChannelBean;
import com.xu.headline.utils.ImageTintUtil;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class VideoFragment extends BaseFragment<IVideoContract.IVideoPresenter> implements IVideoContract.IVideoView {
    @BindView(R.id.tab_layout_home)
    TabLayout tabLayoutVideo;
    @BindView(R.id.vp_fragment)
    ViewPager vpVideo;
    @BindView(R.id.tv_suggest_search)
    TextView tvSuggestSearch;
    @BindView(R.id.img_un_login)
    ImageView imgUnLogin;
    @BindView(R.id.img_release)
    ImageView imgRelease;

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
        initImage();
        mPresenter.initVideoChannel();
        mPresenter.getSuggestSearch();
    }

    /**
     * 初始化图片颜色
     */
    private void initImage() {
        Drawable loginDrawable = imgUnLogin.getDrawable();
        imgUnLogin.setImageDrawable(ImageTintUtil.tintDrawable(loginDrawable, ColorStateList.valueOf(Color.WHITE)));
        Drawable releaseDrawable = imgRelease.getDrawable();
        imgRelease.setImageDrawable(ImageTintUtil.tintDrawable(releaseDrawable, ColorStateList.valueOf(Color.WHITE)));
    }

    @Override
    public IVideoContract.IVideoPresenter createPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void loadVideoChannel(List<VideoChannelBean> channelList) {
        if (channelList != null) {
            VideoFragmentPagerAdapter adapter = new VideoFragmentPagerAdapter(getChildFragmentManager(), channelList);
            vpVideo.setAdapter(adapter);
            vpVideo.setCurrentItem(1, false);
            tabLayoutVideo.setupWithViewPager(vpVideo);
        } else {
            Logger.d("获取视频频道失败!");
        }
    }

    @Override
    public void loadSuggestSearch(String suggestString) {
        if (suggestString != null) {
            tvSuggestSearch.setText(suggestString);
        }
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
