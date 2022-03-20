
package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.realguo.web.dao.DepotPropDao;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.service.DepotPropService;
import com.realguo.web.service.DepotService;
import com.realguo.web.view.DepotPropView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 用户与角色对应关系
 */
@Service("depotPropService")
public class DepotPropServiceImpl extends ServiceImpl<DepotPropDao, DepotPropEntity> implements DepotPropService {

    @Autowired
    private DepotService depotService;

    @Override
    public void saveOrUpdate(Long propId, List<DepotPropView> depotProp) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("prop_id", propId);
        // 先删除道具和仓库的关系
        for (DepotPropEntity depotPropEntity : depotProp) {
            map.put("depot_id", depotPropEntity.getDepotId());
            baseMapper.deleteByMap(map);
        }

        List<DepotPropEntity> list = depotProp.stream().map(DepotPropEntity::new).collect(Collectors.toList());

        // 保存道具和仓库关系
        for (DepotPropEntity depotPropEntity : list) {
            depotPropEntity.setPropId(propId);
        }
        this.insertBatch(list);
    }
}
