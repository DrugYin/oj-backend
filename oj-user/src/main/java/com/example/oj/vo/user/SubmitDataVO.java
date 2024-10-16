package com.example.oj.vo.user;

import lombok.Data;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/9 下午5:16
 */
@Data
public class SubmitDataVO {

    private long accept;

    private long wrongAnswer;

    private long timeLimitExceeded;

    private long memoryLimitExceeded;

    private long compileError;

    private long otherError;

    private long total;

}
