package com.creative.ojadmin.service.problems.problem;

import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.problems.problem.param.ChangeProblemVisibleParam;
import com.creative.ojadmin.controller.problems.problem.param.DeleteProblemParam;
import com.creative.ojadmin.controller.problems.problem.param.QueryProblemParam;
import com.creative.ojadmin.controller.problems.problem.vo.ProblemVO;
import com.creative.ojadmin.domain.SysProblemDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_problem(题目信息表)】的数据库操作Service
* @createDate 2024-10-26 15:52:23
*/
public interface SysProblemService extends IService<SysProblemDO> {

    PageResult<ProblemVO> pageQueryProblems(QueryProblemParam param);

    void deleteProblem(DeleteProblemParam param);

    void changeProblemVisible(ChangeProblemVisibleParam param);

}
