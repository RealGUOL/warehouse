package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.common.utils.PageUtils;
import com.realguo.common.utils.Query;
import com.realguo.web.dao.PropDao;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.service.DepotPropService;
import com.realguo.web.service.PropService;
import com.realguo.web.vo.PropVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("propService")
public class PropServiceImpl extends ServiceImpl<PropDao, PropEntity> implements PropService {

    @Autowired
    private DepotPropService depotPropService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PropEntity> page = this.selectPage(
                new Query<PropEntity>(params).getPage(),
                new EntityWrapper<PropEntity>()
        );

        for (int i = 0; i < page.getRecords().size(); i++) {
            page.getRecords().get(i).setDepotProp(depotPropService.getDepotPropVO(page.getRecords().get(i).getPropId()));
        }
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PropEntity propEntity) {
        this.insert(propEntity);

        //保存道具和所在仓库库存
        depotPropService.saveOrUpdate(propEntity.getPropId(), propEntity.getDepotProp());
    }

    @Override
    public List<PropVO> selectListVO(Wrapper<PropEntity> wrapper) {
        List<Map<String, Object>> map = baseMapper.selectMaps(wrapper);
        List<PropVO> res = map.stream().map(e -> new PropVO((long) e.get("prop_id"), (String) e.get("prop_name"))).collect(Collectors.toList());
        return res;
    }
}
