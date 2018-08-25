package com.happok.xiyan.livecenter.result;

/**
 * @author xiayt
 * 找不到结果异常捕获
 */
public class NotFoundException extends Exception {

    private ErrorInfoInterface errorInfo;

    public NotFoundException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}