package com.example.oj.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    /**
     * 自定义请求状态码，0成功，其他失败。
     */
    private Integer code;
    /**
     * 请求结果信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 请求成功，返回数据
     *
     * @param data /
     * @param <T>  /
     * @return /
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(0, "请求成功", data);
    }

    /**
     * 请求成功，返回数据
     *
     * @param message /
     * @param data    /
     * @param <T>     /
     * @return /
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(0, message, data);
    }

    /**
     * 请求失败
     *
     * @param code    /
     * @param message /
     * @param <T>     /
     * @return /
     */
    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }
}
