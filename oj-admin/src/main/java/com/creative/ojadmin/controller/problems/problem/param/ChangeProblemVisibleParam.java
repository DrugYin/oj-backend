package com.creative.ojadmin.controller.problems.problem.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/26 16:41
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ChangeProblemVisibleParam extends DeleteProblemParam {

    private boolean visible;

}
