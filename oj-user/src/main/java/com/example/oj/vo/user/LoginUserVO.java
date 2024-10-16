package com.example.oj.vo.user;

import lombok.Data;

/**
 * @author 云海
 * @description
 * @createDate 2024/6/25 下午3:37
 */
@Data
public class LoginUserVO {
    private long userID;

    private String username;

    private String avatar;

    private int submitCount;

    private int acceptCount;
}
