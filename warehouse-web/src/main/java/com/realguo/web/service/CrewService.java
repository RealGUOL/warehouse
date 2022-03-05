package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.SysUserEntity;

import java.util.Map;


/**
 * 系统用户
 *
 */
public interface CrewService extends IService<CrewEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
