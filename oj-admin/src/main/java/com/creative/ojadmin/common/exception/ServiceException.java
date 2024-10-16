package com.creative.ojadmin.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午10:43
 * @description 自定义业务逻辑异常类
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException{
    /**
     * 错误码
     */
    private Long code;

    /**
     * 错误信息
     */
    private String message;

    public ServiceException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }

    public ServiceException(IErrorCode iErrorCode, String message) {
        this.code = iErrorCode.getCode();
        this.message = message;
    }

}
