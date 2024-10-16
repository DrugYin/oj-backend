package com.example.oj.param.problem;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/14 下午2:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateProblemParam extends CreateProblemParam {
    private long id;
}
