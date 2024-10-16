package com.example.oj.config;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午3:28
 */
public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}

