package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.SysRoleEntity;

import java.util.List;

/**
 * 仓库道具管理
 */
public interface DepotPropDao extends BaseMapper<DepotPropEntity> {

    /**
     * 根据道具id，获取道具存储仓库信息
     */
    List<DepotPropEntity> queryDepotPropList(Long propId);
}
