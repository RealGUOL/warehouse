package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.MyEntityWrapper;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.CrewDao;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.service.CrewService;
import com.realguo.web.vo.CrewVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("crewService")
public class CrewServiceImpl extends ServiceImpl<CrewDao, CrewEntity> implements CrewService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CrewEntity> page = this.selectPage(new Query<CrewEntity>(params).getPage(), new MyEntityWrapper<>(params));
        return new PageUtils(page);
    }

    @Override
    public List<CrewVO> selectListVO(Wrapper<CrewEntity> wrapper) {
        List<Map<String, Object>> map = baseMapper.selectMaps(wrapper);
        List<CrewVO> res = map.stream().map(e -> new CrewVO((long) e.get("crew_id"), (String) e.get("crew_name"))).collect(Collectors.toList());
        return res;
    }

}
