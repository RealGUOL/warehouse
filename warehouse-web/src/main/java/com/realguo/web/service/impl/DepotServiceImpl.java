package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.DepotDao;
import com.realguo.web.entity.DepotEntity;
import com.realguo.web.service.DepotService;
import com.realguo.web.vo.DepotVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("depotService")
public class DepotServiceImpl extends ServiceImpl<DepotDao, DepotEntity> implements DepotService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DepotEntity> page = this.selectPage(
                new Query<DepotEntity>(params).getPage(),
                new EntityWrapper<DepotEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<DepotVO> selectListVO(Wrapper<DepotEntity> wrapper) {
        List<Map<String, Object>> map = baseMapper.selectMaps(wrapper);
        List<DepotVO> res = map.stream().map(e -> new DepotVO((long) e.get("depot_id"), (String) e.get("depot_name"))).collect(Collectors.toList());
        return res;
    }
}
