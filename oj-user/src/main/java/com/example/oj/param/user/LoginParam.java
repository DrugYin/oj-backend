package com.example.oj.param.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/24 下午3:46
 */
@Data
public class LoginParam {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    String password;
}
