package com.creative.ojadmin.service.sys.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.controller.sys.role.param.GetRoleParam;
import com.creative.ojadmin.controller.sys.role.param.UpdateUserRoleParam;
import com.creative.ojadmin.domain.SysUserRoleDO;
import com.creative.ojadmin.service.sys.role.SysUserRoleService;
import com.creative.ojadmin.mapper.SysUserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Barbuda
* @description 针对表【sys_user_role】的数据库操作Service实现
* @createDate 2024-10-14 19:05:19
*/
@RequiredArgsConstructor
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleDO>
    implements SysUserRoleService{

    private final SysUserRoleMapper baseMapper;

    @Override
    public List<Long> getRoleIdsByUserId(GetRoleParam param) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysUserRoleDO>()
                .eq(SysUserRoleDO::getUserId, param.getUserId())
                .select(SysUserRoleDO::getRoleId)
        ).stream().map(SysUserRoleDO::getRoleId).collect(Collectors.toList());
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        baseMapper.delete(new LambdaQueryWrapper<SysUserRoleDO>().eq(SysUserRoleDO::getRoleId, roleId));
    }

    @Override
    public void updateUserRole(UpdateUserRoleParam param) {
        baseMapper.delete(new LambdaQueryWrapper<SysUserRoleDO>()
                .eq(SysUserRoleDO::getUserId, param.getUserId())
        );
        for (Long roleId : param.getRoleIds()) {
            SysUserRoleDO sysUserRoleDO = new SysUserRoleDO();
            sysUserRoleDO.setUserId(param.getUserId());
            sysUserRoleDO.setRoleId(roleId);
            sysUserRoleDO.setGmtCreate(LocalDateTime.now());
            sysUserRoleDO.setGmtModified(LocalDateTime.now());
            save(sysUserRoleDO);
        }
    }
}




