package com.example.oj.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oj.domain.SysUser;

/**
 * @author Barbuda
 * @description 针对表【sys_user】的数据库操作Mapper
 * @createDate 2024-06-24 14:44:39
 * @Entity com.example.oj.domain.SysUser
 */
@InterceptorIgnore(tenantLine = "true")
public interface SysUserMapper extends BaseMapper<SysUser> {

}




