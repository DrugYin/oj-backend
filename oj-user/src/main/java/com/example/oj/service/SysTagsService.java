package com.example.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysTags;
import com.example.oj.param.tags.TagPageQueryParam;
import com.example.oj.vo.tags.TagsVO;

import java.util.List;

/**
 * @author Barbuda
 * @description 针对表【sys_tags】的数据库操作Service
 * @createDate 2024-10-10 18:38:55
 */
public interface SysTagsService extends IService<SysTags> {

    PageResult<TagsVO> getTags(TagPageQueryParam param);

    TagsVO getTagById(Long id);

}
