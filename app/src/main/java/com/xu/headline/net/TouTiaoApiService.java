package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.request.LocalChannelInfoBean;
import com.xu.headline.bean.response.CommentReplyListBean;
import com.xu.headline.bean.response.CommentReplyThemeBean;
import com.xu.headline.bean.response.VideoChannelBean;

import com.xu.headline.bean.response.CommentListBean;
import com.xu.headline.bean.response.SuggestSearchBean;
import com.xu.headline.bean.response.NewsChannelListBean;
import com.xu.headline.bean.response.TouTiaoNewsListBean;
import com.xu.headline.bean.response.authorinfo.AuthorInfoBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
     * 获取新闻频道列表
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
    @POST("article/category/get_subscribed/v4/")
    Observable<BaseResBean<NewsChannelListBean>> getNewsChannelList(@Query("iid") String iid,
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
     * @param concernID         id
     * @param refer             1
     * @param refreshReason     1
     * @param sessionRefreshIdx 5
     * @param count             20
     * @param lastBeHotTime     当前时间
     * @param lastRefreshTime   上一次刷新时间
     * @param locMode           mode
     * @param currentTime       时间
     * @param latitude          纬度
     * @param longitude         经度
     * @param city              城市
     * @param from              如何操作的？下拉，上拉？
     * @param lac               lac
     * @param cid               cid
     * @param pluginEnable      是否可用
     * @param iid               iid
     * @param deviceID          设备id
     * @param ac                ac
     * @param channel           频道
     * @param aid               aid
     * @param appName           name
     * @param versionCode       版本号
     * @param versionName       版本名称
     * @param devicePlatform    平台
     * @return Observable
     */
    @GET("api/news/feed/v74/")
    Observable<TouTiaoNewsListBean> getNewsList(@Query("list_count") int listCount,
                                                @Query("category") String category,
                                                @Query("concern_id") String concernID,
                                                @Query("refer") int refer,
                                                @Query("refresh_reason") int refreshReason,
                                                @Query("session_refresh_idx") int sessionRefreshIdx,
                                                @Query("count") int count,
                                                @Query("min_behot_time") long lastBeHotTime,
                                                @Query("last_refresh_sub_entrance_interval") long lastRefreshTime,
                                                @Query("loc_mode") int locMode,
                                                @Query("loc_time") long currentTime,
                                                @Query("latitude") double latitude,
                                                @Query("longitude") double longitude,
                                                @Query("city") String city,
                                                @Query("tt_from") String from,
                                                @Query("lac") int lac,
                                                @Query("cid") int cid,
                                                @Query("plugin_enable") int pluginEnable,
                                                @Query("iid") String iid,
                                                @Query("device_id") String deviceID,
                                                @Query("ac") String ac,
                                                @Query("channel") String channel,
                                                @Query("aid") int aid, @Query("app_name") String appName,
                                                @Query("version_code") int versionCode,
                                                @Query("version_name") String versionName,
                                                @Query("device_platform") String devicePlatform);


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
     * @param latitude       纬度
     * @param longitude      经度
     * @param groupID        g
     * @param itemID         i
     * @param aggrType       a
     * @param context        c
     * @param category       文章类型：热点、图片、新时代  之类
     * @param articlePage    第几页
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

    /**
     * 获取评论回复的主题（回复的那条评论）
     *
     * @param commentID      评论id
     * @param source         来源
     * @param iid            iid
     * @param deviceID       设备id
     * @param ac             ac
     * @param channel        频道
     * @param aid            aid
     * @param appName        appName
     * @param versionCode    code
     * @param versionName    name
     * @param devicePlatform p
     * @return observable
     */

    @GET("2/comment/v1/detail/")
    Observable<CommentReplyThemeBean> getCommentReplyTheme(@Query("comment_id") long commentID,
                                                           @Query("source") int source,
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
     * 获取评论回复的热门回复和全部回复
     *
     * @param commentID      评论id
     * @param replyCount     获取的回复数量
     * @param offset         offset
     * @param iid            iid
     * @param deviceID       设备id
     * @param ac             ac
     * @param channel        频道
     * @param aid            aid
     * @param appName        appName
     * @param versionCode    code
     * @param versionName    版本名
     * @param devicePlatform 平台
     * @return observer
     */
    @GET("2/comment/v1/reply_list/")
    Observable<CommentReplyListBean> getCommentReplyList(@Query("id") long commentID,
                                                         @Query("count") int replyCount,
                                                         @Query("offset") int offset,
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
     * 获取视频列表
     *
     * @param iid            iid
     * @param deviceID       设备id
     * @param ac             ac
     * @param channel        频道
     * @param aid            aid
     * @param appName        appName
     * @param versionCode    code
     * @param versionName    版本名
     * @param devicePlatform 平台
     * @return observer
     */
    @GET("video_api/get_category/v1/")
    Observable<BaseResBean<List<VideoChannelBean>>> getVideoChannelList(@Query("iid") String iid,
                                                                        @Query("device_id") String deviceID,
                                                                        @Query("ac") String ac,
                                                                        @Query("channel") String channel,
                                                                        @Query("aid") int aid,
                                                                        @Query("app_name") String appName,
                                                                        @Query("version_code") int versionCode,
                                                                        @Query("version_name") String versionName,
                                                                        @Query("device_platform") String devicePlatform);

    /**
     * 获取新闻推荐列表
     *
     * @param iid             iid
     * @param deviceID        设备id
     * @param ac              ac
     * @param channel         频道
     * @param aid             aid
     * @param appName         appName
     * @param versionCode     code
     * @param versionName     版本名
     * @param devicePlatform  平台
     * @param channelInfoBean 频道信息
     * @return observer
     */
    @POST("article/category/get_extra/v1/")
    Observable<BaseResBean<NewsChannelListBean>> getRecommendChannelList(@Query("iid") String iid,
                                                                         @Query("device_id") String deviceID,
                                                                         @Query("ac") String ac,
                                                                         @Query("channel") String channel,
                                                                         @Query("aid") int aid,
                                                                         @Query("app_name") String appName,
                                                                         @Query("version_code") int versionCode,
                                                                         @Query("version_name") String versionName,
                                                                         @Query("device_platform") String devicePlatform,
                                                                         @Body LocalChannelInfoBean channelInfoBean);

}
