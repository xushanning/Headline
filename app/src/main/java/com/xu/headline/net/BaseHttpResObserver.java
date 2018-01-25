package com.xu.headline.net;

import com.xu.headline.base.IDataBaseResBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/25.
 */

public abstract class BaseHttpResObserver<T> implements Observer<IDataBaseResBean<T>> {
    /**
     * 请求成功
     */
    private static final String REQUEST_OK = "000000";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(IDataBaseResBean<T> tBaseResBean) {
        if (tBaseResBean.getAppCode().equals(REQUEST_OK)) {
            onSuccess(tBaseResBean.getData());
        } else {
            onCodeError(tBaseResBean.getAppCode());
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
