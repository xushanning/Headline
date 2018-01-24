package com.xu.headline.ui.fragment.videolist;

import com.xu.headline.base.IBaseContract;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public interface IVideoListContract {
    interface IVideoListView extends IBaseContract.IBaseView {

    }

    interface IVideoListPresenter extends IBaseContract.IBasePresenter<IVideoListView> {

    }
}
