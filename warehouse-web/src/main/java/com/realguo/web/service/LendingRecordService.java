package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.LendingRecordEntity;
import com.realguo.web.vo.DepotPropVO;

import java.util.List;
import java.util.Map;


/**
 * 出借记录管理
 */
public interface LendingRecordService extends IService<LendingRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
