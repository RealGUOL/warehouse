package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.CrewDao;
import com.realguo.web.dao.PropDao;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.service.CrewService;
import com.realguo.web.service.PropService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("propService")
public class PropServiceImpl extends ServiceImpl<PropDao, PropEntity> implements PropService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PropEntity> page = this.selectPage(
                new Query<PropEntity>(params).getPage(),
                new EntityWrapper<PropEntity>()
        );

        return new PageUtils(page);
    }
}
