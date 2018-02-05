package com.xu.headline.base;

import java.io.Serializable;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xu
 */

public class BaseResBean<T> implements Serializable {

    private String message;
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
