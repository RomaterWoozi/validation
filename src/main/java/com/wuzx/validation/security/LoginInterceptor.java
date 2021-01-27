package com.wuzx.validation.security;




import com.wuzx.validation.enums.ResultCode;
import com.wuzx.validation.exception.ApiException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements AsyncHandlerInterceptor {

    @Autowired
    private JwtManager jwtManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求头中获取token字符串并解析
        Claims claims = jwtManager.parse(request.getHeader("Authorization"));
        // 已登录就直接放行
        if (claims != null) {
            // 将我们之前放到token中的userId给存到上下文对象中
            UserContext.add(Long.parseLong(claims.getSubject()));
            return true;
        }

        // 走到这代表没有登录
        throw new ApiException(ResultCode.UNAUTHORIZED);
    }

}
