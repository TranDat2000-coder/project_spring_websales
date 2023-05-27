package com.project.quanlybanhang.common;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    int getCode();

    String getMessage();

    HttpStatus getHttpStatus();
}
