package com.xu.headline.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xusn10 on 2018/1/15.
 */

public abstract class BaseFragment<T extends BaseContract.IBasePresenter> extends RxFragment implements BaseContract.IBaseView {
    private View mView;
    protected T mPresenter;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutId(), container, false);
        initScreen();
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

    /**
     * 沉浸式
     */
    private void initScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getActivity().getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            winParams.flags = winParams.flags & ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
        } else {
            Logger.d("版本过低，不支持沉浸式标题栏");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        bind.unbind();
        //中断所有的rx请求和其他
        mPresenter.onUiDestroy();
    }
}
