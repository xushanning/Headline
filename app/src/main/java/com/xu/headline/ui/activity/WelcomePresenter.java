package com.xu.headline.ui.activity;

/**
 * @author xusn10
 * @date 2018/1/15
 */

public class WelcomePresenter implements WelcomeContract.IWelcomePresenter {
    private WelcomeContract.IWelcomeView welcomeView;

    @Override
    public void attachView(WelcomeContract.IWelcomeView view) {
        this.welcomeView = view;
    }

    @Override
    public void detachView() {
        this.welcomeView = null;
    }

    @Override
    public void onUiDestroy() {

    }
}
