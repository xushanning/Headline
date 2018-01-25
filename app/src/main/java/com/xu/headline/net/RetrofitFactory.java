package com.xu.headline.net;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class RetrofitFactory {

    private static final long TIME_OUT = 30;

    private static OkHttpClient getOkHttpClient() {
        //缓存容量
//        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
//        //缓存路径
//        String cacheFile = context.getCacheDir() + "/http";
//        Cache cache = new Cache(new File(cacheFile), SIZE_OF_CACHE);
        return new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                //    .cache(cache)
                .addInterceptor(requestInterceptor)
                .addInterceptor(responseInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(headerInterceptor)
                .build();
    }

    /**
     * 响应log拦截器
     */
    private static HttpLoggingInterceptor responseInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String s) {
            if (s.length() >= 1) {
                String begin = s.substring(0, 1);
                if ("{".equals(begin)) {
                    //只打印json
                    Logger.d("响应的Json" + s);
                }
            }

        }
    });

    /**
     * 请求信息拦截器
     */
    private static Interceptor requestInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {
            final Request request = chain.request();
            //请求地址
            Logger.d("请求地址:" + request.url());
            return chain.proceed(request);
        }
    };
    /**
     * 统一的请求header
     */
    private static Interceptor headerInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();

            return chain.proceed(builder.build());
        }
    };

    /**
     * 获取TouTiaoApi
     *
     * @return TouTiaoApiService
     */
    public static TouTiaoApiService getTouTiaoApi() {
        return new Retrofit
                .Builder()
                .baseUrl(HttpConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(TouTiaoApiService.class);
    }

    public static IDataApiService getIDataApi() {
        return new Retrofit
                .Builder()
                .baseUrl(HttpConstants.BASE_IDATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(IDataApiService.class);
    }

    public static NewsApiService getNewsApi() {
        return new Retrofit
                .Builder()
                .baseUrl(HttpConstants.SHOW_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build()
                .create(NewsApiService.class);
    }
}