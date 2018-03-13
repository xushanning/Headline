package com.xu.headline.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxFragment;
import com.xu.headline.receiver.NetBroadcastReceiver;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xu
 */

public abstract class BaseFragment<T extends IBaseContract.IBasePresenter> extends RxFragment implements IBaseContract.IBaseView, IBase {
    private View mView;
    protected T mPresenter;
    private Unbinder bind;
    private NetBroadcastReceiver netBroadcastReceiver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutId(), container, false);
        bind = ButterKnife.bind(this, mView);
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initOthers();
        return mView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initNetReceiver();
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
