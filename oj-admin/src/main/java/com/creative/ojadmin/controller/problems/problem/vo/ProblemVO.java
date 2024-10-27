package com.creative.ojadmin.controller.problems.problem.vo;

import lombok.Data;

/**
 * @author LiChongWei
 * @date 2024/10/26 15:57
 * @description
 */
@Data
public class ProblemVO {

    /* 题目的唯一标识 */
    private long id;

    /* 题目的标题 */
    private String title;

    /* 题目的作者 */
    private String author;

    /* 用户自定义的题目标识 */
    private String customId;

    /* 题目的提交次数*/
    private long submitCount;

    /* 题目被接受的次数 */
    private long acceptCount;

    /* 题目是否可见 */
    private boolean visible;

    /* 题目的描述 */
    private String description;

}
