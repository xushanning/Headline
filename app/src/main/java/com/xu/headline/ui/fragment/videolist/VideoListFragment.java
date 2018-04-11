package com.xu.headline.ui.fragment.videolist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xu.headline.R;
import com.xu.headline.adapter.VideoListQuickAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.base.BaseViewPagerFragment;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.view.MultipleStatusView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class VideoListFragment extends BaseViewPagerFragment<IVideoListContract.IVideoListPresenter> implements IVideoListContract.IVideoListView {
    @BindView(R.id.rv_video_detail)
    RecyclerView rvVideoDetail;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.ll_custom_notice)
    LinearLayout llCustomNotice;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.ms_status_view)
    MultipleStatusView msStatusView;

    /**
     * 频道名称
     */
    private String channelID;
    private VideoListQuickAdapter adapter;

    public static VideoListFragment newInstance(String channelID) {
        Bundle args = new Bundle();
        args.putString("channelID", channelID);
        VideoListFragment videoListFragment = new VideoListFragment();
        videoListFragment.setArguments(args);
        return videoListFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_video_detail;
    }

    @Override
    public void initOthers() {
        if (getArguments() != null) {
            channelID = getArguments().getString("channelID");
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVideoDetail.setLayoutManager(layoutManager);

        adapter = new VideoListQuickAdapter(new ArrayList<List<TouTiaoNewsVideoItemBean>>());
        rvVideoDetail.setAdapter(adapter);
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

    @Override
    public void startLoadData() {
        mPresenter.getVideoList(channelID, "pull");
    }

    @Override
    public void loadVideoList(List<TouTiaoNewsVideoItemBean> itemBeans) {
        adapter.addData(itemBeans);
    }
}
