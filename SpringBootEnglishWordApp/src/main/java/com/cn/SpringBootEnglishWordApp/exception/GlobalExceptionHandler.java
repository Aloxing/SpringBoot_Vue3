package com.cn.SpringBootEnglishWordApp.exception;

import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("出问题了，请联系管理员");
    }
}
