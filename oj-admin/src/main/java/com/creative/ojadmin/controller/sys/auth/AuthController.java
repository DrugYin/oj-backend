package com.creative.ojadmin.controller.sys.auth;

import cn.dev33.satoken.annotation.SaIgnore;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.sys.auth.param.PasswordLoginParam;
import com.creative.ojadmin.service.sys.auth.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/14 下午6:41
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final  IAuthService authService;

    /**
     * 密码登录
     * @param param /
     * @return /
     */
    @SaIgnore
    @PostMapping("/login")
    public ResponseResult<?> login(@Valid @RequestBody PasswordLoginParam param) {
        return ResponseResult.success(authService.passwordLogin(param));
    }

}
