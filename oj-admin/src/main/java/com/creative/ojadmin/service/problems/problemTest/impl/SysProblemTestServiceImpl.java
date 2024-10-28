package com.creative.ojadmin.service.problems.problemTest.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.problems.problemTest.param.CreateProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.DeleteProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.UpdateProblemTestParam;
import com.creative.ojadmin.domain.SysProblemTestDO;
import com.creative.ojadmin.service.problems.problemTest.SysProblemTestService;
import com.creative.ojadmin.mapper.SysProblemTestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author Barbuda
* @description 针对表【sys_problem_test】的数据库操作Service实现
* @createDate 2024-10-28 15:17:58
*/
@Service
@RequiredArgsConstructor
public class SysProblemTestServiceImpl extends ServiceImpl<SysProblemTestMapper, SysProblemTestDO>
    implements SysProblemTestService{

    private final SysProblemTestMapper baseMapper;

    @Override
    public void deleteById(DeleteProblemTestParam param) {
        SysProblemTestDO sysProblemTestDO = baseMapper.selectById(param.getId());
        if (sysProblemTestDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_NOT_EXIST);
        }
        removeById(sysProblemTestDO);
    }

    @Override
    public void createProblemTest(CreateProblemTestParam param) {
        SysProblemTestDO sysProblemTestDO = new SysProblemTestDO();
        sysProblemTestDO.setContent(param.getContent());
        sysProblemTestDO.setGmtCreate(LocalDateTime.now());
        sysProblemTestDO.setGmtModified(LocalDateTime.now());
        save(sysProblemTestDO);
    }

    @Override
    public void updateProblemTest(UpdateProblemTestParam param) {
        SysProblemTestDO sysProblemTestDO = baseMapper.selectById(param.getId());
        if (sysProblemTestDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_NOT_EXIST);
        }
        sysProblemTestDO.setContent(param.getContent());
        sysProblemTestDO.setGmtModified(LocalDateTime.now());
        updateById(sysProblemTestDO);
    }
}




