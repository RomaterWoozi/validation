package com.wuzx.validation.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginParam {

    @NotBlank
    @Length(min = 4, max = 12, message = "用户名长度为4-12位")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Length(min = 4, max = 12, message = "密码长度为4-12位")
    private String password;
}
