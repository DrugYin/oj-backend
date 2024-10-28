package com.creative.ojadmin.service.sys.role;

import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.sys.role.param.QueryRoleParam;
import com.creative.ojadmin.controller.sys.role.vo.RoleVO;
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

    PageResult<RoleVO> pageQueryRole(QueryRoleParam param);

}
