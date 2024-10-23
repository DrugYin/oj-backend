package com.creative.ojadmin.controller.submission.submissions;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.submission.submissions.param.DeleteSubmitsParam;
import com.creative.ojadmin.service.submission.submissions.SysSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/delete")
    public ResponseResult<?> deleteSubmitsByIds(@RequestBody DeleteSubmitsParam param) {
        sysSubmissionService.deleteBySubmitIds(param);
        return ResponseResult.success("删除成功");
    }
}
