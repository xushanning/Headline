package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.base.SuggestSearchBean;
import com.xu.headline.bean.NewsSuggestChaanelBean;

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
     * @return
     */

    @GET("search/suggest/homepage_suggest")
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
     */
    @GET("article/category/get_subscribed/v2")
    Observable<BaseResBean<NewsSuggestChaanelBean>> getSuggestChannel(@Query("iid") String iid,
                                                                      @Query("device_id") String deviceID,
                                                                      @Query("ac") String ac,
                                                                      @Query("channel") String channel,
                                                                      @Query("aid") int aid,
                                                                      @Query("app_name") String appName,
                                                                      @Query("version_code") int versionCode,
                                                                      @Query("version_name") String versionName,
                                                                      @Query("device_platform") String devicePlatform);


}
