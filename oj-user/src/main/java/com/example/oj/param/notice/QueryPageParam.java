package com.example.oj.param.notice;

import com.example.oj.common.model.PageQueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/7 下午2:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryPageParam extends PageQueryParam {

    /**
     * 存储待搜索的字符串。
     */
    private String searchStr;

    private String searchProblemValue;

    private String searchUserValue;
}
