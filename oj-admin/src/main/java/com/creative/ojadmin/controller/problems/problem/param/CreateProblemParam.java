package com.creative.ojadmin.controller.problems.problem.param;

import lombok.Data;

/**
 * @author LiChongWei
 * @date 2024/10/28 18:02
 * @description
 */
@Data
public class CreateProblemParam {
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
     * 测试点数据
     */
    private String testData;

    /**
     * 限制时间，规定解决问题的最大允许时间。
     */
    private Integer limitTime;

    /**
     * 限制内存，规定解决问题的最大允许内存。
     */
    private Integer limitMemory;
}
