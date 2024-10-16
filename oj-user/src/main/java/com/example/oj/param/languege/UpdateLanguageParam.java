package com.example.oj.param.languege;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午7:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateLanguageParam extends CreateLanguageParam {

    private long id;

}
