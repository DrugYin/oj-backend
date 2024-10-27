package com.creative.ojadmin.controller.problems.problem.param;

import com.creative.ojadmin.common.pojo.PageQueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/26 15:58
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryProblemParam extends PageQueryParam {

    private String searchStr;

}
