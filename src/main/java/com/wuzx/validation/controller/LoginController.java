package com.wuzx.validation.controller;

import com.wuzx.validation.entity.LoginParam;
import com.wuzx.validation.entity.vo.UserVO;
import com.wuzx.validation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API/user")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @author WuZX
     * 时间  2021/1/26 17:30
     * @RequestBody @Validated
     *  Validator + 自动抛出异常
     */
    @PostMapping
    public UserVO login(@RequestBody @Validated LoginParam user){
        System.out.println("LoginController login");
        return userService.login(user);
    }



}
