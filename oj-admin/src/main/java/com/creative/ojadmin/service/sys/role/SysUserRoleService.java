package com.creative.ojadmin.service.sys.role;

import com.creative.ojadmin.controller.sys.role.param.GetRoleParam;
import com.creative.ojadmin.domain.SysUserRoleDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Barbuda
* @description 针对表【sys_user_role】的数据库操作Service
* @createDate 2024-10-14 19:05:19
*/
public interface SysUserRoleService extends IService<SysUserRoleDO> {

    List<Long> getRoleIdsByUserId(GetRoleParam param);

}
