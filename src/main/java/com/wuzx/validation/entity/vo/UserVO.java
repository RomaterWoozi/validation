package com.wuzx.validation.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.PackagePrivate;

import java.util.Set;

@Data
@Accessors(chain = true)
public class UserVO {

    private Long id;

    private String username;


    private String password;

    private String token;

    private Set<Long> resourceIds;
}
