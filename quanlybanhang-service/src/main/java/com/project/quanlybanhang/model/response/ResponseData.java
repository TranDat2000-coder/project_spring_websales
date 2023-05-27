package com.project.quanlybanhang.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.apache.logging.log4j.ThreadContext;

import java.io.Serializable;
import java.util.Date;

public class ResponseData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        lenient = OptBoolean.FALSE
    )
    private Date timestamp = new Date();
    private T data;

    public ResponseData(){}

    public ResponseData<T> success(T data){
        this.code = 200;
        this.message = "Success!";
        this.data = data;
        return this;
    }

    public ResponseData<T> error(int code, String message){
        this.code = code;
        this.message = message;
        return this;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss",
            lenient = OptBoolean.FALSE
    )
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
