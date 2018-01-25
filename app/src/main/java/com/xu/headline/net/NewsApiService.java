package com.xu.headline.net;

import com.xu.headline.base.BaseShowApiResBean;
import com.xu.headline.bean.ShowApiChannelListBean;

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
     * @return
     */
    @GET("109-34")
    Observable<BaseShowApiResBean<ShowApiChannelListBean>> getChannelList(@Query("appID") String appID,
                                                                          @Query("appSecret") String appSecret);

}
