package com.creative.ojadmin.controller.auth.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/14 下午6:41
 */
@Data
public class PasswordLoginParam {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
