package com.xu.headline.base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/25.
 */

public class BaseShowApiResBean<T> implements Serializable {
    @SerializedName("showapi_res_code")
    private int resCode;
    @SerializedName("showapi_res_error")
    private String resError;
    @SerializedName("showapi_res_body")
    private T resBody;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResError() {
        return resError;
    }

    public void setResError(String resError) {
        this.resError = resError;
    }

    public T getResBody() {
        return resBody;
    }

    public void setResBody(T resBody) {
        this.resBody = resBody;
    }
}
