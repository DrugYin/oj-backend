package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.problem.*;
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

    private static final Logger log = LoggerFactory.getLogger(ProblemController.class);
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

    /**
     * 创建新的系统问题。
     *
     * @param param 创建参数，包含新问题的详细信息。
     * @return 创建结果，成功返回空结果。
     */
    @PostMapping("/create")
    public Result<?> create(@RequestBody CreateProblemParam param) {
        sysProblemService.createProblem(param);
        return Result.success(null);
    }

    /**
     * 更新已存在的系统问题。
     *
     * @param param 更新参数，包含要更新的问题ID和更新后的信息。
     * @return 更新结果，成功返回空结果。
     */
    @PostMapping("/update")
    public Result<?> update(@RequestBody UpdateProblemParam param) {
        sysProblemService.updateProblem(param);
        return Result.success(null);
    }

    /**
     * 删除指定的系统问题。
     *
     * @param param 删除参数，包含要删除的问题ID。
     * @return 删除结果，成功返回空结果。
     */
    @PostMapping("/delete")
    public Result<?> delete(@RequestBody DeleteProblemParam param) {
        sysProblemService.deleteProblem(param);
        return Result.success(null);
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

    @PostMapping("/updateTestData")
    public Result<?> updateTestData(@RequestBody UpdateProblemTestParam param) {
        log.info("updateTestData param: {}", param);
        sysProblemTestService.updateProblemTest(param);
        return Result.success("ok");
    }

    @PostMapping("/createTestData")
    public Result<?> createTestData(@RequestBody CreateProblemTestParam param) {
        sysProblemTestService.createProblemTest(param);
        return Result.success("ok");
    }


    @PostMapping("/deleteTestData")
    public Result<?> deleteTestData(@RequestBody DeleteProblemTestParam param) {
        sysProblemTestService.deleteProblemTest(param);
        return Result.success("ok");
    }
}
