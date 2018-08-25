package com.happok.xiyan.livecenter.service.channel;

import com.happok.xiyan.livecenter.result.ErrorInfoInterface;

public class ChannelError implements ErrorInfoInterface {

    private String code;
    private String message;

    ChannelError(String code, String message) {
        this.code = code;
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
