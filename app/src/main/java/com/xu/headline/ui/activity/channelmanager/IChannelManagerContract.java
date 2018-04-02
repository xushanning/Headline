package com.xu.headline.ui.activity.channelmanager;

import com.xu.headline.base.IBaseContract;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public interface IChannelManagerContract {

    interface IChannelView extends IBaseContract.IBaseView {

    }

    interface IChannelPresenter extends IBaseContract.IBasePresenter<IChannelView> {

    }
}
