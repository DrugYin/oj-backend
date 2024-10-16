package com.example.oj.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.oj.domain.SysProblem;

/**
 * @author Barbuda
 * @description 针对表【sys_problem(题目信息表)】的数据库操作Mapper
 * @createDate 2024-06-14 14:10:59
 * @Entity com.example.oj.domain.SysProblem
 */
@InterceptorIgnore(tenantLine = "true")
public interface SysProblemMapper extends BaseMapper<SysProblem> {

}




