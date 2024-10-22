package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.service.SysNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/7 下午2:47
 */

@RequestMapping("/notice")
@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final SysNoticeService iSysNoticeService;

    /**
     * 分页查询
     *
     * @param param /
     * @return /
     */
    @GetMapping
    public Result<?> pageQuery(QueryPageParam param) {
        return Result.success(iSysNoticeService.pageQuery(param));
    }
}
