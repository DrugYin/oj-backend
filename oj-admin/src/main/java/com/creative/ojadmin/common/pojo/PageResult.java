package com.creative.ojadmin.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author LiChongWei
 * @date 2024/10/26 15:53
 * @description
 */
@AllArgsConstructor
@Data
public class PageResult<T> {

    private long total;

    private List<T> rows;

}
