package com.realguo.web.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Maps;
import com.realguo.common.utils.MyEntityWrapper;
import com.realguo.common.utils.PageUtils;
import com.realguo.web.dao.LendingRecordDao;
import com.realguo.web.entity.LendingRecordEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class LendingRecordServiceTest {

    @Autowired
    private LendingRecordService lendingRecordService;

    @Autowired
    private LendingRecordDao lendingRecordDao;

    @Test
    public void TestSearch() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("page", "1");
        map.put("limit", "3");
        PageUtils pageUtils = lendingRecordService.queryPage(map);
        System.out.println(pageUtils);
    }

    @Test
    public void TestSearch2() {
        Page<LendingRecordEntity> lendingRecordEntityPage = lendingRecordService.selectPage(new Page<>(1, 3));
        System.out.println(lendingRecordEntityPage);
        System.out.println(lendingRecordEntityPage.getRecords());
    }


    @Test
    public void TestSearch5() {
        Page page = new Page(1, 3);
        System.out.println(page);
        Map<String, Object> map = Maps.newHashMap();
        map.put("prop_name", "小刀1");
        List<LendingRecordEntity> lendingRecordEntities = lendingRecordDao.queryPage(page, new MyEntityWrapper<LendingRecordEntity>(map));
        for (LendingRecordEntity lendingRecordEntity : lendingRecordEntities) {
            System.out.println(lendingRecordEntity);
        }
        System.out.println(page);
        System.out.println(page.getRecords());
    }
}
