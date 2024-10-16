package com.creative.ojadmin.common.exception;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午10:46
 * @description 错误码接口
 */
public interface IErrorCode {

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    Long getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();

}
