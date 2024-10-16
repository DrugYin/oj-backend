package com.example.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysTags;
import com.example.oj.param.tags.CreateTagParam;
import com.example.oj.param.tags.DeleteTagParam;
import com.example.oj.param.tags.UpdateTagParam;
import com.example.oj.vo.tags.TagPageQueryParam;
import com.example.oj.vo.tags.TagsVO;

/**
 * @author Barbuda
 * @description 针对表【sys_tags】的数据库操作Service
 * @createDate 2024-10-10 18:38:55
 */
public interface SysTagsService extends IService<SysTags> {

    void createTag(CreateTagParam param);

    void deleteTag(DeleteTagParam param);

    void updateTag(UpdateTagParam param);

    PageResult<TagsVO> getTags(TagPageQueryParam param);

}
