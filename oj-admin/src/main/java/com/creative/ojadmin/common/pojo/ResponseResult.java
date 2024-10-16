package com.creative.ojadmin.common.pojo;

import com.creative.ojadmin.common.exception.IErrorCode;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import lombok.Data;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午10:35
 * @description 通用接口返回结果包装
 */
@Data
public class ResponseResult<T> {

    private long code;

    private String message;

    private T data;

    public static <T> ResponseResult<T> success(long code, String message, T data) {
        return new ResponseResult<>() {{
            setCode(code);
            setMessage(message);
            setData(data);
        }};
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return success(GlobalErrorCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return success(GlobalErrorCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> fail(long code, String message) {
        return success(code, message, null);
    }

    public static <T> ResponseResult<T> fail(IErrorCode iErrorCode) {
        return success(iErrorCode.getCode(), iErrorCode.getMessage(), null);
    }

    public static <T> ResponseResult<T> fail(IErrorCode iErrorCode, String message) {
        return success(iErrorCode.getCode(), message, null);
    }


}
