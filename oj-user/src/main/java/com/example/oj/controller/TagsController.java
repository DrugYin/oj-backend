package com.example.oj.controller;

import com.example.oj.common.model.Result;
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

    @GetMapping("")
    public Result<?> getTags(TagPageQueryParam param) {
        return Result.success(sysTagsService.getTags(param));
    }

}
