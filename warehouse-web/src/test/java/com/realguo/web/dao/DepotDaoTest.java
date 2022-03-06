package com.realguo.web.dao;

import com.realguo.web.entity.DepotEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class DepotDaoTest {
    @Autowired
    DepotDao depotDao;

    @Test
    public void TestInsert() {
        for (int i = 0; i < 5; i++) {
            DepotEntity depot = new DepotEntity();
            depot.setDepotName("仓库" + i);
            depot.setDescription("仓库" + i);
            depot.setCreateTime(new Date());
            depotDao.insert(depot);
        }

    }
}
