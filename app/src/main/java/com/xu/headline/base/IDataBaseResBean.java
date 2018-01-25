package com.xu.headline.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xusn10 on 2018/1/25.
 *
 * @author xu
 */

public class IDataBaseResBean<T> {
    /**
     * 是否有下一页
     */
    private boolean hasNext;
    /**
     * 返回的状态码  0000为正常
     */
    @SerializedName("retcode")
    private String retCode;
    /**
     * 本次查询的api名
     */
    private String appCode;
    /**
     * 本次查询的api类型
     */
    private String dataType;
    /**
     * 翻页值
     */
    private String pageToken;
    /**
     * 返回的数据
     */
    private T data;

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPageToken() {
        return pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
