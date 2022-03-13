package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.entity.LendingRecordEntity;

import java.util.Map;


/**
 * 出借记录管理
 */
public interface LendingRecordService extends IService<LendingRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存出借记录
     */
    void save(LendingRecordEntity lendingRecord);
}
