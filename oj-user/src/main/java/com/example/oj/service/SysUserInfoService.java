package com.example.oj.service;

import com.example.oj.domain.SysUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.param.user.CreateUserInfoParam;
import com.example.oj.param.user.UserInfoParam;
import com.example.oj.vo.user.SubmitDataVO;
import com.example.oj.vo.user.UserInfoVO;

/**
 * @author Barbuda
 * @description 针对表【sys_user_info】的数据库操作Service
 * @createDate 2024-09-19 15:06:46
 */
public interface SysUserInfoService extends IService<SysUserInfo> {
    void updateUserInfo(UserInfoParam userInfoParam);

    UserInfoVO getUserInfo();

    void createUserInfo(CreateUserInfoParam param);

    void submitInfoChange(long userId, String problemId, int status);

    SubmitDataVO getSubmitData();

}
