package com.wuzx.validation.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuzx.validation.entity.LoginParam;
import com.wuzx.validation.entity.User;
import com.wuzx.validation.entity.vo.UserVO;


public interface UserService extends IService<User> {

    /**
    * @author WuZX
    * 时间  2021/1/26 17:18
    * 添加用户
    */
    String addUser(User user);

    /**
    * @author WuZX
    * 时间  2021/1/26 17:55
    *
    */
    UserVO login(LoginParam user);
}
