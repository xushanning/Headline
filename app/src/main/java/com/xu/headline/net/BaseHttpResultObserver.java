package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.base.BaseShowApiResBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public abstract class BaseHttpResultObserver<T> implements Observer<BaseShowApiResBean<T>> {
    /**
     * 请求成功
     */
    private static final int REQUEST_OK = 0;

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseShowApiResBean<T> tBaseResBean) {
        if (tBaseResBean.getResCode() == REQUEST_OK) {
            onSuccess(tBaseResBean.getResBody());
        } else {
            onCodeError(tBaseResBean.getResError());
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {

    }

    /**
     * 请求成功
     *
     * @param t t
     */
    protected abstract void onSuccess(T t);

    private void onCodeError(String codeMessage) {

    }
}
