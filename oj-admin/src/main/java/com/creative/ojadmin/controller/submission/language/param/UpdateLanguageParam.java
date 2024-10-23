package com.creative.ojadmin.controller.submission.language.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/23 11:15
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateLanguageParam extends CreateLanguageParam {

    private long id;

}
