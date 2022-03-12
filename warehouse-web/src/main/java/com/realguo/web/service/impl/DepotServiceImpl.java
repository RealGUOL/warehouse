package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.CrewDao;
import com.realguo.web.dao.DepotDao;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.service.CrewService;
import com.realguo.web.service.DepotService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("depotService")
public class DepotServiceImpl extends ServiceImpl<DepotDao, DepotEntity> implements DepotService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DepotEntity> page = this.selectPage(
                new Query<DepotEntity>(params).getPage(),
                new EntityWrapper<DepotEntity>()
        );
        System.out.println(page.getRecords().get(0).getDepotId());
        return new PageUtils(page);
    }
}
