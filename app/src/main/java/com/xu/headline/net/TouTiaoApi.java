package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.response.CommentListBean;
import com.xu.headline.bean.response.CommentReplyListBean;
import com.xu.headline.bean.response.CommentReplyThemeBean;
import com.xu.headline.bean.response.VideoChannelBean;
import com.xu.headline.bean.response.authorinfo.AuthorInfoBean;
import com.xu.headline.bean.response.SuggestSearchBean;
import com.xu.headline.bean.response.NewsChannelListBean;
import com.xu.headline.bean.response.TouTiaoNewsVideoListBean;

import java.util.List;

import javax.security.auth.callback.Callback;

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
    public Observable<BaseResBean<NewsChannelListBean>> getNewsChannelList() {
        return touTiaoApiService.getNewsChannelList("25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取新闻列表
     *
     * @param category        频道类型
     * @param lastRefreshTime 上一次刷新的时间
     * @return observable
     */
    public Observable<TouTiaoNewsVideoListBean> getNewsList(String category, long lastRefreshTime) {
        return touTiaoApiService.getNewsList(20, category, "6213176537160616450", 1, 1, 5, 20, lastRefreshTime, System.currentTimeMillis() / 1000, 7, System.currentTimeMillis() / 1000,
                39.916559445439894, 116.38022377094337, "北京", "pull", 4105, 4794480, 3, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article", 654, "6.5.4", "android");
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
     *
     * @param newsID   id
     * @param category 文章来源类型
     * @return observable
     */
    public Observable<CommentListBean> getCommentList(long newsID, String category) {
        return touTiaoApiService.getCommentList(newsID, newsID, 1, 20, 0, 0, 1, "47840702832", "wifi", "wifi", category, 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取评论回复主题
     *
     * @param commentID 评论id
     * @return observable
     */
    public Observable<CommentReplyThemeBean> getCommentReplyTheme(long commentID) {
        return touTiaoApiService.getCommentReplyTheme(commentID, 5, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取评论回复的列表
     *
     * @param commentID 评论id
     * @return observable
     */
    public Observable<CommentReplyListBean> getCommentReplyList(long commentID) {
        return touTiaoApiService.getCommentReplyList(commentID, 20, 0, "25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取视频频道列表
     *
     * @return observable
     */
    public Observable<BaseResBean<List<VideoChannelBean>>> getVideoChannelList() {
        return touTiaoApiService.getVideoChannelList("25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取推荐频道列表
     *
     * @return observable
     */
    public Observable<BaseResBean<NewsChannelListBean>> getRecommendChannelList() {
        return touTiaoApiService.getRecommendChannelList("25206805877", "47840702832", "wifi", "huawei", 13, "news_article",
                654, "6.5.4", "android");
    }

    /**
     * 获取视频列表
     *
     * @param channelId       频道id
     * @param lastRefreshTime 最后一次刷新时间
     * @param refreshMode     刷新的方式 下拉 上拉
     * @return 列表
     */
    public Observable<TouTiaoNewsVideoListBean> getVideoList(String channelId, long lastRefreshTime, String refreshMode) {
        return touTiaoApiService.getVideoList(0, channelId, 1, 1, 20, System.currentTimeMillis() / 1000, "main_tab", lastRefreshTime,
                System.currentTimeMillis() / 1000, 39.91615696118585, 116.37871385739155, "北京", refreshMode, 29858226621L, 37717988923L, "wifi",
                "huawei", "news_article", 666, "6.66", "android");
    }

    /**
     * 获取视频播放真实地址的请求接口
     *
     * @param url pc端地址
     * @return 真实地址请求接口
     */
    public Observable<String> getVideoHtml(String url) {
        return touTiaoApiService.getVideoHtml(url);
    }


}
