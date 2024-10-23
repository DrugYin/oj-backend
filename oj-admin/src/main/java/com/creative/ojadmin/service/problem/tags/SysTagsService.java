package com.creative.ojadmin.service.problem.tags;

import com.creative.ojadmin.controller.problem.tags.param.CreateTagParam;
import com.creative.ojadmin.controller.problem.tags.param.DeleteTagParam;
import com.creative.ojadmin.controller.problem.tags.param.UpdateTagParam;
import com.creative.ojadmin.domain.SysTagsDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_tags】的数据库操作Service
* @createDate 2024-10-23 18:57:16
*/
public interface SysTagsService extends IService<SysTagsDO> {

    void createTag(CreateTagParam param);

    void updateTag(UpdateTagParam param);

    void deleteTag(DeleteTagParam param);

}
