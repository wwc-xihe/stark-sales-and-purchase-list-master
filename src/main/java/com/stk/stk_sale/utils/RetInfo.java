package com.stk.stk_sale.utils;

import cn.hutool.json.JSONUtil;

import java.io.Serializable;

public class RetInfo<T> implements Serializable {
    private static final long serialVersionUID = 3727716032001744456L;

    public Integer code;
    public String msg;
    public T data;

    public RetInfo() {
    }

    public RetInfo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RetInfo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //通用成功
    public static RetInfo success() {
        return new RetInfo(20000, "成功");
    }

    public static RetInfo success(Object data) {
        return new RetInfo(20000, "成功", data);
    }

    public static RetInfo success(String msg, Object data) {
        return new RetInfo(20000, msg, data);
    }

    //通用失败
    public static RetInfo fail() {
        return new RetInfo(50000, "执行失败");
    }

    public static RetInfo fail(Object data) {
        return new RetInfo(50000, "失败", data);
    }

    public static RetInfo fail(String msg, Object data) {
        return new RetInfo(50000, msg, data);
    }

    // 权限问题
    public static RetInfo jurisdiction(String msg, Object data) {
        return new RetInfo(403, msg, data);
    }

    //通用token失效
    public static RetInfo isFailure() {
        return new RetInfo(1001, "会话超时,请重新登录");
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }

}