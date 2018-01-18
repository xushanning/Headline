package com.xu.headline.ui.fragment.home;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.ChannelsBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public interface IHomeContract {
    interface IHomeView extends IBaseContract.IBaseView {
        /**
         * 加载数据
         *
         * @param list 频道列表
         */
        void loadData(List<ChannelsBean.ChannelListBean> list);
    }

    interface IHomePresenter extends IBaseContract.IBasePresenter<IHomeView> {
        /**
         * 从服务端获取频道列表
         */
        void getChannelInfo();
    }
}
