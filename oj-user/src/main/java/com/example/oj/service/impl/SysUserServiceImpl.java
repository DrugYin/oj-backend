package com.example.oj.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.Utils.FileUtils;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysUser;
import com.example.oj.mapper.SysUserInfoMapper;
import com.example.oj.mapper.SysUserMapper;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.user.CreateUserInfoParam;
import com.example.oj.param.user.LoginParam;
import com.example.oj.param.user.RegisterParam;
import com.example.oj.service.SysUserService;
import com.example.oj.vo.user.LoginUserVO;
import com.example.oj.vo.user.LoginVO;
import com.example.oj.vo.user.RankVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2024-06-24 14:44:39
 */
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    private final SysUserInfoServiceImpl sysUserInfoServiceImpl;
    private final SysUserInfoMapper sysUserInfoMapper;

    /**
     * 注册
     *
     * @param param 注册参数
     */
    @Override
    public void register(RegisterParam param) throws Exception {
        // 判断用户名是否已存在
        long count = count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, param.getUsername())
        );
        if (count > 0) {
            throw new Exception("用户名已存在");
        }

        // 密码与重复密码是否一致
        if (!param.getPassword().equals(param.getRetryPassword())) {
            throw new Exception("密码与重复密码不一致");
        }

        // 添加用户数据
        SysUser user = new SysUser();
        user.setUsername(param.getUsername());
        user.setPassword(SecureUtil.md5(param.getPassword()));
//        user.setAvatar("https://userpic.codeforces.org/3820796/title/afbe7e7652d9c06e.jpg");
        save(user);
        CreateUserInfoParam createUserInfoParam = new CreateUserInfoParam();
        createUserInfoParam.setCustomName(param.getUsername());
        createUserInfoParam.setUserId(user.getId());
        sysUserInfoServiceImpl.createUserInfo(createUserInfoParam);
    }

    /**
     * 登录
     *
     * @param param 登录参数
     * @return 登录结果
     */
    @Override
    public LoginVO login(LoginParam param) throws Exception {
        // 判断用户名是否存在
        long count = count(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, param.getUsername())
        );
        if (count == 0) {
            throw new Exception("用户名不存在");
        }

        // 用户存在比对密码
        SysUser dbOne = getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, param.getUsername()));
        String md5Str = SecureUtil.md5(param.getPassword());
        if (!md5Str.equals(dbOne.getPassword())) {
            throw new Exception("密码错误，请重新输入");
        }

        // 登录成功，签发身份令牌
        // 执行登录，用户身份标识为 userId
        StpUtil.login(dbOne.getId());
        // 得到登录身份令牌
        String token = StpUtil.getTokenInfo().getTokenValue();
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        return loginVO;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @Override
    public LoginUserVO getUserInfo() {
        // 获取当前用户ID
        long userID = StpUtil.getLoginIdAsLong();
        // 查询用户信息
        SysUser dbUser = getById(userID);
        // 组装用户信息
        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setUserID(dbUser.getId());
        loginUserVO.setUsername(dbUser.getUsername());
        loginUserVO.setAvatar("api/"+dbUser.getAvatar());
        loginUserVO.setSubmitCount(dbUser.getSubmitCount());
        loginUserVO.setAcceptCount(dbUser.getAcceptCount());
        return loginUserVO;
    }

    @Override
    public void updateUserSubmitInfo(int status) {
        SysUser dbUser = getById(StpUtil.getLoginIdAsLong());
        dbUser.setSubmitCount(dbUser.getSubmitCount() + 1);
        if (status == 100) {
            dbUser.setAcceptCount(dbUser.getAcceptCount() + 1);
        }
        updateById(dbUser);
    }

    @Override
    public PageResult<RankVO> pageQuery(QueryPageParam param) {
        Page<SysUser> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysUser>()
                        .and(param.getSearchStr() != null,
                                item -> item.like(SysUser::getUsername, param.getSearchStr())
                        )
                        .orderByDesc(SysUser::getAcceptCount)
        );
        List<RankVO> collect = page.getRecords().stream().map(item -> {
            RankVO rankVO = new RankVO();
            rankVO.setAcceptCount(item.getAcceptCount());
            rankVO.setAvatar("\\api/" + item.getAvatar());
            rankVO.setSignature(sysUserInfoServiceImpl.getById(item.getId()).getSignature());
            rankVO.setSubmitCount(item.getSubmitCount());
            rankVO.setUsername(sysUserInfoMapper.selectById(item.getId()).getUserName());
            rankVO.setUserID(item.getId());
            return rankVO;
        }).collect(Collectors.toList());
        return new PageResult<>(page.getTotal(), collect);
    }

    @Override
    public void updateAvatar(MultipartFile file) throws IOException {
        Long userId = StpUtil.getLoginIdAsLong();
        SysUser dbUser = getById(userId);
        String imgName;
        if (dbUser.getAvatar() != null) {
            imgName = dbUser.getAvatar().substring(dbUser.getAvatar().lastIndexOf("/") + 1);
        } else {
            imgName = userId + UUID.randomUUID().toString() + FileUtils.getImageExtension(file);
        }
        System.out.println(imgName);
        String avatarSavePath = "D:\\Barbuda\\Project\\oj-backend\\img\\";
        FileUtils.saveMultipartFile(file, avatarSavePath + "avatar\\" + imgName);
        dbUser.setAvatar("image/avatar/" + imgName);
        updateById(dbUser);
    }

}




