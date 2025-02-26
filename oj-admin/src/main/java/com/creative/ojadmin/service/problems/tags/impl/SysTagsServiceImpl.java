package com.creative.ojadmin.service.problems.tags.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.problems.tags.TagsController;
import com.creative.ojadmin.controller.problems.tags.param.CreateTagParam;
import com.creative.ojadmin.controller.problems.tags.param.DeleteTagParam;
import com.creative.ojadmin.controller.problems.tags.param.UpdateTagParam;
import com.creative.ojadmin.controller.problems.tags.vo.TagVO;
import com.creative.ojadmin.domain.SysTagsDO;
import com.creative.ojadmin.service.problems.tags.SysTagsService;
import com.creative.ojadmin.mapper.SysTagsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
* @author Barbuda
* @description 针对表【sys_tags】的数据库操作Service实现
* @createDate 2024-10-23 18:57:16
*/
@Service
@RequiredArgsConstructor
public class SysTagsServiceImpl extends ServiceImpl<SysTagsMapper, SysTagsDO>
    implements SysTagsService{

    private final SysTagsMapper baseMapper;

    @Override
    public void createTag(CreateTagParam param) {
        SysTagsDO tagDO = baseMapper.selectOne(new LambdaQueryWrapper<SysTagsDO>()
                .eq(SysTagsDO::getName, param.getName())
        );
        if (tagDO != null) {
            throw new ServiceException(GlobalErrorCodeEnum.TAG_ALREADY_EXIST);
        }
        tagDO = new SysTagsDO();
        tagDO.setName(param.getName());
        tagDO.setColor(param.getColor());
        tagDO.setGmtCreate(LocalDateTime.now());
        tagDO.setGmtModified(LocalDateTime.now());
        save(tagDO);
    }

    @Override
    public void updateTag(UpdateTagParam param) {
        SysTagsDO tagDO = baseMapper.selectById(param.getId());
        if (tagDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.TAG_NOT_EXIST);
        }
        tagDO.setName(param.getName());
        tagDO.setColor(param.getColor());
        tagDO.setGmtModified(LocalDateTime.now());
        updateById(tagDO);
    }

    @Override
    public void deleteTag(DeleteTagParam param) {
        SysTagsDO tagDO = baseMapper.selectById(param.getId());
        if (tagDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.TAG_NOT_EXIST);
        }
        removeById(param.getId());
    }

    @Override
    public List<TagVO> getAllTags() {
        List<SysTagsDO> tagsDOS = baseMapper.selectList(new LambdaQueryWrapper<SysTagsDO>()
                .orderByAsc(SysTagsDO::getId)
        );
        return tagsDOS.stream().map(item -> {
            TagVO tagVO = new TagVO();
            tagVO.setId(item.getId());
            tagVO.setName(item.getName());
            tagVO.setColor(item.getColor());
            return tagVO;
        }).toList();
    }
}




