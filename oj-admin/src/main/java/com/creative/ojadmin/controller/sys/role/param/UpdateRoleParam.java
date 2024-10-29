package com.creative.ojadmin.controller.sys.role.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/29 18:38
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateRoleParam extends CreateRoleParam{

    private long id;

}
