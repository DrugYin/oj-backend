package com.creative.ojadmin.controller.sys.role;

import com.creative.ojadmin.service.sys.role.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
