package com.creative.ojadmin.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName sys_submission
 */
@TableName(value ="sys_submission")
@Data
public class SysSubmissionDO implements Serializable {
    /**
     * 测评id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 题目id
     */
    @TableField(value = "problem_id")
    private Long problemId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 提交的代码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 提交时间
     */
    @TableField(value = "submit_time")
    private LocalDate submitTime;

    /**
     * 运行时间(ms)
     */
    @TableField(value = "run_time")
    private Integer runTime;

    /**
     * 运行内存(MB)
     */
    @TableField(value = "run_memory")
    private Integer runMemory;

    /**
     * 测试输入数据
     */
    @TableField(value = "input")
    private String input;

    /**
     * 测试输出数据
     */
    @TableField(value = "output")
    private String output;

    /**
     * 测评结果(0: 等待测评, 1: 测评中, 100:答案正确, 101: 答案错误)
     */
    @TableField(value = "status")
    private Integer status;

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

    /**
     * 测试样例数量
     */
    @TableField(value = "case_number")
    private Integer caseNumber;

    /**
     * 通过样例数量
     */
    @TableField(value = "ac_number")
    private Integer acNumber;

    /**
     * 代码语言
     */
    @TableField(value = "language_id")
    private Integer languageId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}