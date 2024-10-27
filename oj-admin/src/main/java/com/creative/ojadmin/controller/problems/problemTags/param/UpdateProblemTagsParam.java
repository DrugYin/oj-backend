package com.creative.ojadmin.controller.problems.problemTags.param;

import lombok.Data;

import java.util.List;

/**
 * @author LiChongWei
 * @date 2024/10/27 19:18
 * @description
 */
@Data
public class UpdateProblemTagsParam {

    private long problemId;

    private List<Long> tagIds;

}
