package com.creative.ojadmin.controller.home.notice.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author LiChongWei
 * @date 2024/10/21 19:09
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateNoticeParam extends CreateNoticeParam{

    private long id;

}
