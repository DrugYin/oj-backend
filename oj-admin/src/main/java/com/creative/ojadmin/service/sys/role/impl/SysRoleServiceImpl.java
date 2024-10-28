package com.creative.ojadmin.service.sys.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.sys.role.param.QueryRoleParam;
import com.creative.ojadmin.controller.sys.role.vo.RoleVO;
import com.creative.ojadmin.domain.SysRoleDO;
import com.creative.ojadmin.service.sys.role.SysRoleService;
import com.creative.ojadmin.mapper.SysRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Barbuda
* @description 针对表【sys_role】的数据库操作Service实现
* @createDate 2024-10-14 19:02:07
*/
@RequiredArgsConstructor
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleDO>
    implements SysRoleService{

    private final SysRoleMapper baseMapper;

    @Override
    public List<SysRoleDO> getRoleListByRoleIds(List<Long> roleIds) {
        return baseMapper.selectBatchIds(roleIds);
    }

    @Override
    public PageResult<RoleVO> pageQueryRole(QueryRoleParam param) {
        Page<SysRoleDO> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysRoleDO>()
                        .and(param.getSearchStr() != null,
                                item -> item.like(SysRoleDO::getName, param.getSearchStr())
                        )
                        .orderByAsc(SysRoleDO::getId)
        );
        List<RoleVO> collect = page.getRecords().stream().map(item -> {
            RoleVO roleVO = new RoleVO();
            roleVO.setId(item.getId());
            roleVO.setName(item.getName());
            roleVO.setCode(item.getCode());
            roleVO.setStatus(item.getState() == 1);
            return roleVO;
        }).toList();
        return new PageResult<>(collect.size(), collect);
    }
}




