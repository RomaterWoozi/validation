package com.wuzx.validation.controller;

import com.wuzx.validation.entity.User;
import com.wuzx.validation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user){
           return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User getUser(){
        User user=new User();
        user.setId(1L);
        user.setUsername("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }







}
