package com.creative.ojadmin.service.sys.user.impl;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.controller.sys.user.param.QueryUserParam;
import com.creative.ojadmin.controller.sys.user.param.ResetUserPasswordParam;
import com.creative.ojadmin.controller.sys.user.param.UpdateUserBaseInfoParam;
import com.creative.ojadmin.controller.sys.user.vo.UserVO;
import com.creative.ojadmin.domain.SysUserDO;
import com.creative.ojadmin.domain.SysUserInfoDO;
import com.creative.ojadmin.mapper.SysUserInfoMapper;
import com.creative.ojadmin.service.sys.user.SysUserInfoService;
import com.creative.ojadmin.service.sys.user.SysUserService;
import com.creative.ojadmin.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2024-10-16 10:34:10
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO>
        implements SysUserService {

    private final SysUserMapper baseMapper;
    private final SysUserInfoMapper sysUserInfoMapper;
    private final SysUserInfoService sysUserInfoService;

    @Override
    public SysUserDO getUserByUserName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUserDO>()
                .eq(SysUserDO::getUsername, username));
    }

    @Override
    public PageResult<UserVO> pageQueryUser(QueryUserParam param) {
        List<Long> userIds = baseMapper.selectList(new LambdaQueryWrapper<SysUserDO>()
                .and(param.getSearchStr() != null,
                        item -> item
                                .like(SysUserDO::getUsername, param.getSearchStr())
                )
                .orderByAsc(SysUserDO::getId)
                .select(SysUserDO::getId)
        ).stream().map(SysUserDO::getId).collect(Collectors.toList());
        if (userIds.isEmpty()){
            userIds.add(0L);
        }
        List<Long> userInfoIds = sysUserInfoMapper.selectList(new LambdaQueryWrapper<SysUserInfoDO>()
                .and(param.getSearchStr() != null,
                        item -> item
                                .like(SysUserInfoDO::getUserName, param.getSearchStr())
                )
                .orderByAsc(SysUserInfoDO::getId)
                .select(SysUserInfoDO::getId)
        ).stream().map(SysUserInfoDO::getId).collect(Collectors.toList());
        if (userInfoIds.isEmpty()){
            userInfoIds.add(0L);
        }
        Page<SysUserDO> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysUserDO>()
                        .in(SysUserDO::getId, userIds)
                        .or()
                        .in(SysUserDO::getId, userInfoIds)
                        .orderByAsc(SysUserDO::getId)
        );
        List<UserVO> collect = page.getRecords().stream().map(item -> {
            UserVO userVO = new UserVO();
            userVO.setId(item.getId());
            userVO.setAccount(item.getUsername());
            userVO.setNickname(sysUserInfoService.getUserInfoByUserId(item.getId()).getUserName());
            userVO.setAvatar("\\api/" + item.getAvatar());
            userVO.setCreateTime(LocalDate.from(item.getGmtCreate()));
            return userVO;
        }).toList();
        return new PageResult<>(collect.size(), collect);
    }

    @Override
    public void resetPassword(ResetUserPasswordParam param) {
        SysUserDO user = baseMapper.selectById(param.getUserId());
        if (user == null) {
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_USER_NOT_EXIST);
        }
        user.setPassword(SecureUtil.md5("12345678"));
        user.setGmtModified(LocalDateTime.now());
        updateById(user);
    }

    @Override
    public void updateUserBaseInfo(UpdateUserBaseInfoParam param) {
        SysUserDO sysUserDO = baseMapper.selectById(param.getUserId());
        if (sysUserDO == null) {
            throw new ServiceException(GlobalErrorCodeEnum.LOGIN_USER_NOT_EXIST);
        }
        if (!param.getAccount().equals(sysUserDO.getUsername())  && getUserByUserName(param.getAccount()) != null) {
            throw new ServiceException(GlobalErrorCodeEnum.USERNAME_ALREADY_EXIST);
        }
        SysUserInfoDO sysUserInfoDO = sysUserInfoMapper.selectById(param.getUserId());
        sysUserDO.setUsername(param.getAccount());
        sysUserInfoDO.setUserName(param.getNickname());
        updateById(sysUserDO);
        sysUserInfoMapper.updateById(sysUserInfoDO);
    }
}




