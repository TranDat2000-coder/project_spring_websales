package com.project.quanlybanhang.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private String message;
    private String error;
    private T data;

    public static <T> ResponseData<T> ok(T data){
        return restResult(data, HttpStatus.OK.value(), (String)null, (String)null);
    }

    private static <T> ResponseData<T> restResult(T data, int status, String message, String error){
        ResponseData<T> apiResult = new ResponseData<>();
        apiResult.setStatus(status);
        apiResult.setMessage(message);
        apiResult.setError(error);
        apiResult.setData(data);
        return apiResult;
    }
}
