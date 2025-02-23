package com.example.back_springboot.exception;

/*
* 全局异常处理
* */

import com.example.back_springboot.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.example.controller") // 标识全局异常处理的类
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody // 标明返回json串
    public Result exception(Exception e) {
        e.printStackTrace();
        return Result.error();
    }

    // 自定义异常，TODO：目前有问题没有发现
    @ExceptionHandler(CustomException.class)
    @ResponseBody // 标明返回json串
    public Result exception(CustomException e) {
        return Result.error(e.getCode(), e.getMessage());
    }
}
