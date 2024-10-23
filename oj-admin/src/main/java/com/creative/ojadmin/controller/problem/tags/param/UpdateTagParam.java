package com.creative.ojadmin.controller.problem.tags.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/23 19:02
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateTagParam extends CreateTagParam{

    private long id;

}
