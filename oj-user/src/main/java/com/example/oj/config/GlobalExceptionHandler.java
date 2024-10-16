package com.example.oj.config;

import cn.dev33.satoken.exception.NotLoginException;
import com.example.oj.common.model.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/25 下午1:58
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理参数校验异常
     *
     * @param ex /
     * @return /
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String defaultMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.fail(500, defaultMessage);
    }

    @ExceptionHandler(NotLoginException.class)
    public Result<?> handleNotLoginException(NotLoginException ex) {
        return Result.fail(401, "你还未登录，请先登录");
    }

    /**
     * 兜底异常处理
     *
     * @param ex /
     * @return /
     */
    @ExceptionHandler(Exception.class)
    public Result<?> handleOtherExceptions(Exception ex) {
        return Result.fail(500, ex.getMessage());
    }
}
