package com.example.oj.param.tags;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午6:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateTagParam extends CreateTagParam {

    private Long id;

}
