package com.creative.ojadmin.service.submission.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.submission.param.DeleteSubmitsParam;
import com.creative.ojadmin.domain.SysSubmissionDO;
import com.creative.ojadmin.service.submission.SysSubmissionService;
import com.creative.ojadmin.mapper.SysSubmissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author Barbuda
* @description 针对表【sys_submission】的数据库操作Service实现
* @createDate 2024-10-23 15:06:41
*/
@Service
@RequiredArgsConstructor
public class SysSubmissionServiceImpl extends ServiceImpl<SysSubmissionMapper, SysSubmissionDO>
    implements SysSubmissionService{

    private final SysSubmissionMapper baseMapper;

    @Override
    public void deleteBySubmitIds(DeleteSubmitsParam param) {
        for (Long id : param.getIds()) {
            SysSubmissionDO submissionDO = baseMapper.selectById(id);
            if (submissionDO == null) {
                throw new ServiceException(GlobalErrorCodeEnum.SUBMISSION_NOT_EXIST);
            }
            removeById(id);
        }
    }
}




