package com.creative.ojadmin.service.sys.user;

import com.creative.ojadmin.common.pojo.PageResult;
import com.creative.ojadmin.domain.SysUserInfoDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_user_info】的数据库操作Service
* @createDate 2024-10-29 19:34:00
*/
public interface SysUserInfoService extends IService<SysUserInfoDO> {

    SysUserInfoDO getUserInfoByUserId(Long userId);

}
