package com.example.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysProblem;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.vo.problem.ProblemDetailVO;
import com.example.oj.vo.problem.ProblemVO;

/**
 * @author Barbuda
 * @description 针对表【sys_problem(题目信息表)】的数据库操作Service
 * @createDate 2024-06-14 14:10:59
 */
public interface SysProblemService extends IService<SysProblem> {
    /**
     * 分页查询问题。
     *
     * @param param 查询的参数对象，包含分页信息和查询条件。
     * @return 返回分页查询结果，包含问题的列表和分页信息。
     */
    PageResult<ProblemVO> pageQuery(QueryPageParam param);

    /**
     * 获取问题详情。
     *
     * @param id 问题的唯一标识符。
     * @return 返回问题详情对象，包含问题的详细信息。
     */
    ProblemDetailVO getProblemDetail(Long id);

    void updateSubmitInfo(long id, int status);

}
