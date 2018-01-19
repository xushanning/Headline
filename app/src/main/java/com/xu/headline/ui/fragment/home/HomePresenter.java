package com.xu.headline.ui.fragment.home;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.net.BaseHttpResultObserver;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {


    @Override
    public void getChannelInfo() {
        RetrofitFactory.getTouTiaoApi()
                .getChannels(HttpConstants.APP_KEY)
                .compose(mView.<BaseResBean<List<String>>>bindToLife())
                .compose(TransformUtils.<BaseResBean<List<String>>>defaultSchedulers())
                .subscribe(new BaseHttpResultObserver<List<String>>() {
                    @Override
                    protected void onSuccess(List<String> channelList) {
                        mView.loadData(channelList);
                    }
                });

    }
}
