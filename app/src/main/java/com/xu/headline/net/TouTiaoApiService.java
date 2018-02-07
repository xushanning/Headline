package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.base.SuggestSearchBean;
import com.xu.headline.bean.NewsSuggestChannelBean;
import com.xu.headline.bean.TouTiaoNewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xusn10 on 2018/2/5.
 *
 * @author xu
 */

public interface TouTiaoApiService {

    /**
     * 获取今日头条搜索推荐
     *
     * @param flag           flag
     * @param suggestParams  s
     * @param recomCnt       r
     * @param iid            id
     * @param deviceID       d
     * @param ac             a
     * @param channel        c
     * @param aid            a
     * @param appName        a
     * @param versionCode    1
     * @param versionName    2
     * @param devicePlatform d
     * @return observable
     */

    @GET("search/suggest/homepage_suggest/")
    Observable<BaseResBean<SuggestSearchBean>> getSuggestSearch(@Query("flag") int flag,
                                                                @Query("suggest_params") String suggestParams,
                                                                @Query("recom_cnt") int recomCnt,
                                                                @Query("iid") String iid,
                                                                @Query("device_id") String deviceID,
                                                                @Query("ac") String ac,
                                                                @Query("channel") String channel,
                                                                @Query("aid") int aid,
                                                                @Query("app_name") String appName,
                                                                @Query("version_code") int versionCode,
                                                                @Query("version_name") String versionName,
                                                                @Query("device_platform") String devicePlatform);

    /**
     * 获取频道名称
     *
     * @param iid            id
     * @param deviceID       d
     * @param ac             a
     * @param channel        c
     * @param aid            a
     * @param appName        a
     * @param versionCode    1
     * @param versionName    2
     * @param devicePlatform d
     * @return observable
     */
    @GET("article/category/get_subscribed/v2/")
    Observable<BaseResBean<NewsSuggestChannelBean>> getSuggestChannel(@Query("iid") String iid,
                                                                      @Query("device_id") String deviceID,
                                                                      @Query("ac") String ac,
                                                                      @Query("channel") String channel,
                                                                      @Query("aid") int aid,
                                                                      @Query("app_name") String appName,
                                                                      @Query("version_code") int versionCode,
                                                                      @Query("version_name") String versionName,
                                                                      @Query("device_platform") String devicePlatform);

    /**
     * 获取新闻列表
     *
     * @param listCount         20
     * @param category          新闻类型
     * @param refer             1
     * @param refreshReason     1
     * @param sessionRefreshIdx 5
     * @param count             20
     * @param currentTime       当前时间
     * @param lastRefreshTime   上一次刷新时间
     * @param iid
     * @return observable
     */
    @GET("api/news/feed/v74/")
    Observable<TouTiaoNewsListBean> getNewsList(@Query("list_count") int listCount,
                                                @Query("category") String category,
                                                @Query("refer") int refer,
                                                @Query("refresh_reason") int refreshReason,
                                                @Query("session_refresh_idx") int sessionRefreshIdx,
                                                @Query("count") int count,
                                                @Query("min_behot_time") long lastRefreshTime,
                                                @Query("last_refresh_sub_entrance_interval") long currentTime,
                                                @Query("iid") String iid);
}
