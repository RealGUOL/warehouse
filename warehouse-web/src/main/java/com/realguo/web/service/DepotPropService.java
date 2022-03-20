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
}
