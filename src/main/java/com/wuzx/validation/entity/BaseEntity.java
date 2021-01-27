package com.wuzx.validation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public abstract class BaseEntity {
    /**
     * 主键
     */
    @NotNull(message = "用户id不能为空")
    @TableId(type = IdType.AUTO)
    private Long id;

}
