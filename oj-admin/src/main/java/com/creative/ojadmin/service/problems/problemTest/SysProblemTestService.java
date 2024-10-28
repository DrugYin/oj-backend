package com.creative.ojadmin.service.problems.problemTest;

import com.creative.ojadmin.controller.problems.problemTest.param.CreateProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.DeleteProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.UpdateProblemTestParam;
import com.creative.ojadmin.domain.SysProblemTestDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_problem_test】的数据库操作Service
* @createDate 2024-10-28 15:17:58
*/
public interface SysProblemTestService extends IService<SysProblemTestDO> {

    void deleteById(DeleteProblemTestParam param);

    void createProblemTest(CreateProblemTestParam param);

    void updateProblemTest(UpdateProblemTestParam param);

}
