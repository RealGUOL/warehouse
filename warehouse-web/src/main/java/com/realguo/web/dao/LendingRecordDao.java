package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.realguo.web.entity.LendingRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 出借记录管理
 */
public interface LendingRecordDao extends BaseMapper<LendingRecordEntity> {

    List<LendingRecordEntity> queryPage(Page page, @Param("ew") Wrapper<LendingRecordEntity> wrapper);
}
