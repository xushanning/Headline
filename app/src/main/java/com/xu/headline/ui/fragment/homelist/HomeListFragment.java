package com.xu.headline.ui.fragment.homelist;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.HomeDetailQuickAdapter;
import com.xu.headline.base.BaseFragment;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.ui.activity.articledetail.ArticleDetailActivity;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by xusn10 on 2018/1/18.
 * 首页的列表fragment
 *
 * @author xu
 */

public class HomeListFragment extends BaseFragment<IHomeListContract.IHomeListPresenter> implements IHomeListContract.IHomeListView {
    @BindView(R.id.rv_home_detail)
    RecyclerView rvHomeDetail;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    @BindView(R.id.ll_custom_notice)
    LinearLayout llCustomNotice;

    private HomeDetailQuickAdapter homeDetailQuickAdapter;
    /**
     * 频道名称
     */
    private String channelID;
    /**
     * 准备加载第loadDataCount次的数据，每加载更多一次，加一
     */
    private int loadDataCount = 1;
    /**
     * 总共的新闻条数
     */
    private int totalNewsCount;
    /**
     * 已经加载的新闻条数
     */
    private int alreadyLoadedNewsCount;

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
            mPresenter.getNewsList(channelID, loadDataCount);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomeDetail.setLayoutManager(layoutManager);

        homeDetailQuickAdapter = new HomeDetailQuickAdapter(R.layout.item_home_detail, new ArrayList<NewsListBean.PagebeanBean.ContentlistBean>());
        rvHomeDetail.setAdapter(homeDetailQuickAdapter);
        //加载更多
        homeDetailQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Logger.d("加载更多");
                if (alreadyLoadedNewsCount >= totalNewsCount) {
                    //加载完毕了
                    homeDetailQuickAdapter.loadMoreEnd();
                } else {
                    mPresenter.getNewsList(channelID, loadDataCount);
                }

            }
        }, rvHomeDetail);
        //条目点击
        homeDetailQuickAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsListBean.PagebeanBean.ContentlistBean bean = (NewsListBean.PagebeanBean.ContentlistBean) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
                intent.putExtra("time", bean.getPubDate());
                intent.putExtra("title", bean.getTitle());
                intent.putExtra("source", bean.getSource());
                intent.putExtra("detailURL", bean.getLink());
                startActivity(intent);

            }
        });
        homeDetailQuickAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d(position + "个x号被点击了");

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
    public void loadNewsList(NewsListBean newsListBean) {
        if (newsListBean == null) {
            //展示加载失败的view
            // homeDetailQuickAdapter.setEmptyView();
        } else {
            showNotice("今日头条推荐引擎有" + newsListBean.getPagebean().getContentlist().size() + "条更新");
            totalNewsCount = newsListBean.getPagebean().getAllNum();
            homeDetailQuickAdapter.setNewData(newsListBean.getPagebean().getContentlist());
            loadDataCount++;
        }

    }

    @Override
    public void loadMoreData(NewsListBean newsListBean) {
        if (newsListBean == null) {
            //加载更多失败
            homeDetailQuickAdapter.loadMoreFail();
        } else {
            totalNewsCount = newsListBean.getPagebean().getAllNum();
            homeDetailQuickAdapter.addData(newsListBean.getPagebean().getContentlist());
            homeDetailQuickAdapter.loadMoreComplete();
            //已经加载的数量
            alreadyLoadedNewsCount = homeDetailQuickAdapter.getData().size();
            loadDataCount++;
        }
    }

    /**
     * 展示通知
     *
     * @param text 需要展示的文字
     */
    private void showNotice(String text) {
        llCustomNotice.setVisibility(View.VISIBLE);
        tvNotice.setText(text);
        //延时一段时间后，进行动画
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(TransformUtils.<Long>defaultSchedulers())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        ValueAnimator animator = ValueAnimator.ofInt(llCustomNotice.getMeasuredHeight(), 0);
                        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                int value = (int) animation.getAnimatedValue();
                                ViewGroup.LayoutParams layoutParams = llCustomNotice.getLayoutParams();
                                layoutParams.height = value;
                                llCustomNotice.setLayoutParams(layoutParams);
                            }
                        });
                        animator.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                llCustomNotice.setVisibility(View.GONE);
                            }
                        });
                        animator.setDuration(500);
                        animator.start();
                    }
                });

    }


}
