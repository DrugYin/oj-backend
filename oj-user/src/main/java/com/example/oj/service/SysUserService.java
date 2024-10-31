package com.example.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysUser;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.user.LoginParam;
import com.example.oj.param.user.RegisterParam;
import com.example.oj.param.user.ResetPasswordParam;
import com.example.oj.vo.user.LoginUserVO;
import com.example.oj.vo.user.LoginVO;
import com.example.oj.vo.user.RankVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Barbuda
 * @description 针对表【sys_user】的数据库操作Service
 * @createDate 2024-06-24 14:44:39
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 用户注册
     *
     * @param param 注册参数
     */
    void register(RegisterParam param) throws Exception;

    /**
     * 用户登录
     *
     * @param param 登录参数
     * @return 登录结果
     */
    LoginVO login(LoginParam param) throws Exception;

    LoginUserVO getUserInfo();

    void resetPassword(ResetPasswordParam param) throws Exception;

    void updateUserSubmitInfo(int status);

    PageResult<RankVO> pageQuery(QueryPageParam param);

    void updateAvatar(MultipartFile file) throws IOException;
}
