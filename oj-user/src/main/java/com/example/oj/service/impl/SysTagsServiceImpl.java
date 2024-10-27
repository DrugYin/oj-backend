package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysTags;
import com.example.oj.mapper.SysTagsMapper;
import com.example.oj.service.SysTagsService;
import com.example.oj.param.tags.TagPageQueryParam;
import com.example.oj.vo.tags.TagsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_tags】的数据库操作Service实现
 * @createDate 2024-10-10 18:38:55
 */
@RequiredArgsConstructor
@Service
public class SysTagsServiceImpl extends ServiceImpl<SysTagsMapper, SysTags>
        implements SysTagsService {

    @Override
    public PageResult<TagsVO> getTags(TagPageQueryParam param) {
        Page<SysTags> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysTags>()
                        .and(param.getSearchStr() != null,
                                item -> item
                                        .like(SysTags::getName, param.getSearchStr())
                        )
                        .orderByDesc(SysTags::getGmtCreate)
        );

        List<TagsVO> collect = page.getRecords().stream().map(item -> {
            TagsVO tagsVO = new TagsVO();
            tagsVO.setId(item.getId());
            tagsVO.setName(item.getName());
            tagsVO.setColor(item.getColor());
            return tagsVO;
        }).collect(Collectors.toList());

        return new PageResult<>(page.getTotal(), collect);
    }

    @Override
    public TagsVO getTagById(Long id) {
        SysTags sysTags = baseMapper.selectById(id);
        return new TagsVO(sysTags.getId(), sysTags.getName(), sysTags.getColor());
    }

}




