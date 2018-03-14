package com.xu.headline.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by xusn10 on 2018/3/14.
 * viewpager的base
 *
 * @author xusn10
 */

public abstract class BaseViewPagerFragment<T extends IBaseContract.IBasePresenter> extends BaseFragment<T> {
    /**
     * fragment是否可以见
     */
    private boolean isFragmentVisible;
    /**
     * 是否进行复用，默认复用
     */
    private boolean isReuseView;
    /**
     * 是否是第一次进入，默认是
     */
    private boolean isFirstVisible;
    private View mView;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mView == null) {
            return;
        }
        if (isFirstVisible && isVisibleToUser) {
            //如果是第一次进入并且可见
            onFragmentFirstVisible();
            isFirstVisible = false;
        }
        if (isVisibleToUser) {
            //如果不是第一次进入，可见的时候
            isFragmentVisible = true;
            //回调当前fragment可见
            onFragmentVisibleChange(isFragmentVisible);
            return;
        }
        if (isFragmentVisible) {
            //如果当前fragment不可见且标识为true
            isFragmentVisible = false;
            //回调当前fragment不可见
            onFragmentVisibleChange(isFragmentVisible);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVariable();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = view;
            if (getUserVisibleHint()) {
                if (isFirstVisible) {
                    onFragmentFirstVisible();
                    isFirstVisible = false;
                }
                onFragmentVisibleChange(true);
                isFragmentVisible = true;
            }
        }
        super.onViewCreated(isReuseView ? mView : view, savedInstanceState);
    }

    /**
     * 在fragment首次可见时回调，可在这里进行加载数据，保证只在第一次打开Fragment时才会加载数据，
     * 这样就可以防止每次进入都重复加载数据
     */
    protected void onFragmentFirstVisible() {
        startLoadData();
    }

    /**
     * 是否复用view,默认是
     *
     * @param isReuse 是否
     */
    protected void reuseView(boolean isReuse) {
        isReuseView = isReuse;
    }

    protected boolean isFragmentVisible() {
        return isFragmentVisible;
    }


    /**
     * 保证只有当fragment可见状态发生变化时才回调
     *
     * @param isVisible 是否可见 true  不可见 -> 可见 false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {

    }

    /**
     * 重置变量
     */
    private void initVariable() {
        isFirstVisible = true;
        isReuseView = true;
        isFragmentVisible = false;
    }

    /**
     * 开始加载数据
     */
    public abstract void startLoadData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        initVariable();
    }
}
