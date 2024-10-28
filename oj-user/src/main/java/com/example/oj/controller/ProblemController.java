package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.service.SysProblemService;
import com.example.oj.service.SysProblemTestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * @author 云海
 * @description
 * @createDate 2024/6/14 下午3:57
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/problem")
/*
  系统问题处理控制器。
  该控制器负责处理与系统问题相关的查询、创建、更新和删除操作。
 */
public class ProblemController {

    /**
     * 系统问题服务接口，用于执行具体的问题操作。
     */
    private final SysProblemService sysProblemService;
    private final SysProblemTestService sysProblemTestService;

    /**
     * 分页查询系统问题。
     *
     * @param param 查询参数，包含分页信息和查询条件。
     * @return 查询结果，包含分页信息和查询到的问题列表。
     */
    @GetMapping
    public Result<?> pageQuery(QueryPageParam param) {
        return Result.success(sysProblemService.pageQuery(param));
    }


    @GetMapping("/{problemId}")
    public Result<?> getProblemDetail(@PathVariable long problemId) {
        return Result.success(sysProblemService.getProblemDetail(problemId));
    }

    @GetMapping("/{problemId}/updateSubmitInfo")
    public Result<?> updateSubmitInfo(@PathVariable long problemId, @RequestParam("status") int status) {
        sysProblemService.updateSubmitInfo(problemId, status);
        return Result.success("Ok");
    }

    @GetMapping("/{problemId}/getTestData")
    public Result<?> getTestData(@PathVariable long problemId) {
        return Result.success(sysProblemTestService.getById(problemId).getContent());
    }

}
