package com.xu.headline.ui.fragment.homelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeDetailQuickAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.IDataNewsBean;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.ui.activity.articledetail.ArticleDetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xusn10 on 2018/1/18.
 * 首页的列表fragment
 *
 * @author xu
 */

public class HomeListFragment extends BaseFragment<IHomeListContract.IHomeListPresenter> implements IHomeListContract.IHomeListView {
    @BindView(R.id.rv_home_detail)
    RecyclerView rvHomeDetail;

    private HomeDetailQuickAdapter homeDetailQuickAdapter;
    /**
     * 频道名称
     */
    private String channelID;

    public static HomeListFragment newInstance(String channelID) {
        Bundle args = new Bundle();
        args.putString("channelID", channelID);
        HomeListFragment homeListFragment = new HomeListFragment();
        homeListFragment.setArguments(args);
        return homeListFragment;
    }

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home_detail;
    }

    @Override
    public void initOthers() {
        if (getArguments() != null) {
            channelID = getArguments().getString("channelID");
            mPresenter.getNewsList(channelID);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomeDetail.setLayoutManager(layoutManager);

        homeDetailQuickAdapter = new HomeDetailQuickAdapter(R.layout.item_home_detail, new ArrayList<IDataNewsBean>());
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
                NewsListBean.ListBean listBean = (NewsListBean.ListBean) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                intent.putExtra("time", listBean.getTime());
                intent.putExtra("title", listBean.getTitle());
                intent.putExtra("source", listBean.getSrc());
                intent.putExtra("detailURL", listBean.getWeburl());
                startActivity(intent);
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
    public IHomeListContract.IHomeListPresenter createPresenter() {
        return new HomeListPresenter();
    }

    @Override
    public void loadNewsList(List<IDataNewsBean> iDataNewsBeans) {
        Logger.d(channelID + "频道有" + iDataNewsBeans.size() + "条数据");
        homeDetailQuickAdapter.setNewData(iDataNewsBeans);
    }


}
