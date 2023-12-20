package com.project.quanlybanhang.common;

public enum ErrorCode {

    UNAUTHORIZED("401", "Your access rights have expired, please re-authenticate"),
    INPUT_INVALID("203", "Input invalid"),
    ROLE_EXITS("501", "Role already exists"),
    USERNAME_EXITS("502", "Username already exists"),
    DATA_NOT_EXITS("503", "Data does not exist"),
    INPUT_FILE_INVALID("504", "Sorry! Filename contains invalid path sequence"),
    FILE_NOT_FOUND("505", "No valid file found")
    ;

    private String errorCode;
    private String message;

    ErrorCode(String errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
