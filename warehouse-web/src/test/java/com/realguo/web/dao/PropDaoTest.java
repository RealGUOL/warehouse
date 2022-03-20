package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.PropEntity;
import com.realguo.web.view.DepotPropView;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class PropDaoTest {
    @Autowired
    PropDao propDao;

    @Test
    public void TestInsert() {
        for (int i = 0; i < 1000; i++) {
            PropEntity prop = new PropEntity();
            prop.setPropCode("AAAAAA" + i);
            prop.setPropName("小刀" + i);
            prop.setPrice(new BigDecimal("1.1"));
            prop.setImg("http://wwww.baidu.com/" + i);
            prop.setRemark("测试" + i);
            prop.setCreateTime(new Date());
            propDao.insert(prop);
        }
    }

    @Test
    public void TestSelectByMap() {
        /*通过用户名查询数据库*/
        HashMap<String, Object> map = Maps.newHashMap();
        ArrayList<String> list = Lists.newArrayList("1500343481731326000", "1500343481731326000");
        map.put("prop_id", list);
        List<PropEntity> propEntities = propDao.selectByMap(map);
        System.out.println(propEntities);
    }

    @Test
    public void TestQueryDepotDetail() {
        List<DepotPropView> depotPropViews = propDao.queryDepotDetail(1505183736305160193L);
        for (DepotPropView depotPropView : depotPropViews) {
            System.out.println("=========================================");
            System.out.println(depotPropView.getDepotName());
            System.out.println(depotPropView.getDepotId());
            System.out.println(depotPropView.getStock());
            System.out.println(depotPropView.getPropId());
            System.out.println(depotPropView);
        }
    }

    @Test
    public void TestQueryPage() {
        List<PropEntity> props = propDao.queryPage(new Page(1, 3), new EntityWrapper<PropEntity>().like("prop_name", "小刀1"));
        for (PropEntity prop : props) {
            System.out.println(prop);
        }
    }
}
