package com.creative.ojadmin.service.user;

import com.creative.ojadmin.domain.SysUserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2024-10-16 10:34:10
*/
public interface SysUserService extends IService<SysUserDO> {

    /**
     * 根据用户名获取用户
     * @param username /
     * @return /
     */
    SysUserDO getUserByUserName(String username);

}
