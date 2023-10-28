package com.project.quanlybanhang.exception;

import com.project.quanlybanhang.common.ErrorCode;

public class BusinessException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String detailMessage;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.detailMessage = "";
    }

    public String getErrorCode(){
        return this.errorCode.getErrorCode();
    }

    public String getMessage(){
        return this.errorCode.getMessage();
    }
}
