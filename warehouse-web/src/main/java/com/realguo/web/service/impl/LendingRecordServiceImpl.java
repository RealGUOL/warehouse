
package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.realguo.common.exception.RRException;
import com.realguo.common.utils.MyEntityWrapper;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.LendingRecordDao;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.LendingRecordEntity;
import com.realguo.web.service.*;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * 出借记录管理
 */
@Service("lendingRecordService")
public class LendingRecordServiceImpl extends ServiceImpl<LendingRecordDao, LendingRecordEntity> implements LendingRecordService {

    @Autowired
    private CrewService crewService;

    @Autowired
    private PropService propService;

    @Autowired
    private DepotService depotService;

    @Autowired
    private DepotPropService depotPropService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LendingRecordEntity> page = new Query<LendingRecordEntity>(params).getPage();
        List<LendingRecordEntity> records = this.baseMapper.queryPage(page, new MyEntityWrapper<>(params));
        page.setRecords(records);
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(LendingRecordEntity lendingRecord) {
        this.insert(lendingRecord);
        // 查询库存
        Map<String, Object> map = Maps.newHashMap();
        map.put("depot_id", lendingRecord.getDepotId());
        map.put("prop_id", lendingRecord.getPropId());
        List<DepotPropEntity> depotPropEntities = depotPropService.selectByMap(map);
        if (CollectionUtils.isEmpty(depotPropEntities)) {
            throw new RRException("未找到相关库存");
        }
        // 检查库存
        DepotPropEntity depotProp = depotPropEntities.get(0);
        if (depotProp.getStock() < lendingRecord.getBorrowNum() - lendingRecord.getReturnNum()) {
            throw new RRException("库存不足");
        }
        // 扣库存
        depotProp.setStock(depotProp.getStock() - lendingRecord.getBorrowNum() + lendingRecord.getReturnNum());
        depotPropService.updateById(depotProp);

        lendingRecord.setCrewName(crewService.selectById(lendingRecord.getCrewId()).getCrewName());
        lendingRecord.setPropName(propService.selectById(lendingRecord.getPropId()).getPropName());
        lendingRecord.setDepotName(depotService.selectById(lendingRecord.getDepotId()).getDepotName());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LendingRecordEntity lendingRecord) {
        /**
         * 归还旧的出借记录
         */
        // 1. 查找旧的出借记录
        LendingRecordEntity lendingRecordEntity = this.selectById(lendingRecord.getLendingRecordId());
        // 2. 根据就的操作记录，查询旧的库存
        Map<String, Object> map = Maps.newHashMap();
        map.put("depot_id", lendingRecordEntity.getDepotId());
        map.put("prop_id", lendingRecordEntity.getPropId());
        List<DepotPropEntity> depotPropEntities = depotPropService.selectByMap(map);
        if (CollectionUtils.isEmpty(depotPropEntities)) {
            throw new RRException("更新失败");
        }
        // 3. 归还
        DepotPropEntity depotProp = depotPropEntities.get(0);
        depotProp.setStock(depotProp.getStock() + lendingRecordEntity.getBorrowNum() - lendingRecordEntity.getReturnNum());
        depotPropService.updateById(depotProp);


        /**
         * 重新借新的出借记录
         */
        this.updateById(lendingRecord);
        // 查询库存
        map.put("depot_id", lendingRecord.getDepotId());
        map.put("prop_id", lendingRecord.getPropId());
        depotPropEntities = depotPropService.selectByMap(map);
        if (CollectionUtils.isEmpty(depotPropEntities)) {
            throw new RRException("未找到相关库存");
        }
        // 检查库存
        depotProp = depotPropEntities.get(0);
        if (depotProp.getStock() < lendingRecord.getBorrowNum() - lendingRecord.getReturnNum()) {
            throw new RRException("库存不足");
        }
        // 扣库存
        depotProp.setStock(depotProp.getStock() - lendingRecord.getBorrowNum() + lendingRecord.getReturnNum());
        depotPropService.updateById(depotProp);

    }
}
