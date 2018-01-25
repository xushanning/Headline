package com.xu.headline.net;

import com.xu.headline.base.IDataBaseResBean;
import com.xu.headline.bean.IDataNewsBean;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xusn10 on 2018/1/25.
 *
 * @author xu
 *         IData数据service
 */

public interface IDataApiService {
    /**
     * 获取新闻的结果
     *
     * @param page      翻页值
     * @param apiKey    秘钥
     * @param channelId 频道id
     * @return observable
     */

    @GET("news/toutiao")
    Observable<IDataBaseResBean<List<IDataNewsBean>>> getNewsData(@Query("pageToken") int page,
                                                                  @Query("catid") String channelId,
                                                                  @Query("apikey") String apiKey);

    /**
     * 获取关键词搜索的结果
     *
     * @param page    翻页值
     * @param apiKey  秘钥
     * @param keyWord 关键词
     * @return observable
     */
    @GET("news/toutiao")
    Observable<IDataBaseResBean<List<IDataNewsBean>>> getSearchResult(@Query("pageToken") int page,
                                                                      @Query("kw") String keyWord,
                                                                      @Query("apikey") String apiKey);

    /**
     * 获取某头条号下的文章
     *
     * @param page   翻页值
     * @param apiKey 秘钥
     * @param id     公众号的id
     *               * @return observable
     */
    Observable<IDataBaseResBean<List<IDataNewsBean>>> getPublicData(@Query("pageToken") int page,
                                                                    @Query("apikey") String apiKey,
                                                                    @Query("uid") String id);
}
