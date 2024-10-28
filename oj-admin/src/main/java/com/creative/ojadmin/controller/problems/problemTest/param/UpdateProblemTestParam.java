package com.creative.ojadmin.controller.problems.problemTest.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author LiChongWei
 * @date 2024/10/28 18:17
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProblemTestParam extends CreateProblemTestParam {

    private Long id;

}
