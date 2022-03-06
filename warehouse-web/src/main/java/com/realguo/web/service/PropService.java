package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.entity.SysUserEntity;

import java.util.Map;


/**
 * 系统用户
 *
 */
public interface PropService extends IService<PropEntity> {
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存道具
     */
    void save(PropEntity propEntity);
}
