package com.creative.ojadmin.service.sys.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.sys.role.param.*;
import com.creative.ojadmin.controller.sys.role.vo.RoleVO;
import com.creative.ojadmin.domain.SysRoleDO;
import com.creative.ojadmin.service.sys.role.SysRoleService;
import com.creative.ojadmin.mapper.SysRoleMapper;
import com.creative.ojadmin.service.sys.role.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private final SysUserRoleService sysUserRoleService;

    @Override
    public List<SysRoleDO> getRoleListByRoleIds(List<Long> roleIds) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysRoleDO>()
                .in(SysRoleDO::getId, roleIds)
                .eq(SysRoleDO::getState, 1)
        );
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

    @Override
    public void changeRoleStatus(ChangeRoleStatusParam param) {
        SysRoleDO sysRoleDO = baseMapper.selectById(param.getId());
        if (sysRoleDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_NOT_EXIST);
        }
        if (sysRoleDO.getCode().equals("admin")) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_ADMIN_CANNOT_SET);
        }
        sysRoleDO.setState(param.isStatus()? 1 : 0);
        sysRoleDO.setGmtModified(LocalDateTime.now());
        updateById(sysRoleDO);
    }

    @Override
    public void deleteRole(DeleteRoleParam param) {
        SysRoleDO sysRoleDO = baseMapper.selectById(param.getId());
        if (sysRoleDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_NOT_EXIST);
        }
        if (sysRoleDO.getCode().equals("admin")) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_ADMIN_CANNOT_DELETE);
        }
        removeById(sysRoleDO);
        sysUserRoleService.deleteByRoleId(param.getId());
    }

    @Override
    public void createRole(CreateRoleParam param) {
        check(param);
        SysRoleDO sysRoleDO = new SysRoleDO();
        sysRoleDO.setName(param.getName());
        sysRoleDO.setCode(param.getCode());
        sysRoleDO.setState(1);
        sysRoleDO.setGmtCreate(LocalDateTime.now());
        sysRoleDO.setGmtModified(LocalDateTime.now());
        save(sysRoleDO);
    }

    @Override
    public void updateRole(UpdateRoleParam param) {
        SysRoleDO sysRoleDO = baseMapper.selectById(param.getId());
        if (sysRoleDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_NOT_EXIST);
        }
        if (sysRoleDO.getCode().equals("admin")) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_ADMIN_CANNOT_SET);
        }
        sysRoleDO.setName(param.getName());
        sysRoleDO.setCode(param.getCode());
        sysRoleDO.setGmtModified(LocalDateTime.now());
        updateById(sysRoleDO);
    }

    private void check(CreateRoleParam param) {
        SysRoleDO sysRoleDO = baseMapper.selectOne(new LambdaQueryWrapper<SysRoleDO>().eq(SysRoleDO::getCode, param.getCode()));
        if (sysRoleDO != null) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_CODE_ALREADY_EXIST);
        }
        sysRoleDO = baseMapper.selectOne(new LambdaQueryWrapper<SysRoleDO>().eq(SysRoleDO::getName, param.getName()));
        if (sysRoleDO != null) {
            throw new ServiceException(GlobalErrorCodeEnum.ROLE_ALREADY_EXIST);
        }
    }
}




