package com.creative.ojadmin.service.sys.role;

import com.creative.ojadmin.domain.SysRoleDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Barbuda
* @description 针对表【sys_role】的数据库操作Service
* @createDate 2024-10-14 19:02:07
*/
public interface SysRoleService extends IService<SysRoleDO> {

    List<SysRoleDO> getRoleListByRoleIds(List<Long> roleIds);

}
