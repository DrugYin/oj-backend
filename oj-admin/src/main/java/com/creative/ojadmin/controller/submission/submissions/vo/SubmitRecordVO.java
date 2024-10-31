package com.creative.ojadmin.controller.submission.submissions.vo;

import lombok.Data;

/**
 * @author LiChongWei
 * @date 2024/10/30 18:15
 * @description
 */
@Data
public class SubmitRecordVO {

    private long accept = 0;

    private long wrongAnswer = 0;

    private long timeLimitExceeded = 0;

    private long memoryLimitExceeded = 0;

    private long compileError = 0;

    private long otherError = 0;

    private long total = 0;

}
