package com.example.oj.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.example.oj.common.model.Result;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.user.LoginParam;
import com.example.oj.param.user.RegisterParam;
import com.example.oj.param.user.UserInfoParam;
import com.example.oj.service.SysUserService;
import com.example.oj.service.impl.SysUserInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/25 下午1:36
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final SysUserService sysUserService;
    private final SysUserInfoServiceImpl sysUserInfoServiceImpl;

    /**
     * 注册
     *
     * @param param 注册参数
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result<?> register(@Valid @RequestBody RegisterParam param) throws Exception {
        sysUserService.register(param);
        return Result.success("注册成功");
    }

    /**
     * 登录
     *
     * @param param 登录参数
     * @return 登录结果
     */
    @PostMapping("/login")
    public Result<?> login(@Valid @RequestBody LoginParam param) throws Exception {
        return Result.success(sysUserService.login(param));
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @SaCheckLogin
    @GetMapping("/userInfo")
    public Result<?> getUserInfo() {
        return Result.success(sysUserService.getUserInfo());
    }

    @SaCheckLogin
    @GetMapping("/detailUserInfo")
    public Result<?> getDetailUserInfo() {
        return Result.success(sysUserInfoServiceImpl.getUserInfo());
    }

    @GetMapping("/updateSubmitInfo")
    public Result<?> updateUserSubmitInfo(@RequestParam("status") int status) {
        sysUserService.updateUserSubmitInfo(status);
        return Result.success("Ok");
    }

    @GetMapping("/rank")
    public Result<?> getRankPage(QueryPageParam param) {
        return Result.success(sysUserService.pageQuery(param));
    }

    @SaCheckLogin
    @PostMapping("/avatar")
    public Result<?> updateAvatar(@RequestParam("file") MultipartFile file) throws IOException {
        sysUserService.updateAvatar(file);
        return Result.success("Ok");
    }

    @PostMapping("/updateUserInfo")
    public Result<?> updateUserInfo(@Valid @RequestBody UserInfoParam params) throws Exception {
        sysUserInfoServiceImpl.updateUserInfo(params);
        return Result.success("Ok");
    }

    @GetMapping("/submitData")
    public Result<?> getSubmitData() {
        return Result.success(sysUserInfoServiceImpl.getSubmitData());
    }

}
