package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.DepotEntity;

import java.util.Map;


/**
 * 系统用户
 *
 */
public interface DepotService extends IService<DepotEntity> {
    PageUtils queryPage(Map<String, Object> params);
}
