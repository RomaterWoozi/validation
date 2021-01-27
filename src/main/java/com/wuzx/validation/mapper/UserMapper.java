package com.wuzx.validation.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuzx.validation.entity.User;
import com.wuzx.validation.entity.vo.UserPageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {



    /**
     * 查询用户分页信息
     * @param page 分页条件
     * @param wrapper 查询条件
     * @return 分页对象
     */

    IPage<UserPageVO> selectPage(Page<UserPageVO> page, @Param(Constants.WRAPPER) Wrapper<UserPageVO> wrapper);
}
