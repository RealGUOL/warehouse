package com.realguo.web.dao;

import com.realguo.web.entity.PropEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

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
            prop.setStock(100);
            prop.setImg("http://wwww.baidu.com/" + i);
            prop.setRemark("测试" + i);
            prop.setCreateTime(new Date());
            propDao.insert(prop);
        }

    }
}
