package com.wuzx.validation.controller;

import com.wuzx.validation.entity.vo.ResultVO;
import com.wuzx.validation.enums.ResultCode;
import com.wuzx.validation.exception.ApiException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
* @author WuZX
* 时间  2021/1/26 17:32
*  spring boot 全局异常处理
*/
@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(ApiException.class)
    public ResultVO<String> APIExceptionHandler(ApiException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError=e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,objectError.getDefaultMessage());

    }
}
