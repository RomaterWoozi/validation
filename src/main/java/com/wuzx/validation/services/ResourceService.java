package com.wuzx.validation.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuzx.validation.entity.Resource;


import java.util.Set;

public interface ResourceService extends IService<Resource> {
    
    /**
    * @author WuZX
    * 时间  2021/1/26 18:36
    *
    */
    Set<Long> getIdsByUserId(Long id);
}
