package com.creative.ojadmin.service.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.controller.role.param.GetRoleParam;
import com.creative.ojadmin.controller.role.vo.RoleVO;
import com.creative.ojadmin.domain.SysRoleDO;
import com.creative.ojadmin.domain.SysUserRoleDO;
import com.creative.ojadmin.service.role.SysUserRoleService;
import com.creative.ojadmin.mapper.SysUserRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}




