package com.creative.ojadmin.controller.problems.tags;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.problems.problemTags.param.UpdateProblemTagsParam;
import com.creative.ojadmin.controller.problems.tags.param.CreateTagParam;
import com.creative.ojadmin.controller.problems.tags.param.DeleteTagParam;
import com.creative.ojadmin.controller.problems.tags.param.UpdateTagParam;
import com.creative.ojadmin.service.problems.problemTags.SysProblemTagService;
import com.creative.ojadmin.service.problems.tags.SysTagsService;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @date 2024/10/23 19:00
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagsController {

    private final SysTagsService sysTagsService;
    private final SysProblemTagService sysProblemTagService;

    @GetMapping
    public ResponseResult<?> getAllTags() {
        return ResponseResult.success(sysTagsService.getAllTags());
    }

    @SaCheckRole("admin")
    @PostMapping("/create")
    public ResponseResult<?> createTag(@RequestBody CreateTagParam param) {
        sysTagsService.createTag(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> updateTag(@RequestBody UpdateTagParam param) {
        sysTagsService.updateTag(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> delete(@RequestBody DeleteTagParam param) {
        sysTagsService.deleteTag(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/problemTags/update")
    public ResponseResult<?> updateProblemTags(@RequestBody UpdateProblemTagsParam param) {
        sysProblemTagService.updateProblemTags(param);
        return ResponseResult.success("OK");
    }

}
