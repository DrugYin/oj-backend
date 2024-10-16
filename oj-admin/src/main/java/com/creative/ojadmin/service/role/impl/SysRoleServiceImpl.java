package com.creative.ojadmin.service.role.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.domain.SysRoleDO;
import com.creative.ojadmin.service.role.SysRoleService;
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
}




