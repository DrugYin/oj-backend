package com.creative.ojadmin.service.home.notice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.controller.home.notice.param.CreateNoticeParam;
import com.creative.ojadmin.controller.home.notice.param.DeleteNoticeParam;
import com.creative.ojadmin.controller.home.notice.param.UpdateNoticeParam;
import com.creative.ojadmin.domain.SysNoticeDO;
import com.creative.ojadmin.service.home.notice.SysNoticeService;
import com.creative.ojadmin.mapper.SysNoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author Barbuda
* @description 针对表【sys_notice】的数据库操作Service实现
* @createDate 2024-10-21 19:07:49
*/
@Service
@Slf4j
@RequiredArgsConstructor
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNoticeDO>
    implements SysNoticeService{

    private final SysNoticeMapper baseMapper;

    @Override
    public void deleteNoticeById(DeleteNoticeParam param) {
        removeById(param.getId());
    }

    @Override
    public void createNotice(CreateNoticeParam param) {
        SysNoticeDO noticeDO = new SysNoticeDO();
        noticeDO.setTitle(param.getTitle());
        noticeDO.setContent(param.getContent());
        noticeDO.setGmtCreate(LocalDateTime.now());
        noticeDO.setGmtModified(LocalDateTime.now());
        save(noticeDO);
    }

    @Override
    public void updateNotice(UpdateNoticeParam param) {
        SysNoticeDO noticeDO = baseMapper.selectById(param.getId());
        noticeDO.setTitle(param.getTitle());
        noticeDO.setContent(param.getContent());
        noticeDO.setGmtModified(LocalDateTime.now());
        updateById(noticeDO);
    }
}




