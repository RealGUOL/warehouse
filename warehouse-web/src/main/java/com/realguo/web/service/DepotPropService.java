package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.SysUserRoleEntity;
import com.realguo.web.vo.DepotPropVO;

import java.util.List;
import java.util.Map;


/**
 * 仓库和道具对应关系
 */
public interface DepotPropService extends IService<DepotPropEntity> {

    void saveOrUpdate(Long propId, List<DepotPropVO> depotProp);

    /**
     * 根据道具ID，获取道具在各仓库的信息
     */
    List<DepotPropVO> getDepotPropVO(Long propId);
}
