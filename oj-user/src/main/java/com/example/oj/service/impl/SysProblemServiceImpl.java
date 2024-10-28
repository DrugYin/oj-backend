package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysProblem;
import com.example.oj.mapper.SysProblemMapper;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.service.SysProblemService;
import com.example.oj.vo.problem.ProblemDetailVO;
import com.example.oj.vo.problem.ProblemVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_problem(题目信息表)】的数据库操作Service实现
 * @createDate 2024-06-14 14:10:59
 */
@RequiredArgsConstructor
@Service
public class SysProblemServiceImpl extends ServiceImpl<SysProblemMapper, SysProblem>
        implements SysProblemService {

    @Override
    public PageResult<ProblemVO> pageQuery(QueryPageParam param) {
        // 根据查询参数构建分页查询条件
        Page<SysProblem> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysProblem>()
                        .and(param.getSearchStr() != null,
                                item -> item.like(SysProblem::getCustomId, param.getSearchStr())
                                        .or()
                                        .like(SysProblem::getTitle, param.getSearchStr()))
                        .and(item -> item.eq(SysProblem::getVisible, 1))
                        .orderByAsc(SysProblem::getCustomId)
        );

        // 将查询结果转换为问题详情视图对象列表
        List<ProblemVO> collect = page.getRecords().stream().map(item -> {
            ProblemVO problemVO = new ProblemVO();
            problemVO.setId(item.getId());
            problemVO.setAuthor(item.getAuthor());
            problemVO.setCustomId(item.getCustomId());
            problemVO.setTitle(item.getTitle());
            problemVO.setAcceptCount(item.getAcceptCount());
            problemVO.setSubmitCount(item.getSubmitCount());
            return problemVO;
        }).collect(Collectors.toList());

        // 构建并返回分页查询结果
        return new PageResult<>(page.getTotal(), collect);
    }

    /**
     * 根据ID获取问题详情。
     *
     * @param id 问题的ID。
     * @return 问题详情视图对象，包含问题的详细信息。
     */
    @Override
    public ProblemDetailVO getProblemDetail(Long id) {
        SysProblem sysProblem = getById(id);
        ProblemDetailVO problemDetailVO = new ProblemDetailVO();
        problemDetailVO.setId(sysProblem.getId());
        problemDetailVO.setAuthor(sysProblem.getAuthor());
        problemDetailVO.setCustomId(sysProblem.getCustomId());
        problemDetailVO.setTitle(sysProblem.getTitle());
        problemDetailVO.setDescription(sysProblem.getDescription());
        problemDetailVO.setInputDescription(sysProblem.getInputDescription());
        problemDetailVO.setOutputDescription(sysProblem.getOutputDescription());
        problemDetailVO.setTestSample(sysProblem.getTestSample());
        problemDetailVO.setLimitTime(sysProblem.getLimitTime());
        problemDetailVO.setLimitMemory(sysProblem.getLimitMemory());
        return problemDetailVO;
    }

    @Override
    public void updateSubmitInfo(long id, int status) {
        SysProblem sysProblem = getById(id);
        sysProblem.setSubmitCount(sysProblem.getSubmitCount() + 1);
        if (status == 100) {
            sysProblem.setAcceptCount(sysProblem.getAcceptCount() + 1);
        }
        sysProblem.setGmtCreate(LocalDateTime.now());
        updateById(sysProblem);
    }


}




