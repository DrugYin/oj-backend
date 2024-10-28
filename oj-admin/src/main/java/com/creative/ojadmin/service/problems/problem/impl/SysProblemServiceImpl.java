package com.creative.ojadmin.service.problems.problem.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.problems.problem.param.*;
import com.creative.ojadmin.controller.problems.problem.vo.ProblemVO;
import com.creative.ojadmin.controller.problems.problemTest.param.CreateProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.DeleteProblemTestParam;
import com.creative.ojadmin.controller.problems.problemTest.param.UpdateProblemTestParam;
import com.creative.ojadmin.domain.SysProblemDO;
import com.creative.ojadmin.service.problems.problem.SysProblemService;
import com.creative.ojadmin.mapper.SysProblemMapper;
import com.creative.ojadmin.service.problems.problemTags.SysProblemTagService;
import com.creative.ojadmin.service.problems.problemTest.SysProblemTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_problem(题目信息表)】的数据库操作Service实现
 * @createDate 2024-10-26 15:52:22
 */
@Service
@RequiredArgsConstructor
public class SysProblemServiceImpl extends ServiceImpl<SysProblemMapper, SysProblemDO>
        implements SysProblemService {

    private final SysProblemMapper baseMapper;
    private final SysProblemTestService sysProblemTestService;
    private final SysProblemTagService sysProblemTagService;

    @Override
    public PageResult<ProblemVO> pageQueryProblems(QueryProblemParam param) {
        Page<SysProblemDO> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysProblemDO>()
                        .and(param.getSearchStr() != null,
                                item -> item.like(SysProblemDO::getTitle, param.getSearchStr())
                                        .or()
                                        .like(SysProblemDO::getCustomId, param.getSearchStr())
                        )
                        .orderByAsc(SysProblemDO::getCustomId)
        );
        List<ProblemVO> collect = page.getRecords().stream().map(item -> {
            ProblemVO vo = new ProblemVO();
            vo.setId(item.getId());
            vo.setAuthor(item.getAuthor());
            vo.setCustomId(item.getCustomId());
            vo.setTitle(item.getTitle());
            vo.setAcceptCount(item.getAcceptCount());
            vo.setSubmitCount(item.getSubmitCount());
            vo.setVisible(item.getVisible() == 1);
            return vo;
        }).toList();
        return new PageResult<>(collect.size(), collect);
    }

    @Override
    public void deleteProblem(DeleteProblemParam param) {
        SysProblemDO problemDO = baseMapper.selectById(param.getId());
        if (problemDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_NOT_EXIST);
        }
        baseMapper.deleteById(param.getId());
        sysProblemTestService.deleteById(new DeleteProblemTestParam(param.getId()));
        sysProblemTagService.deleteByProblemId(param.getId());
    }

    @Override
    public void changeProblemVisible(ChangeProblemVisibleParam param) {
        SysProblemDO problemDO = baseMapper.selectById(param.getId());
        if (problemDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_NOT_EXIST);
        }
        problemDO.setVisible(param.isVisible() ? 1 : 0);
        problemDO.setGmtModified(LocalDateTime.now());
        updateById(problemDO);
    }

    @Override
    public void createProblem(CreateProblemParam param) {
        SysProblemDO problemDO1 = baseMapper.selectOne(new LambdaQueryWrapper<SysProblemDO>()
                .eq(SysProblemDO::getCustomId, param.getCustomId())
        );
        if (problemDO1 != null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_ALREADY_EXIST);
        }
        SysProblemDO problemDO = new SysProblemDO();
        problemDO.setAuthor(param.getAuthor());
        problemDO.setCustomId(param.getCustomId());
        problemDO.setTitle(param.getTitle());
        problemDO.setAuthor(param.getAuthor());
        problemDO.setDescription(param.getDescription());
        problemDO.setInputDescription(param.getInputDescription());
        problemDO.setOutputDescription(param.getOutputDescription());
        problemDO.setLimitMemory(param.getLimitMemory());
        problemDO.setLimitTime(param.getLimitTime());
        problemDO.setTestSample(param.getTestSample());
        save(problemDO);
        sysProblemTestService.createProblemTest(new CreateProblemTestParam(param.getTestData()));
    }

    @Override
    public void updateProblem(UpdateProblemParam param) {
        SysProblemDO problemDO = baseMapper.selectById(param.getId());
        if (problemDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.PROBLEM_NOT_EXIST);
        }
        problemDO.setTitle(param.getTitle());
        problemDO.setAuthor(param.getAuthor());
        problemDO.setCustomId(param.getCustomId());
        problemDO.setDescription(param.getDescription());
        problemDO.setInputDescription(param.getInputDescription());
        problemDO.setOutputDescription(param.getOutputDescription());
        problemDO.setLimitMemory(param.getLimitMemory());
        problemDO.setLimitTime(param.getLimitTime());
        problemDO.setTestSample(param.getTestSample());
        problemDO.setGmtModified(LocalDateTime.now());
        updateById(problemDO);
        UpdateProblemTestParam updateProblemTestParam = new UpdateProblemTestParam();
        updateProblemTestParam.setId(param.getId());
        updateProblemTestParam.setContent(param.getTestData());
        sysProblemTestService.updateProblemTest(updateProblemTestParam);
    }
}




