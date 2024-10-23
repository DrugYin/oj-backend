package com.creative.ojadmin.common.exception.enums;

import com.creative.ojadmin.common.exception.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午10:49
 * @description 错误编码
 */
@Getter
@AllArgsConstructor
public enum GlobalErrorCodeEnum implements IErrorCode {
    // 通用错误码
    SUCCESS(0L, "操作成功"),
    // 认证相关错误码
    LOGIN_USER_NOT_EXIST(10001L, "用户不存在"),
    LOGIN_PASSWORD_WRONG(10002L, "密码错误"),
    LOGIN_USER_NOT_LOGIN(10003L, "用户未登录"),
    LOGIN_USER_NOT_AUTHORIZED(10004L, "用户无权限"),
    LOGIN_USER_NOT_EXIST_ROLE(10005L, "用户角色不存在"),
    LOGIN_USER_NOT_EXIST_PERMISSION(10006L, "用户权限不存在"),
    FILE_EMPTY(10101L, "文件为空"),
    FILE_UPLOAD_FAIL(10102L, "文件上传失败"),
    LANGUAGE_ALREADY_EXIST(10201L, "语言已存在"),
    LANGUAGE_NOT_EXIST(10202L, "语言不存在"),
    SUBMISSION_NOT_EXIST(10301L, "提交不存在")
    ;

    private final Long code;
    private final String message;

}
