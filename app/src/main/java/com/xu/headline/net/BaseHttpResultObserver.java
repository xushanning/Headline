package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public abstract class BaseHttpResultObserver<T> implements Observer<BaseResBean<T>> {
    /**
     * 请求成功
     */
    private static final String REQUEST_OK = "ok";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResBean<T> tBaseResBean) {
        if (tBaseResBean.getMsg().equals(REQUEST_OK)) {
            onSuccess(tBaseResBean.getResult());
        } else {
            onCodeError(tBaseResBean.getMsg());
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
