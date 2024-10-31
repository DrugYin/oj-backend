package com.creative.ojadmin.controller.sys.user.param;

import com.creative.ojadmin.common.pojo.PageQueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/29 19:40
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryUserParam extends PageQueryParam {

    private String searchStr;

}
