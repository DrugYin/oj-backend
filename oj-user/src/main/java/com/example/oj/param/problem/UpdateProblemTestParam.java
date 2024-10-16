package com.example.oj.param.problem;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 云海
 * @description
 * @createDate 2024/8/1 下午3:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateProblemTestParam extends CreateProblemTestParam {

    private long id;
}
