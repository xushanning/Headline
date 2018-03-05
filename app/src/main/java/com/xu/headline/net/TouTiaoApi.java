package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.CommentListBean;
import com.xu.headline.bean.authorinfo.AuthorInfoBean;
import com.xu.headline.bean.SuggestSearchBean;
import com.xu.headline.bean.NewsSuggestChannelBean;
import com.xu.headline.bean.TouTiaoNewsListBean;

import io.reactivex.Observable;

/**
 * Created by xusn10 on 2018/2/5.
 *
 * @author xu
 */

public class TouTiaoApi {
    private TouTiaoApiService touTiaoApiService;
    private static TouTiaoApi touTiaoApi;

    private TouTiaoApi(TouTiaoApiService touTiaoApiService) {
        this.touTiaoApiService = touTiaoApiService;
    }


    /**
     * 获取TouTiaoApi
     *
     * @param touTiaoApiService touTiaoApiService
     * @return TouTiaoApi
     */

    static TouTiaoApi getInstance(TouTiaoApiService touTiaoApiService) {
        if (touTiaoApi == null) {
            touTiaoApi = new TouTiaoApi(touTiaoApiService);
        }
        return touTiaoApi;
    }

    /**
     * 获取推荐搜索
     *
     * @return observable
     */
    public Observable<BaseResBean<SuggestSearchBean>> getSuggestSearch() {
        return touTiaoApiService.getSuggestSearch(1, "{\"suggest_word\":{\"from\":\"feed\",\"sug_category\":\"__all__\"}}",
                3, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取推荐频道
     *
     * @return observable
     */
    public Observable<BaseResBean<NewsSuggestChannelBean>> getSuggestChannel() {
        return touTiaoApiService.getSuggestChannel("25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取新闻列表
     *
     * @param category        频道类型
     * @param lastRefreshTime 上一次刷新的时间
     * @return observable
     */
    public Observable<TouTiaoNewsListBean> getNewsList(String category, long lastRefreshTime) {
        return touTiaoApiService.getNewsList(20, category, 1, 1, 5, 20, lastRefreshTime, System.currentTimeMillis() / 1000, "25206805877");
    }

    /**
     * 获取头条号作者信息
     *
     * @param newsID   id
     * @param category 文章来源类型
     * @return observable
     */
    public Observable<BaseResBean<AuthorInfoBean>> getAuthorInfo(long newsID, String category) {
        return touTiaoApiService.getAuthorInfo(39.908766, 116.366742, newsID, newsID, 1, 1, category, 0, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取评论列表
     * @param newsID id
     * @param category 文章来源类型
     * @return observable
     */
    public Observable<CommentListBean> getCommentList(long newsID, String category) {
        return touTiaoApiService.getCommentList(newsID, newsID, 1, 20, 0, 0, 1, "47840702832", "wifi", "wifi", category, 13, "news_article",
                654, "6.5.4", "android");
    }
}
