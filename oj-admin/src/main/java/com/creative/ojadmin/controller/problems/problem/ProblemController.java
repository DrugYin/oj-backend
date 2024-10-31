package com.creative.ojadmin.controller.problems.problem;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.problems.problem.param.*;
import com.creative.ojadmin.service.problems.problem.SysProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @date 2024/10/26 15:55
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/problem")
public class ProblemController {

    private final SysProblemService sysProblemService;

    @GetMapping
    public ResponseResult<?> pageQueryProblems(QueryProblemParam param) {
        return ResponseResult.success(sysProblemService.pageQueryProblems(param));
    }

    @SaCheckRole("admin")
    @PostMapping("/setVisible")
    public ResponseResult<?> setVisible(@RequestBody ChangeProblemVisibleParam param) {
        sysProblemService.changeProblemVisible(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> deleteProblem(@RequestBody DeleteProblemParam param) {
        sysProblemService.deleteProblem(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/create")
    public ResponseResult<?> createProblem(@RequestBody CreateProblemParam param) {
        sysProblemService.createProblem(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> UpdateProblem(@RequestBody UpdateProblemParam param){
        sysProblemService.updateProblem(param);
        return ResponseResult.success("OK");
    }

}
