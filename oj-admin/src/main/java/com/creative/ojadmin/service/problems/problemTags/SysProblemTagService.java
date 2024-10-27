package com.creative.ojadmin.service.problems.problemTags;

import com.creative.ojadmin.controller.problems.problemTags.param.UpdateProblemTagsParam;
import com.creative.ojadmin.domain.SysProblemTagDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_problem_tag】的数据库操作Service
* @createDate 2024-10-27 18:27:43
*/
public interface SysProblemTagService extends IService<SysProblemTagDO> {

    void updateProblemTags(UpdateProblemTagsParam param);

}
