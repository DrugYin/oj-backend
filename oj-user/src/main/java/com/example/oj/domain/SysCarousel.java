package com.example.oj.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName sys_carousel
 */
@TableName(value = "sys_carousel")
@Data
public class SysCarousel implements Serializable {
    /**
     * 图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片地址
     */
    @TableField(value = "imgUrl")
    private String imgurl;

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
     * 标题
     */
    @TableField(value = "title")
    private String title;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}