package com.example.oj.param.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author LiChongWei
 * @date 2024/10/31 10:39
 * @description
 */
@Data
public class ResetPasswordParam {

    private long userId;

    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;

    @NotBlank(message = "新密码不能为空")
    private String newPassword;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;

}
