package com.creative.ojadmin.common.handler;

import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.pojo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiChongWei
 * @date 2024/10/16 14:12
 * @description 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常类的错误处理
     * @param e /
     * @return /
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseResult<?> exception(ServiceException e) {
        log.error("全局异常处理，错误信息为：{}", e.getMessage(), e);
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult<?> exception(Exception e) {
        log.error("全局异常处理，错误信息为：{}", e.getMessage(), e);
        return ResponseResult.fail(500L, "系统异常");
    }

}
