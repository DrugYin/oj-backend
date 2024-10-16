package com.example.oj.vo.tags;

import com.example.oj.common.model.PageQueryParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午7:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TagPageQueryParam extends PageQueryParam {

    private String searchStr;

}
