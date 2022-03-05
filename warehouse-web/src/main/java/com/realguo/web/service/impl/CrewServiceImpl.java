package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.CrewDao;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.service.CrewService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("crewService")
public class CrewServiceImpl extends ServiceImpl<CrewDao, CrewEntity> implements CrewService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CrewEntity> page = this.selectPage(
                new Query<CrewEntity>(params).getPage(),
                new EntityWrapper<CrewEntity>()
        );

        return new PageUtils(page);
    }
}
