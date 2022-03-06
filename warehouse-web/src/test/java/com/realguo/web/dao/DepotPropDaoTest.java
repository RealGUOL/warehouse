package com.realguo.web.dao;

import com.google.common.collect.Maps;
import com.realguo.web.entity.DepotPropEntity;
import com.realguo.web.entity.SysUserEntity;
import com.realguo.web.service.DepotPropService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class DepotPropDaoTest {
    @Autowired
    DepotPropService depotPropService;

    @Test
    public void TestSelectByMap() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("prop_id", 1500412545363329026L);
        List<DepotPropEntity> records = depotPropService.selectByMap(map);
        System.out.println(records);
    }
}
