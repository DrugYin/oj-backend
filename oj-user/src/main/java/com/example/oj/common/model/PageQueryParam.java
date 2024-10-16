package com.example.oj.common.model;

import lombok.Data;

/**
 * @author 云海
 * @description 通用分页查询参数
 * @createDate 2024/6/7 下午2:12
 */
@Data
public class PageQueryParam {

    /**
     * 当前页码
     */
    private long page;

    /**
     * 每页容量
     */
    private long pageSize;
}
