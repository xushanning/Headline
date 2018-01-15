package com.xu.headline.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public abstract class BaseActivity<T extends BaseContract.IBasePresenter> extends RxAppCompatActivity implements BaseContract.IBaseView {
    protected T mPresenter;
    private Unbinder bind;
    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        //initScreen();

        mPresenter = setPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        bind = ButterKnife.bind(this);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initOthers();
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
        //中断所有的rx请求
        mPresenter.onUiDestroy();
    }
}
