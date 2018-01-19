package com.xu.headline.base;

import java.io.Serializable;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xu
 */

public class BaseResBean<T> implements Serializable {

    private String status;
    private String msg;
    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
