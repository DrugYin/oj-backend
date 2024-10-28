package com.creative.ojadmin.controller.sys.role.param;

import com.creative.ojadmin.common.pojo.PageQueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/28 19:43
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryRoleParam extends PageQueryParam {

    private String searchStr;

}
