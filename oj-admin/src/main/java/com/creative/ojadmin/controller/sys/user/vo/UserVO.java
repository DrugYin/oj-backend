package com.creative.ojadmin.controller.sys.user.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author LiChongWei
 * @date 2024/10/29 19:36
 * @description
 */
@Data
public class UserVO {

    private Long id;

    private String account;

    private String nickname;

    private String avatar;

    private LocalDate createTime;

}
