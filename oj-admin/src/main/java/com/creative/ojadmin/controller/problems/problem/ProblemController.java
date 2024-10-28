package com.creative.ojadmin.controller.problems.problem;

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

    @PostMapping("/setVisible")
    public ResponseResult<?> setVisible(@RequestBody ChangeProblemVisibleParam param) {
        sysProblemService.changeProblemVisible(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/delete")
    public ResponseResult<?> deleteProblem(@RequestBody DeleteProblemParam param) {
        sysProblemService.deleteProblem(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/create")
    public ResponseResult<?> createProblem(@RequestBody CreateProblemParam param) {
        sysProblemService.createProblem(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/update")
    public ResponseResult<?> UpdateProblem(@RequestBody UpdateProblemParam param){
        sysProblemService.updateProblem(param);
        return ResponseResult.success("OK");
    }

}
