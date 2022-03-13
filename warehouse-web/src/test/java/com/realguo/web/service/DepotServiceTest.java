package com.realguo.web.service;

import com.realguo.web.entity.DepotEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepotServiceTest {
    @Autowired
    DepotService depotService;

    @Test
    public void TestUpdate() {
        DepotEntity depot = new DepotEntity();
        depot.setDepotId(1500407732613374000L);
        depot.setDepotName("仓库test");
        depot.setDescription("仓库test");
        boolean res = depotService.updateById(depot);
        System.out.println(res);
    }

    @Test
    public void TestDelete() {
    }
}
