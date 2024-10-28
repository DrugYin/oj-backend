package com.creative.ojadmin.controller.problems.problem.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/28 18:03
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateProblemParam extends CreateProblemParam{

    private long id;

}
