package com.creative.ojadmin.controller.notice;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.notice.param.CreateNoticeParam;
import com.creative.ojadmin.controller.notice.param.DeleteNoticeParam;
import com.creative.ojadmin.controller.notice.param.UpdateNoticeParam;
import com.creative.ojadmin.service.notice.SysNoticeService;
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

    @PostMapping("/delete")
    public ResponseResult<?> deleteNotice(@RequestBody DeleteNoticeParam param) {
        sysNoticeService.deleteNoticeById(param);
        return ResponseResult.success("删除成功");
    }

    @PostMapping("/create")
    public ResponseResult<?> createNotice(@RequestBody CreateNoticeParam param) {
        sysNoticeService.createNotice(param);
        return ResponseResult.success("创建成功");
    }

    @PostMapping("/update")
    public ResponseResult<?> updateNotice(@RequestBody UpdateNoticeParam param) {
        sysNoticeService.updateNotice(param);
        return ResponseResult.success("更新成功");
    }

}
