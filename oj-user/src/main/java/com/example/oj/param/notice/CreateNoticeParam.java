package com.example.oj.param.notice;

import lombok.Data;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/6 下午4:35
 */
@Data
public class CreateNoticeParam {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
}
