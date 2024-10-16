package com.creative.ojadmin.service.auth;

import com.creative.ojadmin.controller.auth.param.PasswordLoginParam;
import com.creative.ojadmin.controller.auth.vo.LoginResultVO;

/**
 * @author LiChongWei
 * @date 2024/10/16 上午11:07
 * @description 登录接口
 */
public interface IAuthService {

    /**
     * 密码登录
     * @param param /
     * @return /
     */
    LoginResultVO passwordLogin(PasswordLoginParam param);

}
