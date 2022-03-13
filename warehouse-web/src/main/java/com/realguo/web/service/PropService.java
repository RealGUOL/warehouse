package com.realguo.web.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.vo.PropVO;

import java.util.List;
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

    List<PropVO> selectListVO(Wrapper<PropEntity> wrapper);
}
