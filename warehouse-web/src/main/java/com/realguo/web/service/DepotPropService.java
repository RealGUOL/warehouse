package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.view.DepotPropView;

import java.util.List;


/**
 * 仓库和道具对应关系
 */
public interface DepotPropService extends IService<DepotPropEntity> {

    void saveOrUpdate(Long propId, List<DepotPropView> depotProp);

    /**
     * 根据道具ID，获取道具在各仓库的信息
     */
    List<DepotPropView> getDepotPropVO(Long propId);
}
