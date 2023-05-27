package com.project.quanlybanhang.config.exception;

import com.project.quanlybanhang.exception.BusinessException;
import com.project.quanlybanhang.model.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice
public class HandlerExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleException(BusinessException e){

        StringWriter stack = new StringWriter();
        e.printStackTrace(new PrintWriter(stack));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseData().error(e.getCode(), e.getMessage()));
    }
}
