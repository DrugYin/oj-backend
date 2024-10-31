package com.creative.ojadmin.controller.sys.role;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.sys.role.param.*;
import com.creative.ojadmin.service.sys.role.SysRoleService;
import com.creative.ojadmin.service.sys.role.SysUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/14 下午7:08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final SysRoleService sysRoleService;
    private final SysUserRoleService sysUserRoleService;

    @GetMapping
    public ResponseResult<?> queryRole(QueryRoleParam param) {
        return ResponseResult.success(sysRoleService.pageQueryRole(param));
    }

    @GetMapping("/all")
    public ResponseResult<?> getAllRole() {
        return ResponseResult.success(sysRoleService.getAllRoles());
    }

    @SaCheckRole("admin")
    @PostMapping("/changeStatus")
    public ResponseResult<?> changeStatus(@RequestBody ChangeRoleStatusParam param) {
        sysRoleService.changeRoleStatus(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/create")
    public ResponseResult<?> createRole(@RequestBody CreateRoleParam param) {
        sysRoleService.createRole(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> updateRole(@RequestBody UpdateRoleParam param) {
        sysRoleService.updateRole(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> deleteRole(@RequestBody DeleteRoleParam param) {
        sysRoleService.deleteRole(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/user")
    public ResponseResult<?> getUserRole(@RequestBody GetRoleParam param) {
        return ResponseResult.success(sysRoleService.getRoleListByRoleIds(sysUserRoleService.getRoleIdsByUserId(param)));
    }

    @SaCheckRole("admin")
    @PostMapping("/user/update")
    public ResponseResult<?> updateUserRole(@RequestBody UpdateUserRoleParam param) {
        sysUserRoleService.updateUserRole(param);
        return ResponseResult.success("OK");
    }
}
