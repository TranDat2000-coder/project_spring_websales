package com.project.quanlybanhang.config.exception;

import com.project.quanlybanhang.common.ErrorCode;
import com.project.quanlybanhang.exception.BusinessException;
import com.project.quanlybanhang.response.common.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@ResponseBody
@ControllerAdvice
public class HandlerExceptionAdvice{

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException e) {

        StringWriter stack = new StringWriter();
        e.printStackTrace(new PrintWriter(stack));
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(new ResponseData().failed(HttpStatus.BAD_REQUEST, e.getErrorCode(),  e.getMessage()));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleRequestException(MethodArgumentNotValidException e, HttpServletRequest request){

        List<String> errors = new ArrayList<>();
        for(ObjectError error : e.getBindingResult().getAllErrors()){
            errors.add(error.getDefaultMessage());
        }
        return defHandler(HttpStatus.BAD_REQUEST, ErrorCode.INPUT_INVALID.getErrorCode(), errors.toString());
    }

    public ResponseEntity<Object> defHandler(HttpStatus status, String errorCode, String message){
        return new ResponseEntity(ResponseData.failed(status, errorCode, message), status);
    }

}
