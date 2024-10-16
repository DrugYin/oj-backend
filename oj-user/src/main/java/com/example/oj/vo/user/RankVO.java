package com.example.oj.vo.user;

import lombok.Data;

/**
 * @author 云海
 * @description
 * @createDate 2024/7/18 上午11:00
 */
@Data
public class RankVO {

    private long userID;

    private String username;

    private String avatar;

    private String signature;

    private int submitCount;

    private int acceptCount;

}
