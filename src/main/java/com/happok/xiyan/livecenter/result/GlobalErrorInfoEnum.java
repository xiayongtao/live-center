package com.happok.xiyan.livecenter.result;

public enum GlobalErrorInfoEnum implements ErrorInfoInterface {

    SUCCESS("200", "success"),
    NOT_FOUND("404", "service not found");

    private String code;

    private String message;

    GlobalErrorInfoEnum(String code, String message) {
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
