package com.example.oj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName sys_language
 */
@TableName(value = "sys_language")
@Data
public class SysLanguage implements Serializable {
    /**
     * 语言id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 语言
     */
    @TableField(value = "name")
    private String name;

    /**
     * 提交id
     */
    @TableField(value = "submitId")
    private Integer submitid;

    /**
     * 是否可选
     */
    @TableField(value = "enable")
    private Integer enable;

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