package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.domain.SysSubmission;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.submission.SubmitCodeParam;
import com.example.oj.service.SysSubmissionService;
import com.example.oj.vo.submission.SubmissionVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/26 下午2:20
 */
@RequiredArgsConstructor
@RequestMapping("/submission")
@RestController
public class SubmissionController {

    private final SysSubmissionService sysSubmissionService;

    /**
     * 提交代码
     *
     * @param param /
     * @return /
     */
    @PostMapping("/submit")
    public Result<?> submitCode(@Valid @RequestBody SubmitCodeParam param) {
        return Result.success(sysSubmissionService.submitCode(param));
    }

    /**
     * 获取提交状态
     *
     * @param submissionId /
     * @return /
     */
    @GetMapping("/{submissionId}/status")
    public Result<?> getSubmissionStatus(@PathVariable("submissionId") Long submissionId) {
        SysSubmission sysSubmission = sysSubmissionService.getById(submissionId);
        SubmissionVO submissionVO = new SubmissionVO();
        submissionVO.setSubmissionId(submissionId);
        submissionVO.setStatus(sysSubmission.getStatus());
        submissionVO.setAcNumber(sysSubmission.getAcNumber());
        submissionVO.setCaseNumber(sysSubmission.getCaseNumber());
        return Result.success(submissionVO);
    }

    @GetMapping
    public Result<?> getSubmissionDetail(QueryPageParam param) {
        return Result.success(sysSubmissionService.pageQuery(param));
    }

    @GetMapping("/problemSubmit")
    public Result<?> getProblemSubmit(QueryPageParam param) {
        return Result.success(sysSubmissionService.problemSubmitPageQuery(param));
    }

    @GetMapping("/userSubmit")
    public Result<?> getUserSubmit(QueryPageParam param) {
        return Result.success(sysSubmissionService.userSubmitPageQuery(param));
    }

    @GetMapping("/getSubmitsById")
    public Result<?> getSubmitsById(QueryPageParam param) {
        return Result.success(sysSubmissionService.getUserSubmitsById(param));
    }

}
