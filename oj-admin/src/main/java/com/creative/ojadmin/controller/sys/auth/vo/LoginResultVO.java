package com.creative.ojadmin.controller.sys.auth.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午11:08
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResultVO {

    private String account;

    private String token;

    private String avatar;

}
