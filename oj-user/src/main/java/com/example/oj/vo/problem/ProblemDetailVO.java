package com.example.oj.vo.problem;

import lombok.Data;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/19 下午4:09
 */
@Data
public class ProblemDetailVO {
    /**
     * 问题ID，用于唯一标识一个问题。
     */
    private Long id;
    /**
     * 问题标题，用于描述问题的核心内容。
     */
    private String title;

    /**
     * 问题的作者，用于标识问题的创建者。
     */
    private String author;

    /**
     * 自定义问题ID，用于唯一标识一个问题。
     */
    private String customId;

    /**
     * 问题的描述，详细说明问题的要求和背景。
     */
    private String description;

    /**
     * 输入描述，详细说明问题的输入格式和要求。
     */
    private String inputDescription;

    /**
     * 输出描述，详细说明问题的输出格式和要求。
     */
    private String outputDescription;

    /**
     * 测试样例，提供示例输入和输出，用于验证解法的正确性。
     */
    private String testSample;

    /**
     * 限制时间，规定解决问题的最大允许时间。
     */
    private Integer limitTime;

    /**
     * 限制内存，规定解决问题的最大允许内存。
     */
    private Integer limitMemory;
}
