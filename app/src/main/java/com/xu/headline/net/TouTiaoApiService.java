package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.AuthorInfoBean;
import com.xu.headline.bean.CommentListBean;
import com.xu.headline.bean.SuggestSearchBean;
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

    /**
     * 获取评论列表
     *
     * @param groupID        g
     * @param itemID         i
     * @param aggrType       a
     * @param count          c
     * @param offset         o
     * @param tabIndex       t
     * @param fold           f
     * @param iid            id
     * @param deviceID       d
     * @param ac             a
     * @param channel        c
     * @param aid            a
     * @param appName        a
     * @param versionCode    1
     * @param versionName    2
     * @param devicePlatform d
     * @return Observable
     */
    @GET("article/v2/tab_comments/")
    Observable<CommentListBean> getCommentList(@Query("group_id") long groupID,
                                               @Query("item_id") long itemID,
                                               @Query("aggr_type") int aggrType,
                                               @Query("count") int count,
                                               @Query("offset") int offset,
                                               @Query("tab_index") int tabIndex,
                                               @Query("fold") int fold,
                                               @Query("iid") String iid,
                                               @Query("device_id") String deviceID,
                                               @Query("ac") String ac,
                                               @Query("channel") String channel,
                                               @Query("aid") int aid,
                                               @Query("app_name") String appName,
                                               @Query("version_code") int versionCode,
                                               @Query("version_name") String versionName,
                                               @Query("device_platform") String devicePlatform
    );

    /**
     * 获取头条号作者的信息
     *
     * @param latitude 纬度
     * @param longitude 经度
     * @param groupID g
     * @param itemID i
     * @param aggrType a
     * @param context c
     * @param category 文章类型：热点、图片、新时代  之类
     * @param articlePage 第几页
     * @param iid            id
     * @param deviceID       d
     * @param ac             a
     * @param channel        c
     * @param aid            a
     * @param appName        a
     * @param versionCode    1
     * @param versionName    2
     * @param devicePlatform d
     * @return Observable
     */

    @GET("2/article/information/v24/")
    Observable<BaseResBean<AuthorInfoBean>> getAuthorInfo(@Query("latitude") double latitude,
                                                          @Query("longitude") double longitude,
                                                          @Query("group_id") long groupID,
                                                          @Query("item_id") long itemID,
                                                          @Query("aggr_type") int aggrType,
                                                          @Query("context") int context,
                                                          @Query("from_category") String category,
                                                          @Query("article_page") int articlePage,
                                                          @Query("iid") String iid,
                                                          @Query("device_id") String deviceID,
                                                          @Query("ac") String ac,
                                                          @Query("channel") String channel,
                                                          @Query("aid") int aid,
                                                          @Query("app_name") String appName,
                                                          @Query("version_code") int versionCode,
                                                          @Query("version_name") String versionName,
                                                          @Query("device_platform") String devicePlatform);


}
