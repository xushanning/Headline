package com.xu.headline.ui.fragment.videolist;

import android.os.Bundle;
import android.service.carrier.CarrierService;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xu.headline.R;
import com.xu.headline.adapter.VideoListQuickAdapter;
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

        adapter = new VideoListQuickAdapter(new ArrayList<TouTiaoNewsVideoItemBean>());
        rvVideoDetail.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d("sdjkflasjflksdjfl");
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.video_player:
                        Logger.d("视频被点击了");
                        TouTiaoNewsVideoItemBean itemBean = (TouTiaoNewsVideoItemBean) adapter.getItem(position);
                        mPresenter.getVideoAddress(itemBean.getShare_url());
                        break;
                    default:
                        break;
                }
            }
        });

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
        Logger.d(itemBeans.size());
        adapter.addData(itemBeans);
    }

}
