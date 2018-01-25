package com.xu.headline.ui.fragment.homelist;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.IDataBaseResBean;
import com.xu.headline.bean.IDataNewsBean;
import com.xu.headline.net.BaseHttpResObserver;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public class HomeListPresenter extends BasePresenter<IHomeListContract.IHomeListView> implements IHomeListContract.IHomeListPresenter {

    @Override
    public void getNewsList(String channel) {
//        RetrofitFactory.getTouTiaoApi()
//                .getNewsList(channel, 0, 30, HttpConstants.APP_KEY)
//                .compose(mView.<BaseResBean<NewsListBean>>bindToLife())
//                .compose(TransformUtils.<BaseResBean<NewsListBean>>defaultSchedulers())
//                .subscribe(new BaseHttpResultObserver<NewsListBean>() {
//                    @Override
//                    protected void onSuccess(NewsListBean newsListBean) {
//                        mView.loadNewsList(newsListBean);
//                    }
//                });
        RetrofitFactory.getIDataApi()
                .getNewsData(0, channel, HttpConstants.APP_KEY_IDATA)
                .compose(mView.<IDataBaseResBean<List<IDataNewsBean>>>bindToLife())
                .compose(TransformUtils.<IDataBaseResBean<List<IDataNewsBean>>>defaultSchedulers())
                .subscribe(new BaseHttpResObserver<List<IDataNewsBean>>() {
                    @Override
                    protected void onSuccess(List<IDataNewsBean> iDataNewsBeans) {
                        mView.loadNewsList(iDataNewsBeans);
                    }
                });
    }
}
