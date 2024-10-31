package com.creative.ojadmin.controller.sys.role.param;

import lombok.Data;

import java.util.List;

/**
 * @author LiChongWei
 * @date 2024/10/30 13:12
 * @description
 */
@Data
public class UpdateUserRoleParam {

    private Long userId;

    private List<Long> roleIds;

}
