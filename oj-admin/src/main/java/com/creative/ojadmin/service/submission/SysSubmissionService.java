package com.creative.ojadmin.service.submission;

import com.creative.ojadmin.controller.submission.param.DeleteSubmitsParam;
import com.creative.ojadmin.domain.SysSubmissionDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_submission】的数据库操作Service
* @createDate 2024-10-23 15:06:41
*/
public interface SysSubmissionService extends IService<SysSubmissionDO> {

    void deleteBySubmitIds(DeleteSubmitsParam param);

}
