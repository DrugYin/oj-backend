package com.example.oj.param.problem;

import com.example.oj.param.notice.QueryPageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/14 下午2:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryProblemParam extends QueryPageParam {

    /**
     * 搜索字符串
     */
    private String searchStr;
}
