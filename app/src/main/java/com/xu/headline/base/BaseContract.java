package com.xu.headline.base;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public interface BaseContract {
    interface IBaseView {
        /**
         * 设置layout
         *
         * @return 布局id
         */
        int setLayoutId();

    }

    interface IBasePresenter<T extends IBaseView> {
        /**
         * 绑定view
         *
         * @param view view接口
         */
        void attachView(T view);

        /**
         * 解绑view
         */
        void detachView();

        /**
         * 当activity或者fragement销毁的时候调用
         */
        void onUiDestroy();

    }

}
