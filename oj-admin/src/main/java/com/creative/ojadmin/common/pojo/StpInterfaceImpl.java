package com.creative.ojadmin.common.pojo;

import cn.dev33.satoken.stp.StpInterface;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.role.param.GetRoleParam;
import com.creative.ojadmin.domain.SysRoleDO;
import com.creative.ojadmin.service.role.SysRoleService;
import com.creative.ojadmin.service.role.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiChongWei
 * @date 2024/10/17 13:42
 * @description
 */
@Component
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {

    private final SysRoleService sysRoleService;
    private final SysUserRoleService sysUserRoleService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return List.of();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        Long userId = Long.parseLong(loginId.toString());
        List<Long> roleIds = sysUserRoleService.getRoleIdsByUserId(new GetRoleParam(userId));
        if (roleIds.isEmpty()) {
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_USER_NOT_AUTHORIZED);
        }
        List<SysRoleDO> roleDOs = sysRoleService.getRoleListByRoleIds(roleIds);
        List<String> roleList = new ArrayList<>();
        roleDOs.forEach(roleDO -> roleList.add(roleDO.getCode()));
        System.out.println(roleList);
        return roleList;
    }
}
