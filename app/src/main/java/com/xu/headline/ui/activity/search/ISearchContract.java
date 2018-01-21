package com.xu.headline.ui.activity.search;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.NewsListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/20.
 *
 * @author xu
 */

public interface ISearchContract {
    interface ISearchView extends IBaseContract.IBaseView {
        /**
         * 加载搜索的结果
         *
         * @param searchListBeans 数据
         */
        void loadSearchResult(List<NewsListBean.ListBean> searchListBeans);
    }

    interface ISearchPresenter extends IBaseContract.IBasePresenter<ISearchView> {
        /**
         * 过去搜索结果
         *
         * @param keyWord 关键词
         */
        void getSearchResult(String keyWord);
    }
}
