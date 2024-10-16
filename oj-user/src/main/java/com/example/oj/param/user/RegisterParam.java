package com.example.oj.param.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/24 下午3:37
 */
@Data
public class RegisterParam {

    /**
     * 用户名 必填
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码不能为空")
    private String retryPassword;
}
