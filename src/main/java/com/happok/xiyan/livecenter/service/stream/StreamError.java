package com.happok.xiyan.livecenter.service.stream;

import com.happok.xiyan.livecenter.result.ErrorInfoInterface;

/**
 * Created by xiayt on 2018/8/25/025 17:34
 */
public enum StreamError implements ErrorInfoInterface {

    MEDIA_CENTER_NOT_FOUND("450", "流媒体中心不存在"),
    MEDIA_CLIENT_NOT_FOUND("451", "流媒体客户端不存在"),
    MEDIA_STREAM_NOT_FOUND("452", "流不存在");


    StreamError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
