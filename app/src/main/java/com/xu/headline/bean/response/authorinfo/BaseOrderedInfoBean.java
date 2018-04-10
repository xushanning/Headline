package com.xu.headline.bean.response.authorinfo;

/**
 * Created by xusn10 on 2018/2/24.
 *
 * @author xu
 */

public class BaseOrderedInfoBean<T> {
    private String name;
    private T data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
