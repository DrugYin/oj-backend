package com.creative.ojadmin.service.submission.submissions.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.submission.submissions.param.DeleteSubmitsParam;
import com.creative.ojadmin.controller.submission.submissions.vo.SubmitRecordVO;
import com.creative.ojadmin.domain.SysSubmissionDO;
import com.creative.ojadmin.service.submission.submissions.SysSubmissionService;
import com.creative.ojadmin.mapper.SysSubmissionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    @Override
    public SubmitRecordVO dailySubmitRecord() {
        List<SysSubmissionDO> sysSubmissionDOS = baseMapper.selectList(new LambdaQueryWrapper<SysSubmissionDO>()
                .eq(SysSubmissionDO::getSubmitTime, LocalDate.now())
        );
        return getRecord(sysSubmissionDOS);
    }

    @Override
    public SubmitRecordVO submitRecord() {
        List<SysSubmissionDO> sysSubmissionDOS = baseMapper.selectList(new LambdaQueryWrapper<SysSubmissionDO>()
                .orderByAsc(SysSubmissionDO::getGmtCreate)
        );
        return getRecord(sysSubmissionDOS);
    }

    private SubmitRecordVO getRecord(List<SysSubmissionDO> sysSubmissionDOS) {
        SubmitRecordVO submitRecordVO = new SubmitRecordVO();
        submitRecordVO.setTotal(sysSubmissionDOS.size());
        for (SysSubmissionDO sysSubmissionDO : sysSubmissionDOS) {
            if (sysSubmissionDO.getStatus() == 100) {
                submitRecordVO.setAccept(submitRecordVO.getAccept() + 1);
            } else if (sysSubmissionDO.getStatus() == 101) {
                submitRecordVO.setWrongAnswer(submitRecordVO.getWrongAnswer() + 1);
            } else if (sysSubmissionDO.getStatus() == 102) {
                submitRecordVO.setTimeLimitExceeded(submitRecordVO.getTimeLimitExceeded() + 1);
            } else if (sysSubmissionDO.getStatus() == 103) {
                submitRecordVO.setMemoryLimitExceeded(submitRecordVO.getMemoryLimitExceeded() + 1);
            } else if (sysSubmissionDO.getStatus() == -1) {
                submitRecordVO.setCompileError(submitRecordVO.getCompileError() + 1);
            } else {
                submitRecordVO.setOtherError(submitRecordVO.getOtherError() + 1);
            }
        }
        return submitRecordVO;
    }
}




