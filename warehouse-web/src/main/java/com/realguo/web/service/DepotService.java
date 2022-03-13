package com.realguo.web.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.vo.DepotVO;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 */
public interface DepotService extends IService<DepotEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<DepotVO> selectListVO(Wrapper<DepotEntity> wrapper);
}
