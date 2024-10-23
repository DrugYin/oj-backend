package com.creative.ojadmin.service.sys.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.domain.SysUserDO;
import com.creative.ojadmin.service.sys.user.SysUserService;
import com.creative.ojadmin.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public SysUserDO getUserByUserName(String username) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUserDO>()
                .eq(SysUserDO::getUsername, username));
    }
}




