package com.creative.ojadmin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 题目信息表
 * @TableName sys_problem
 */
@TableName(value ="sys_problem")
@Data
public class SysProblemDO implements Serializable {
    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 题目名称
     */
    @TableField(value = "title")
    private String title;

    /**
     * 作者
     */
    @TableField(value = "author")
    private String author;

    /**
     * 自定义编号
     */
    @TableField(value = "custom_id")
    private String customId;

    /**
     * 题目描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 输入描述
     */
    @TableField(value = "input_description")
    private String inputDescription;

    /**
     * 输出描述
     */
    @TableField(value = "output_description")
    private String outputDescription;

    /**
     * 测试数据
     */
    @TableField(value = "test_sample")
    private String testSample;

    /**
     * 限制时间(ms)
     */
    @TableField(value = "limit_time")
    private Integer limitTime;

    /**
     * 限制内存(MB)
     */
    @TableField(value = "limit_memory")
    private Integer limitMemory;

    /**
     * 提交数量
     */
    @TableField(value = "submit_count")
    private Long submitCount;

    /**
     * 通过数量
     */
    @TableField(value = "accept_count")
    private Long acceptCount;

    /**
     * 是否可见
     */
    @TableField(value = "visible")
    private Integer visible;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private LocalDateTime gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}