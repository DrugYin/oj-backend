package com.creative.ojadmin.controller.submission.submissions;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.submission.submissions.param.DeleteSubmitsParam;
import com.creative.ojadmin.service.submission.submissions.SysSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @date 2024/10/23 15:08
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/submission")
public class SubmissionController {

    private final SysSubmissionService sysSubmissionService;

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> deleteSubmitsByIds(@RequestBody DeleteSubmitsParam param) {
        sysSubmissionService.deleteBySubmitIds(param);
        return ResponseResult.success("删除成功");
    }

    @GetMapping("/dailyRecord")
    public ResponseResult<?> getDailySubmitRecord() {
        return ResponseResult.success(sysSubmissionService.dailySubmitRecord());
    }

    @GetMapping("/record")
    public ResponseResult<?> getSubmitsRecord() {
        return ResponseResult.success(sysSubmissionService.submitRecord());
    }
}
