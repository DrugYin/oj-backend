package com.example.oj.vo.submission;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 云海
 * @description
 * @createDate 2024/7/17 下午1:51
 */
@Data
public class SubmissionVO {
    private long userId;

    private String username;

    private long submissionId;

    private long problemId;

    private String problemTitle;

    private String customId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private LocalDateTime submitTime;

    private long status;

    private int runTime;

    private int runMemory;

    private int caseNumber;

    private int acNumber;

    private int languageId;

    private String code;
}
