package com.wuzx.validation.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends BaseEntity{

    @NotNull(message = "用户账号不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String username;


    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;


    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
