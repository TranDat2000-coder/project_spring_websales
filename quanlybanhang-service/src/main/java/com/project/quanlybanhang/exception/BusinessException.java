package com.project.quanlybanhang.exception;

import com.project.quanlybanhang.common.BaseErrorCode;

public class BusinessException extends RuntimeException {

    private final BaseErrorCode errorCode;
    private final String detailMessage;

//    private Object[] args;

    public BusinessException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
        this.detailMessage = "";
    }

//    public BusinessException(BaseErrorCode errorCode, Object... params){
//        this.errorCode = errorCode;
//        this.args = params;
//        this.detailMessage = getMessage();
//    }
//
//    public BusinessException(String message, Throwable cause, BaseErrorCode errorCode){
//        super(message, cause);
//        this.errorCode = errorCode;
//        this.detailMessage = message;
//    }

//    public Object[] getArgs(){
//        return this.args;
//    }

    public int getCode(){
        return this.errorCode.getCode();
    }

    public String getMessage(){
        return this.errorCode.getMessage();
    }
}
