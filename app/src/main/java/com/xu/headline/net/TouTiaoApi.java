package com.xu.headline.net;

import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.ChannelsBean;

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
     * @param appID    AppId
     * @param mySecret 密码
     * @return
     */
    @GET("109-34")
    Observable<BaseResBean<ChannelsBean>> getChannels(@Query("showapi_appid") String appID, @Query("showapi_sign") String mySecret);
}
