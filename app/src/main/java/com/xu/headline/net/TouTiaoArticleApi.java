package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.NewsDetailsBean;

import io.reactivex.Observable;

/**
 * Created by xusn10 on 2018/2/9.
 *
 * @author xu
 */

public class TouTiaoArticleApi {
    private TouTiaoArticleApiService touTiaoArticleApiService;
    private static TouTiaoArticleApi touTiaoArticleApi;

    public TouTiaoArticleApi(TouTiaoArticleApiService touTiaoArticleApiService) {
        this.touTiaoArticleApiService = touTiaoArticleApiService;
    }

    static TouTiaoArticleApi getInstance(TouTiaoArticleApiService touTiaoArticleApiService) {
        if (touTiaoArticleApi == null) {
            touTiaoArticleApi = new TouTiaoArticleApi(touTiaoArticleApiService);
        }
        return touTiaoArticleApi;
    }


    /**
     * 获取推荐频道
     *
     * @param articleID 文章id
     * @return observable
     */
    public Observable<BaseResBean<NewsDetailsBean>> getNewsDetails(long articleID) {
        return touTiaoArticleApiService.getNewsDetails(articleID, articleID, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

}
