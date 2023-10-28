package com.project.quanlybanhang.response.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;

public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int status;
    private String errorCode;
    private String message;
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        lenient = OptBoolean.FALSE
    )
    private Date timestamp = new Date();
    private T data;

    public ResponseData(){
    }

    public ResponseData<T> success(T data){
        return restResult(data, HttpStatus.OK.value(), null, "Success!");
    }

    public static <T> ResponseData<T> failed(HttpStatus httpStatus, String errorCode, String message){
        return restResult(null, httpStatus.value(), errorCode, message);
    }

    public static <T> ResponseData<T> restResult(T data, int status, String errorCode, String message){

        ResponseData<T> responseData = new ResponseData<>();
        responseData.setStatus(status);
        responseData.setErrorCode(errorCode);
        responseData.setMessage(message);
        responseData.setData(data);
        return responseData;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
