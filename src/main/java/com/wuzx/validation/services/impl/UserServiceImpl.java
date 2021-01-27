package com.wuzx.validation.services.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuzx.validation.entity.LoginParam;
import com.wuzx.validation.entity.User;
import com.wuzx.validation.entity.vo.UserVO;
import com.wuzx.validation.exception.ApiException;
import com.wuzx.validation.mapper.UserMapper;
import com.wuzx.validation.security.JwtManager;
import com.wuzx.validation.services.ResourceService;
import com.wuzx.validation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private ResourceService resourceService;

    @Override
    public String addUser(User user) {
        return "Success";
    }

    @Override
    public UserVO login(LoginParam loginParam) {
        User user = this.lambdaQuery()
                .eq(User::getUsername, loginParam.getUsername())
                .eq(User::getPassword, loginParam.getPassword())
                .one();
        if (user == null) {
            throw new ApiException("账号或密码错误");
        }
        UserVO userVO = new UserVO();
        try{
            userVO.setId(user.getId())
                    .setUsername(loginParam.getUsername())
                    .setToken(jwtManager.generate(userVO.getId()))
                    .setResourceIds(resourceService.getIdsByUserId(user.getId()));
        }catch (Exception e){
            throw new ApiException(e);
        }

        return userVO;
    }
}
