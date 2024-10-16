package com.example.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.domain.SysProblemTest;
import com.example.oj.param.problem.CreateProblemTestParam;
import com.example.oj.param.problem.DeleteProblemTestParam;
import com.example.oj.param.problem.UpdateProblemTestParam;

/**
 * @author Barbuda
 * @description 针对表【sys_problem_test】的数据库操作Service
 * @createDate 2024-08-01 15:21:35
 */
public interface SysProblemTestService extends IService<SysProblemTest> {

    void createProblemTest(CreateProblemTestParam createProblemTestParam);

    void updateProblemTest(UpdateProblemTestParam param);

    void deleteProblemTest(DeleteProblemTestParam param);

}
