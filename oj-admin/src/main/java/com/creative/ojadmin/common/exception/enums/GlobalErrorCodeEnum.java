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
    USERNAME_ALREADY_EXIST(10007L, "账号已存在"),
    FILE_EMPTY(10101L, "文件为空"),
    FILE_UPLOAD_FAIL(10102L, "文件上传失败"),
    LANGUAGE_ALREADY_EXIST(10201L, "语言已存在"),
    LANGUAGE_NOT_EXIST(10202L, "语言不存在"),
    SUBMISSION_NOT_EXIST(10301L, "提交不存在"),
    TAG_NOT_EXIST(10401L, "标签不存在"),
    TAG_ALREADY_EXIST(10402L, "标签已存在"),
    PROBLEM_NOT_EXIST(10501L, "题目不存在"),
    PROBLEM_ALREADY_EXIST(10502L, "题目已存在"),
    ROLE_NOT_EXIST(10601L, "角色不存在"),
    ROLE_ALREADY_EXIST(10602L, "角色已存在"),
    ROLE_CODE_ALREADY_EXIST(10603L, "角色编码已存在"),
    ROLE_ADMIN_CANNOT_DELETE(10604L, "超级管理员角色不可删除"),
    ROLE_ADMIN_CANNOT_SET(10605L, "超级管理员角色不可修改");
    ;

    private final Long code;
    private final String message;

}
