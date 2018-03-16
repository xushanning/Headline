package com.xu.headline.base;

import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.github.nukc.stateview.StateView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.xu.headline.R;
import com.xu.headline.receiver.NetBroadcastReceiver;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xusn10 on 2018/1/15.
 * 懒加载
 * http://www.cnblogs.com/dasusu/p/6745032.html
 *
 * @author xu
 */

public abstract class BaseFragment<T extends IBaseContract.IBasePresenter> extends RxFragment implements IBaseContract.IBaseView, IBase {

    protected T mPresenter;
    private Unbinder bind;
    private NetBroadcastReceiver netBroadcastReceiver;
    /**
     * 加载
     */
    private SkeletonScreen loadingStateView;
    /**
     * 无网络
     */
    private SkeletonScreen noNetworkStateView;
    private ViewSkeletonScreen.Builder loadingBuilder;
    private ViewSkeletonScreen.Builder noNetworkBuilder;
    private RecyclerViewSkeletonScreen.Builder recyclerViewBuilder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(setLayoutId(), container, false);
        bind = ButterKnife.bind(this, mView);

        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        mPresenter.attachView(this);
        initOthers();
        initStateView(setReplaceView());
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNetReceiver();
    }

    /**
     * 初始化无网络，重试，加载中的stateView
     */
    private void initStateView(View view) {

        if (setReplaceView() != null) {
            loadingBuilder = Skeleton
                    .bind(view)
                    .load(R.layout.layout_loading)
                    .shimmer(true)
                    .duration(2000)
                    .color(R.color.colorAccent);
            noNetworkBuilder = Skeleton
                    .bind(view)
                    .load(R.layout.layout_no_network)
                    .shimmer(false);
//                recyclerViewBuilder = Skeleton
//                        .bind(view)
//                        .adapter()


        }

    }

    /**
     * 显示loading
     */
    protected void showLoading() {
        if (setReplaceView() != null) {
            loadingStateView = loadingBuilder.show();
        }
    }

    /**
     * 显示无网络
     */
    protected void showNoNetwork() {
        if (setReplaceView() != null) {
            noNetworkStateView = noNetworkBuilder.show();
        }

    }

    /**
     * 隐藏stateView
     */
    protected void hideStateView() {
        if (setReplaceView() != null) {
            loadingStateView.hide();
            noNetworkStateView.hide();
        }

    }

    /**
     * 设置展示loading、无网络的view位置
     *
     * @return 控件id
     */
    protected View setReplaceView() {
        return null;
    }


    /**
     * 初始化网络广播接收
     */
    private void initNetReceiver() {
        netBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        getActivity().registerReceiver(netBroadcastReceiver, filter);
        netBroadcastReceiver.setOnNetworkListener(this);
    }

    /**
     * 初始化其他
     */
    public abstract void initOthers();

    /**
     * 设置presenter
     *
     * @return 对应的presenter
     */
    public abstract T createPresenter();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        bind.unbind();
        if (netBroadcastReceiver != null) {
            getActivity().unregisterReceiver(netBroadcastReceiver);
        }
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }
}
