package com.example.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.domain.SysProblemTest;
import com.example.oj.mapper.SysProblemTestMapper;
import com.example.oj.param.problem.CreateProblemTestParam;
import com.example.oj.param.problem.DeleteProblemTestParam;
import com.example.oj.param.problem.UpdateProblemTestParam;
import com.example.oj.service.SysProblemTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public void createProblemTest(CreateProblemTestParam createProblemTestParam) {
        SysProblemTest sysProblemTest = new SysProblemTest();
        sysProblemTest.setContent(createProblemTestParam.getContent());
        sysProblemTest.setGmtModified(LocalDateTime.now());
        sysProblemTest.setGmtCreate(LocalDateTime.now());
        save(sysProblemTest);
    }

    @Override
    public void updateProblemTest(UpdateProblemTestParam param) {
        SysProblemTest sysProblemTest = new SysProblemTest();
        sysProblemTest.setId(param.getId());
        sysProblemTest.setContent(param.getContent());
        sysProblemTest.setGmtModified(LocalDateTime.now());
        log.info("updateTest: {}", sysProblemTest);
        updateById(sysProblemTest);
    }

    @Override
    public void deleteProblemTest(DeleteProblemTestParam param) {
        removeById(param.getId());
    }
}




