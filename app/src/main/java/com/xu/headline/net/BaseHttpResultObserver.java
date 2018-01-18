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
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResBean<T> tBaseResBean) {
        if (tBaseResBean.getShowapi_res_code() == 0) {
            onSuccess(tBaseResBean.getShowapi_res_body());
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
}
