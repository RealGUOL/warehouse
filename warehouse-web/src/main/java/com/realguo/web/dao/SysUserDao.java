package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.realguo.web.entity.SysUserEntity;
import org.springframework.stereotype.Repository;


/**
 * 用户表
 */
@Repository
public interface SysUserDao extends BaseMapper<SysUserEntity> {
}
