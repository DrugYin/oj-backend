package com.creative.ojadmin.service.notice;

import com.creative.ojadmin.controller.notice.param.CreateNoticeParam;
import com.creative.ojadmin.controller.notice.param.DeleteNoticeParam;
import com.creative.ojadmin.controller.notice.param.UpdateNoticeParam;
import com.creative.ojadmin.domain.SysNoticeDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_notice】的数据库操作Service
* @createDate 2024-10-21 19:07:49
*/
public interface SysNoticeService extends IService<SysNoticeDO> {

    void deleteNoticeById(DeleteNoticeParam param);

    void createNotice(CreateNoticeParam param);

    void updateNotice(UpdateNoticeParam param);

}
