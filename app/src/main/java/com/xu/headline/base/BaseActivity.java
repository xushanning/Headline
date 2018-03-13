package com.xu.headline.base;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.xu.headline.receiver.NetBroadcastReceiver;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public abstract class BaseActivity<T extends IBaseContract.IBasePresenter> extends RxAppCompatActivity implements IBaseContract.IBaseView, IBase {
    protected T mPresenter;
    private Unbinder bind;
    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private NetBroadcastReceiver netBroadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        mPresenter = setPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        bind = ButterKnife.bind(this);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initOthers();
        initNetReceiver();
    }

    /**
     * 初始化网络广播接收
     */
    private void initNetReceiver() {
        netBroadcastReceiver = new NetBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netBroadcastReceiver, filter);
        netBroadcastReceiver.setOnNetworkListener(this);
    }

    /**
     * 设置presenter
     *
     * @return 对应的presenter
     */
    public abstract T setPresenter();

    /**
     * 初始化其他
     */
    public void initOthers() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.dispose();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        bind.unbind();
        if (netBroadcastReceiver != null) {
            unregisterReceiver(netBroadcastReceiver);
        }
    }

    /**
     * 绑定生命周期
     *
     * @param <T> T
     * @return LifecycleTransformer
     */
    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.bindToLifecycle();
    }
}
