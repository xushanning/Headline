package com.xu.headline.ui.fragment.homedetail;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeDetailQuickAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.NewsListBean;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public class HomeDetailFragment extends BaseFragment<IHomeDetailContract.IHomeDetailPresenter> implements IHomeDetailContract.IHomeDetailView {
    @BindView(R.id.rv_home_detail)
    RecyclerView rvHomeDetail;

    private HomeDetailQuickAdapter homeDetailQuickAdapter;
    /**
     * 频道名称
     */
    private String channelName;

    public static HomeDetailFragment newInstance(String channelName) {
        Bundle args = new Bundle();
        args.putString("channelName", channelName);
        HomeDetailFragment homeDetailFragment = new HomeDetailFragment();
        homeDetailFragment.setArguments(args);
        return homeDetailFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home_detail;
    }

    @Override
    public void initOthers() {
        if (getArguments() != null) {
            channelName = getArguments().getString("channelName");
            mPresenter.getNewsList(channelName);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomeDetail.setLayoutManager(layoutManager);

        homeDetailQuickAdapter = new HomeDetailQuickAdapter(R.layout.item_home_detail, new ArrayList<NewsListBean.ListBean>());
        homeDetailQuickAdapter.setUpFetchEnable(true);
        rvHomeDetail.setAdapter(homeDetailQuickAdapter);
        //下拉刷新
        homeDetailQuickAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                Logger.d("下拉刷新");
            }
        });
        //加载更多
        homeDetailQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Logger.d("加载更多");
            }
        }, rvHomeDetail);
        //条目点击
        homeDetailQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d(position + "被点击了");
            }
        });
        homeDetailQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d(position + "个x号被点击了");

            }
        });
    }

    @Override
    public IHomeDetailContract.IHomeDetailPresenter createPresenter() {
        return new HomeDetailPresenter();
    }

    @Override
    public void loadNewsList(NewsListBean newsListBean) {
        Logger.d(channelName + "频道有" + newsListBean.getList().size() + "条数据");
        homeDetailQuickAdapter.setNewData(newsListBean.getList());
    }


}
