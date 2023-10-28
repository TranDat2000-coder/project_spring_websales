package com.project.quanlybanhang.common;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    String getErrorCode();

    String getMessage();

    HttpStatus getHttpStatus();
}
