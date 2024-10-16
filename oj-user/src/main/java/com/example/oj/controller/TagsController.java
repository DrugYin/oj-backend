package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.param.tags.CreateTagParam;
import com.example.oj.param.tags.DeleteTagParam;
import com.example.oj.param.tags.UpdateTagParam;
import com.example.oj.service.SysTagsService;
import com.example.oj.vo.tags.TagPageQueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午6:47
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/tags")
public class TagsController {

    private final SysTagsService sysTagsService;

    @PostMapping("/create")
    public Result<?> createTag(@RequestBody CreateTagParam param) {
        sysTagsService.createTag(param);
        return Result.success("ok");
    }

    @PostMapping("/delete")
    public Result<?> deleteTag(@RequestBody DeleteTagParam param) {
        sysTagsService.deleteTag(param);
        return Result.success("ok");
    }

    @PostMapping("/update")
    public Result<?> updateTag(@RequestBody UpdateTagParam param) {
        sysTagsService.updateTag(param);
        return Result.success("ok");
    }

    @GetMapping("")
    public Result<?> getTags(TagPageQueryParam param) {
        return Result.success(sysTagsService.getTags(param));
    }

}
