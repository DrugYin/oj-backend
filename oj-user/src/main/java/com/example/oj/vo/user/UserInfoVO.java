package com.example.oj.vo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author 云海
 * @description
 * @createDate 2024/9/19 下午5:59
 */
@Data
public class UserInfoVO {

    private long userId;

    private String username;

    private String email;

    private String phone;

    private String signature;

    private String biography;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8", locale = "zh")
    private LocalDate birthday;

    private String submit_problem;
}
