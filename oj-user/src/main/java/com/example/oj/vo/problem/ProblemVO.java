package com.example.oj.vo.problem;

import lombok.Data;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/14 下午2:30
 */
@Data
public class ProblemVO {

    /* 文章的唯一标识 */
    private long id;

    /* 文章的标题 */
    private String title;

    /* 文章的作者 */
    private String author;

    /* 用户自定义的文章标识 */
    private String customId;

    /* 文章的提交次数*/
    private long submitCount;

    /* 文章被接受的次数 */
    private long acceptCount;

    private String description;


}
