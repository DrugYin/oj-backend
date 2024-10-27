package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.domain.SysProblemTag;
import com.example.oj.param.tags.QueryProblemTagsParam;
import com.example.oj.service.SysProblemTagService;
import com.example.oj.mapper.SysProblemTagMapper;
import com.example.oj.service.SysTagsService;
import com.example.oj.vo.tags.TagsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Barbuda
 * @description 针对表【sys_problem_tag】的数据库操作Service实现
 * @createDate 2024-10-11 10:43:31
 */
@RequiredArgsConstructor
@Service
public class SysProblemTagServiceImpl extends ServiceImpl<SysProblemTagMapper, SysProblemTag>
        implements SysProblemTagService {

    private final SysTagsService sysTagsService;

    @Override
    public HashMap<Long, List<TagsVO>> getProblemTags(QueryProblemTagsParam param) {
        List<Long> problemIds = param.getProblemIds();
        if(problemIds.isEmpty()) {
            return new HashMap<>();
        }
        List<SysProblemTag> sysProblemTags = baseMapper.selectList(
                new LambdaQueryWrapper<SysProblemTag>()
                        .in(SysProblemTag::getProblemId, problemIds)
                        .orderByAsc(SysProblemTag::getProblemId)
        );
        HashMap<Long, List<TagsVO>> data = new HashMap<>();
        for (SysProblemTag sysProblemTag : sysProblemTags) {
            if (!data.containsKey(sysProblemTag.getProblemId())) {
                data.put(sysProblemTag.getProblemId(), new ArrayList<>());
            }
            data.get(sysProblemTag.getProblemId()).add(sysTagsService.getTagById(sysProblemTag.getTagId()));
        }
        return data;
    }
}




