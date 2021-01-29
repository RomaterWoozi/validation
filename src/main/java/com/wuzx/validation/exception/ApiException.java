package com.wuzx.validation.exception;


import com.wuzx.validation.enums.ResultCode;
import lombok.Getter;

/**
* @author WuZX
* 时间  2021/1/26 17:46
*  自定义异常类
*/
@Getter //只要getter方法，无需setter
public class ApiException extends RuntimeException {
    private int code;
    private String msg;

    public ApiException() {
        this(1001, "接口错误");
    }

    public ApiException(String msg) {
        this(1001, msg);
    }

    /**
    * @author WuZX
    * 时间  2021/1/29 14:28
    *  自定义异常信息
    */
    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public ApiException(ResultCode unauthorized) {

    }

    public ApiException(Exception e) {
        e.printStackTrace();
    }
}
