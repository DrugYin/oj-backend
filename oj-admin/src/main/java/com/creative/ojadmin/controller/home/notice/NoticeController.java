package com.creative.ojadmin.controller.home.notice;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.home.notice.param.CreateNoticeParam;
import com.creative.ojadmin.controller.home.notice.param.DeleteNoticeParam;
import com.creative.ojadmin.controller.home.notice.param.UpdateNoticeParam;
import com.creative.ojadmin.service.home.notice.SysNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiChongWei
 * @date 2024/10/21 19:08
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final SysNoticeService sysNoticeService;

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> deleteNotice(@RequestBody DeleteNoticeParam param) {
        sysNoticeService.deleteNoticeById(param);
        return ResponseResult.success("删除成功");
    }

    @SaCheckRole("admin")
    @PostMapping("/create")
    public ResponseResult<?> createNotice(@RequestBody CreateNoticeParam param) {
        sysNoticeService.createNotice(param);
        return ResponseResult.success("创建成功");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> updateNotice(@RequestBody UpdateNoticeParam param) {
        sysNoticeService.updateNotice(param);
        return ResponseResult.success("更新成功");
    }

}
