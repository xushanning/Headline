package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.response.NewsDetailsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by xusn10 on 2018/2/9.
 *
 * @author xu
 */

interface TouTiaoArticleApiService {

    /**
     * 获取文章详情
     *
     * @param articleID1     文章的id
     * @param articleID2     文章的id
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
    @GET("article/content/19/1/{articleID1}/{articleID2}/1/0/")
    Observable<BaseResBean<NewsDetailsBean>> getNewsDetails(@Path("articleID1") long articleID1,
                                                            @Path("articleID2") long articleID2,
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
