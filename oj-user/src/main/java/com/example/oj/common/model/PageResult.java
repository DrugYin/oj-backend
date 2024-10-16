package com.example.oj.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author 云海
 * @description 分页查询结果
 * @createDate 2024/6/7 下午2:10
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    /**
     * 总记录数
     */
    private long total;

    /**
     * 结果数据
     */
    private List<T> rows;
}
