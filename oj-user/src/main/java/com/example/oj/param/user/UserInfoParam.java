package com.example.oj.param.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author 云海
 * @description
 * @createDate 2024/9/19 下午5:46
 */
@Data
public class UserInfoParam {
    @NotBlank(message = "用户名不能为空")
    private String customName;

    @Email(message = "请输入正确的邮箱地址")
    private String email;

    @Length(max = 11, message = "请输入正确的手机号码", min = 11)
    private String phone;

    @Length(max = 100, message = "个人简介长度不能超过100个字符")
    private String biography;

    @Length(max = 50, message = "个性签名长度不能超过50个字符")
    private String signature;

    private String birthday;
}
