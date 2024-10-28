package com.creative.ojadmin.service.problems.problemTags.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.controller.problems.problemTags.param.UpdateProblemTagsParam;
import com.creative.ojadmin.domain.SysProblemTagDO;
import com.creative.ojadmin.service.problems.problemTags.SysProblemTagService;
import com.creative.ojadmin.mapper.SysProblemTagMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author Barbuda
* @description 针对表【sys_problem_tag】的数据库操作Service实现
* @createDate 2024-10-27 18:27:43
*/
@Service
public class SysProblemTagServiceImpl extends ServiceImpl<SysProblemTagMapper, SysProblemTagDO>
    implements SysProblemTagService{

    @Override
    public void updateProblemTags(UpdateProblemTagsParam param) {
        List<SysProblemTagDO> problemTagDOS = baseMapper.selectList(new LambdaQueryWrapper<SysProblemTagDO>()
                .eq(SysProblemTagDO::getProblemId, param.getProblemId())
        );
        for (SysProblemTagDO problemTagDO : problemTagDOS) {
            baseMapper.deleteById(problemTagDO);
        }
        for (Long tagId : param.getTagIds()) {
            SysProblemTagDO problemTagDO = new SysProblemTagDO();
            problemTagDO.setProblemId(param.getProblemId());
            problemTagDO.setTagId(tagId);
            problemTagDO.setGmtCreate(LocalDateTime.now());
            problemTagDO.setGmtModified(LocalDateTime.now());
            save(problemTagDO);
        }
    }

    @Override
    public void deleteByProblemId(Long problemId) {
        baseMapper.delete(new LambdaQueryWrapper<SysProblemTagDO>()
                .eq(SysProblemTagDO::getProblemId, problemId)
        );
    }
}




