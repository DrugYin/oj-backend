package com.creative.ojadmin.controller.sys.user.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author LiChongWei
 * @date 2024/10/30 13:52
 * @description
 */
@Data
public class UpdateUserBaseInfoParam {

    private long userId;

    private String account;

    @NotNull(message = "用户名不能为空")
    private String nickname;

}
