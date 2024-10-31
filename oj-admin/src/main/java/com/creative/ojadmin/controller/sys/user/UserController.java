package com.creative.ojadmin.controller.sys.user;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.sys.user.param.QueryUserParam;
import com.creative.ojadmin.controller.sys.user.param.ResetUserPasswordParam;
import com.creative.ojadmin.controller.sys.user.param.UpdateUserBaseInfoParam;
import com.creative.ojadmin.service.sys.user.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @date 2024/10/29 19:55
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final SysUserService sysUserService;

    @GetMapping
    public ResponseResult<?> getUsers(QueryUserParam param) {
        return ResponseResult.success(sysUserService.pageQueryUser(param));
    }

    @SaCheckRole("admin")
    @PostMapping("/resetPassword")
    public ResponseResult<?> resetUserPassword(@RequestBody ResetUserPasswordParam param) {
        sysUserService.resetPassword(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> updateUserBaseInfo(@RequestBody UpdateUserBaseInfoParam param) {
        sysUserService.updateUserBaseInfo(param);
        return ResponseResult.success("OK");
    }

}
