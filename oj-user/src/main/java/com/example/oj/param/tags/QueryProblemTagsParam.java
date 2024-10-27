package com.example.oj.param.tags;

import lombok.Data;

import java.util.List;

/**
 * @author LiChongWei
 * @date 2024/10/26 23:08
 * @description
 */
@Data
public class QueryProblemTagsParam {

    private List<Long> problemIds;

}
