
package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.LendingRecordDao;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.LendingRecordEntity;
import com.realguo.web.service.CrewService;
import com.realguo.web.service.DepotService;
import com.realguo.web.service.LendingRecordService;
import com.realguo.web.service.PropService;
import com.realguo.web.vo.DepotPropVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LendingRecordEntity> page = this.selectPage(
                new Query<LendingRecordEntity>(params).getPage(),
                new EntityWrapper<LendingRecordEntity>()
        );

        for (int i = 0; i < page.getRecords().size(); i++) {
            LendingRecordEntity lendingRecord = page.getRecords().get(i);
            page.getRecords().get(i).setCrewName(crewService.selectById(lendingRecord.getCrewId()).getCrewName());
            page.getRecords().get(i).setPropName(propService.selectById(lendingRecord.getPropId()).getPropName());
            page.getRecords().get(i).setDepotName(depotService.selectById(lendingRecord.getDepotId()).getDepotName());
        }

        return new PageUtils(page);
    }
}
