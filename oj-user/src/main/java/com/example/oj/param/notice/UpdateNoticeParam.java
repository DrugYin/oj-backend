package com.example.oj.param.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 云海
 * @description 修改公告
 * @createDate 2024/6/7 下午1:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateNoticeParam extends CreateNoticeParam {

    /**
     * 公告id
     */
    private long id;
}
