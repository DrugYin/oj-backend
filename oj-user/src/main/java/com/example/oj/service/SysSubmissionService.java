package com.example.oj.service;

import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysSubmission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.submission.SubmitCodeParam;
import com.example.oj.vo.submission.SubmissionVO;
import com.example.oj.vo.submission.SubmitCodeVO;

/**
 * @author Barbuda
 * @description 针对表【sys_submission】的数据库操作Service
 * @createDate 2024-07-31 16:54:53
 */
public interface SysSubmissionService extends IService<SysSubmission> {
    SubmitCodeVO submitCode(SubmitCodeParam param);

    PageResult<SubmissionVO> pageQuery(QueryPageParam param);

    PageResult<SubmissionVO> problemSubmitPageQuery(QueryPageParam param);

    PageResult<SubmissionVO> userSubmitPageQuery(QueryPageParam param);
}
