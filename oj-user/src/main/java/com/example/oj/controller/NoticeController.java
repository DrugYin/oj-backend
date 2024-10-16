package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.param.notice.CreateNoticeParam;
import com.example.oj.param.notice.DeleteNoticeParam;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.notice.UpdateNoticeParam;
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

    /**
     * 创建公告
     *
     * @param param /
     * @return /
     */
    @PostMapping("/create")
    public Result<?> createNotice(@RequestBody CreateNoticeParam param) {
        iSysNoticeService.createNotice(param);
        return Result.success(null);
    }

    /**
     * 更新公告
     *
     * @param param /
     * @return /
     */
    @PostMapping("/update")
    public Result<?> updateNotice(@RequestBody UpdateNoticeParam param) {
        iSysNoticeService.updateNotice(param);
        return Result.success(null);
    }

    /**
     * 删除公告
     *
     * @param param /
     * @return /
     */
    @PostMapping("/delete")
    public Result<?> deleteNotice(@RequestBody DeleteNoticeParam param) {
        iSysNoticeService.deleteNotice(param);
        return Result.success(null);
    }
}
