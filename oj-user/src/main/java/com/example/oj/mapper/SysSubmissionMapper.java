package com.example.oj.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oj.domain.SysSubmission;

/**
 * @author Barbuda
 * @description 针对表【sys_submission】的数据库操作Mapper
 * @createDate 2024-07-31 16:54:53
 * @Entity com.example.oj.domain.SysSubmission
 */
@InterceptorIgnore(tenantLine = "true")
public interface SysSubmissionMapper extends BaseMapper<SysSubmission> {

}




