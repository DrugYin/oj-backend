package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysNotice;
import com.example.oj.mapper.SysNoticeMapper;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.service.SysNoticeService;
import com.example.oj.vo.notice.NoticeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_notice】的数据库操作Service实现
 * @createDate 2024-06-06 16:16:08
 */
@RequiredArgsConstructor
@Service
public class SysNoticeServiceImpl1 extends ServiceImpl<SysNoticeMapper, SysNotice>
        implements SysNoticeService {

    @Override
    public PageResult<NoticeVO> pageQuery(QueryPageParam param) {
        // 分页查询
        Page<SysNotice> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysNotice>().orderByAsc(SysNotice::getGmtCreate)
        );
        // 数据转换，使用stream流
        List<NoticeVO> collect = page.getRecords().stream().map(item -> {
            NoticeVO noticeVO = new NoticeVO();
            noticeVO.setId(item.getId());
            noticeVO.setTitle(item.getTitle());
            noticeVO.setContent(item.getContent());
            noticeVO.setGmtCreate(item.getGmtCreate());
            return noticeVO;
        }).collect(Collectors.toList());
        return new PageResult<>(page.getTotal(), collect);
    }
}
