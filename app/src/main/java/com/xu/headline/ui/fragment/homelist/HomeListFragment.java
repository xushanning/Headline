package com.xu.headline.ui.fragment.homelist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeListQuickAdapter;
import com.xu.headline.adapter.MultiNewsItem;
import com.xu.headline.base.BaseViewPagerFragment;
import com.xu.headline.ui.activity.newsdetail.NewsDetailActivity;
import com.xu.headline.utils.TransformUtils;
import com.xu.headline.view.MultipleStatusView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by xusn10 on 2018/1/18.
 * 首页的列表fragment
 *
 * @author xu
 */

public class HomeListFragment extends BaseViewPagerFragment<IHomeListContract.IHomeListPresenter> implements IHomeListContract.IHomeListView {
    @BindView(R.id.rv_home_detail)
    RecyclerView rvHomeDetail;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.ll_custom_notice)
    LinearLayout llCustomNotice;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.ms_status_view)
    MultipleStatusView msStatusView;


    private HomeListQuickAdapter homeListQuickAdapter;
//    /**
//     * 第一次加载
//     */
//    public static final int FIRST_LOAD = 1;
//    /**
//     * 上拉加载
//     */
//    public static final int PULL_LOAD = 2;
//    /**
//     * 下拉加载
//     */
//    public static final int PULL_DOWN_LOAD = 3;
    /**
     * 频道名称
     */
    private String channelID;
    private boolean isShowing;
    private Disposable delayDisposable;

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
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomeDetail.setLayoutManager(layoutManager);

        homeListQuickAdapter = new HomeListQuickAdapter(new ArrayList<MultiNewsItem>());
        rvHomeDetail.setAdapter(homeListQuickAdapter);
        //加载更多
//        homeListQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                Logger.d("加载更多");
//                mPresenter.getNewsList("news_hot", PULL_LOAD);
//            }
//        }, rvHomeDetail);
        //条目点击
        homeListQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MultiNewsItem newsItem = (MultiNewsItem) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("newsID", newsItem.getItemBean().getItem_id());
                intent.putExtra("channelID", channelID);
                startActivity(intent);

            }
        });
        homeListQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d(position + "个x号被点击了");

            }
        });
        //下拉刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getNewsList(channelID);
            }
        });
        //上拉加载
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                //mPresenter.getNewsList(channelID, PULL_LOAD);

            }
        });
        //重试
        msStatusView.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.d("重试");

            }
        });
        //牵扯到动画，必须测量
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        llCustomNotice.measure(w, h);
    }

    @Override
    public IHomeListContract.IHomeListPresenter createPresenter() {
        return new HomeListPresenter();
    }

    @Override
    public void startLoadData() {
        //加载本地数据库里的数据
        msStatusView.showLoading();
        //网络获取
        mPresenter.getNewsList(channelID);
    }

    @Override
    public void loadNewsList(List<MultiNewsItem> itemBeans) {
        Logger.d("展示内容");
        smartRefreshLayout.finishRefresh();
        msStatusView.showContent();
        if (itemBeans == null || itemBeans.size() == 0) {
            showNotice(getString(R.string.no_update));
        } else {
            homeListQuickAdapter.addData(0, itemBeans);
            rvHomeDetail.scrollToPosition(0);
            showNotice(getString(R.string.update_count, itemBeans.size()));
        }

    }

    @Override
    public void loadHistoryNewsFrDb(List<MultiNewsItem> itemBeans) {
        homeListQuickAdapter.addData(itemBeans);
    }


    public void pullToLoadMoreData(List<MultiNewsItem> itemBeans) {
        if (itemBeans == null) {
            //加载更多失败
            homeListQuickAdapter.loadMoreFail();
        } else {
            homeListQuickAdapter.addData(itemBeans);
            homeListQuickAdapter.loadMoreComplete();
//            //已经加载的数量
//            alreadyLoadedNewsCount = homeListQuickAdapter.getData().size();
//            loadDataCount++;
        }
    }

    /**
     * 展示通知
     *
     * @param text 需要展示的文字
     */
    private void showNotice(String text) {
        if (isShowing) {
            return;
        }
        isShowing = true;
        llCustomNotice.setVisibility(View.VISIBLE);
        tvNotice.setText(text);
        //延时一段时间后，进行动画
        delayDisposable = Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(TransformUtils.<Long>defaultSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        ValueAnimator animator = ValueAnimator.ofInt(llCustomNotice.getMeasuredHeight(), 0);
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int value = (int) animation.getAnimatedValue();
                                if (llCustomNotice.getLayoutParams() != null) {
                                    ViewGroup.LayoutParams layoutParams = llCustomNotice.getLayoutParams();
                                    layoutParams.height = value;
                                    llCustomNotice.setLayoutParams(layoutParams);
                                }
                            }
                        });
                        animator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                llCustomNotice.setVisibility(View.GONE);
                                isShowing = false;
                            }
                        });
                        animator.setDuration(500);
                        animator.start();
                    }
                });

    }

    @Override
    public void onStop() {
        super.onStop();
        if (delayDisposable != null) {
            delayDisposable.dispose();
            llCustomNotice.setVisibility(View.GONE);
        }

    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {
    }


}
