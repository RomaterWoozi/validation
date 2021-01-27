package com.wuzx.validation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuzx.validation.entity.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ResourceMapper extends BaseMapper<Resource> {
    /**
     * 根据用户id获取权限id
     * @param userId 用户id
     * @return 权限id集合
     */
    Set<Long> selectIdsByUserId(Long userId);

    /**
     * 根据用户id获取该用户的所有权限资源对象
     * @param userId 用户id
     * @return 权限资源集合
     */
    List<Resource> selectListByUserId(Long userId);
}
