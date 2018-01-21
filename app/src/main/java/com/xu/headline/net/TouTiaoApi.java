package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.bean.SearchBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public interface TouTiaoApi {

    /**
     * 获取频道列表
     *
     * @param appKey AppId
     * @return 频道列表
     */
    @GET("channel")
    Observable<BaseResBean<List<String>>> getChannels(@Query("appkey") String appKey);

    /**
     * 获取新闻列表
     *
     * @param channelName 频道名称
     * @param start       起始位置 默认是0
     * @param num         数量 默认是10，最大是40
     * @return 新闻列表（包括详情）
     */
    @GET("get")
    Observable<BaseResBean<NewsListBean>> getNewsList(@Query("channel") String channelName, @Query("start") int start, @Query("num") int num, @Query("appkey") String appKey);

    /**
     * 获取搜索结果
     *
     * @param keyWord 关键词
     * @param appKey  appKey
     * @return 搜索结果
     */

    @GET("search")
    Observable<BaseResBean<SearchBean>> getSearchList(@Query("keyword") String keyWord, @Query("appkey") String appKey);

}
