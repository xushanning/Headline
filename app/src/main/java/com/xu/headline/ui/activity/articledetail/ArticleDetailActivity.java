package com.xu.headline.ui.activity.articledetail;

import com.xu.headline.base.BaseActivity;

/**
 * 新闻详情页
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class ArticleDetailActivity extends BaseActivity<IArticleDetailContract.IArticleDetailPresenter> implements IArticleDetailContract.IArticleDetailView {
    @Override
    public int setLayoutId() {
        return 0;
    }

    @Override
    public IArticleDetailContract.IArticleDetailPresenter setPresenter() {
        return null;
    }


}
