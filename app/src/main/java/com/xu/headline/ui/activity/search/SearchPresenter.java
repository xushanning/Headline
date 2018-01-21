package com.xu.headline.ui.activity.search;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.SearchBean;
import com.xu.headline.net.BaseHttpResultObserver;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

/**
 * Created by Administrator on 2018/1/20.
 *
 * @author xu
 */

public class SearchPresenter extends BasePresenter<ISearchContract.ISearchView> implements ISearchContract.ISearchPresenter {
    @Override
    public void getSearchResult(String keyWord) {
        RetrofitFactory.getTouTiaoApi()
                .getSearchList(keyWord, HttpConstants.APP_KEY)
                .compose(mView.<BaseResBean<SearchBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<SearchBean>>defaultSchedulers())
                .subscribe(new BaseHttpResultObserver<SearchBean>() {
                    @Override
                    protected void onSuccess(SearchBean searchListBeans) {

                        mView.loadSearchResult(searchListBeans.getList());
                    }
                });

    }
}
