package com.creative.ojadmin.controller.problem.tags;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.problem.tags.param.CreateTagParam;
import com.creative.ojadmin.controller.problem.tags.param.DeleteTagParam;
import com.creative.ojadmin.controller.problem.tags.param.UpdateTagParam;
import com.creative.ojadmin.service.problem.tags.SysTagsService;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private final ParameterNamesModule parameterNamesModule;

    @PostMapping("/create")
    public ResponseResult<?> createTag(@RequestBody CreateTagParam param) {
        sysTagsService.createTag(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/update")
    public ResponseResult<?> updateTag(@RequestBody UpdateTagParam param) {
        sysTagsService.updateTag(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/delete")
    public ResponseResult<?> delete(@RequestBody DeleteTagParam param) {
        sysTagsService.deleteTag(param);
        return ResponseResult.success("OK");
    }

}
