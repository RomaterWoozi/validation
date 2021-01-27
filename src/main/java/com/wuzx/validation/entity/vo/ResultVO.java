package com.wuzx.validation.entity.vo;

import com.wuzx.validation.enums.ResultCode;
import lombok.Getter;

/**
* @author WuZX
* 时间  2021/1/27 12:31
* 数据统一响应
*/
@Getter
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
