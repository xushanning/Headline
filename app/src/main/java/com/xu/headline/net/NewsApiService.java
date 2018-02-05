package com.xu.headline.net;

import com.xu.headline.base.BaseShowApiResBean;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.bean.NewsChannelListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/25.
 *
 * @author xu
 *         showApi接口
 */

public interface NewsApiService {

    /**
     * 获取频道信息
     *
     * @param appID     appID
     * @param appSecret 安全码
     * @return 频道的observable
     */
    @GET("109-34")
    Observable<BaseShowApiResBean<NewsChannelListBean>> getChannelList(@Query("showapi_appid") String appID,
                                                                       @Query("showapi_sign") String appSecret);

    /**
     * @param appID     appID
     * @param appSecret 安全码
     * @param channelId 频道id
     * @param page      第几页
     * @return 新闻列表的observable
     */
    @GET("109-35")
    Observable<BaseShowApiResBean<NewsListBean>> getNewsList(@Query("showapi_appid") String appID,
                                                             @Query("showapi_sign") String appSecret,
                                                             @Query("channelId") String channelId,
                                                             @Query("page") int page);


}
