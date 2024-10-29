package com.creative.ojadmin.controller.sys.role;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.sys.role.param.*;
import com.creative.ojadmin.service.sys.role.SysRoleService;
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

    @GetMapping
    public ResponseResult<?> queryRole(QueryRoleParam param) {
        return ResponseResult.success(sysRoleService.pageQueryRole(param));
    }

    @PostMapping("/changeStatus")
    public ResponseResult<?> changeStatus(@RequestBody ChangeRoleStatusParam param) {
        sysRoleService.changeRoleStatus(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/create")
    public ResponseResult<?> createRole(@RequestBody CreateRoleParam param) {
        sysRoleService.createRole(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/update")
    public ResponseResult<?> updateRole(@RequestBody UpdateRoleParam param) {
        sysRoleService.updateRole(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/delete")
    public ResponseResult<?> deleteRole(@RequestBody DeleteRoleParam param) {
        sysRoleService.deleteRole(param);
        return ResponseResult.success("OK");
    }
}
