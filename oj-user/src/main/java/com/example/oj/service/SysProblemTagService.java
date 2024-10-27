package com.example.oj.service;

import com.example.oj.domain.SysProblemTag;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.param.tags.QueryProblemTagsParam;
import com.example.oj.vo.tags.TagsVO;

import java.util.HashMap;
import java.util.List;

/**
 * @author Barbuda
 * @description 针对表【sys_problem_tag】的数据库操作Service
 * @createDate 2024-10-11 10:43:31
 */
public interface SysProblemTagService extends IService<SysProblemTag> {

    HashMap<Long, List<TagsVO>> getProblemTags(QueryProblemTagsParam param);

}
