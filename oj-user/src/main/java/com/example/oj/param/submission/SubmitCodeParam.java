package com.example.oj.param.submission;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/26 下午2:07
 */
@Data
public class SubmitCodeParam {

    @NotNull(message = "题目id不能为空")
    private long problemId;

    @NotBlank(message = "代码不能为空")
    private String code;

    @NotNull(message = "language字段不能为null")
    private int language;

}
