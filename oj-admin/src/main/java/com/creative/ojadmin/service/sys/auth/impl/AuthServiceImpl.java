package com.creative.ojadmin.service.sys.auth.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.sys.auth.param.PasswordLoginParam;
import com.creative.ojadmin.controller.sys.auth.vo.LoginResultVO;
import com.creative.ojadmin.domain.SysUserDO;
import com.creative.ojadmin.service.sys.auth.IAuthService;
import com.creative.ojadmin.service.sys.user.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author LiChongWei
 * @date 2024/10/16 上午11:07
 * @description 登录接口实现类
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {

    private final SysUserService sysUserService;

    /**
     * 密码登录
     * @param param /
     * @return /
     */
    @Override
    public LoginResultVO passwordLogin(PasswordLoginParam param) {
        // 根据账号获取用户数据库信息
        SysUserDO dbUser = sysUserService.getUserByUserName(param.getAccount());
        if (dbUser == null) {
            // 用户不存在
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_USER_NOT_EXIST);
        }
        // 判断密码是否相同
        String md5Password = SecureUtil.md5(param.getPassword());
        if (!md5Password.equals(dbUser.getPassword())) {
            // 密码错误
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_PASSWORD_WRONG);
        }
        // 执行登录
        StpUtil.login(dbUser.getId());
        // 判断是否拥有管理员权限
        if (!StpUtil.hasRole("admin")) {
            StpUtil.logout(dbUser.getId());
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_USER_NOT_AUTHORIZED);
        }
        // 获取登录信息并封装
        LoginResultVO loginResultVO = new LoginResultVO();
        loginResultVO.setToken(StpUtil.getTokenValue());
        loginResultVO.setAccount(dbUser.getUsername());
        loginResultVO.setAvatar("proxy/"+dbUser.getAvatar());
        // 返回登录信息
        return loginResultVO;
    }
}
