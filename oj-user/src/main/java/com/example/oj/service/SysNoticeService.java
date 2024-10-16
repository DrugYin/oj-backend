package com.example.oj.service;

import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.param.notice.CreateNoticeParam;
import com.example.oj.param.notice.DeleteNoticeParam;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.notice.UpdateNoticeParam;
import com.example.oj.vo.notice.NoticeVO;

/**
 * @author Barbuda
 * @description 针对表【sys_notice】的数据库操作Service
 * @createDate 2024-06-06 16:16:08
 */
public interface SysNoticeService extends IService<SysNotice> {

    /**
     * 创建公告
     *
     * @param param /
     */
    void createNotice(CreateNoticeParam param);

    /**
     * 删除公告
     *
     * @param param /
     */
    void deleteNotice(DeleteNoticeParam param);

    /**
     * 更新公告
     *
     * @param param /
     */
    void updateNotice(UpdateNoticeParam param);

    /**
     * 分页查询
     *
     * @param param /
     * @return /
     */
    PageResult<NoticeVO> pageQuery(QueryPageParam param);
}
