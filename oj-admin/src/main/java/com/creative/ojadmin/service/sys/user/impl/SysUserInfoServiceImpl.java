package com.creative.ojadmin.service.sys.user.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.domain.SysUserInfoDO;
import com.creative.ojadmin.service.sys.user.SysUserInfoService;
import com.creative.ojadmin.mapper.SysUserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author Barbuda
* @description 针对表【sys_user_info】的数据库操作Service实现
* @createDate 2024-10-29 19:33:59
*/
@Service
@RequiredArgsConstructor
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfoDO>
    implements SysUserInfoService{

    private final SysUserInfoMapper baseMapper;

    @Override
    public SysUserInfoDO getUserInfoByUserId(Long userId) {
        return baseMapper.selectById(userId);
    }
}




