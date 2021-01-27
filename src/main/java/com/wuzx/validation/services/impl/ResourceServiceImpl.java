package com.wuzx.validation.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuzx.validation.entity.Resource;
import com.wuzx.validation.mapper.ResourceMapper;
import com.wuzx.validation.services.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {
    
    /**
    * @author WuZX
    * 时间  2021/1/26 18:48
    * 
    */
    @Override
    public Set<Long> getIdsByUserId(Long userId) {
        return baseMapper.selectIdsByUserId(userId);
    }
}
