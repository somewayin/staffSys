package org.staff.staffsystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.staff.staffsystem.pojo.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    Result ex(Exception exception){
        exception.printStackTrace();
        return Result.error("请求错误，请重试");
    }
}
