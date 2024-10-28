package com.example.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.domain.SysProblemTest;
import com.example.oj.mapper.SysProblemTestMapper;
import com.example.oj.service.SysProblemTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Barbuda
 * @description 针对表【sys_problem_test】的数据库操作Service实现
 * @createDate 2024-08-01 15:21:35
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class SysProblemTestServiceImpl extends ServiceImpl<SysProblemTestMapper, SysProblemTest>
        implements SysProblemTestService {

}




