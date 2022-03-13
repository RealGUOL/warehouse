package com.realguo.web.service;

import com.realguo.web.entity.PropEntity;
import com.realguo.web.entity.SysUserEntity;
import com.realguo.web.vo.DepotPropVO;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class DepotPropServiceTest {
    @Autowired
    DepotPropService depotPropService;

    @Autowired
    DepotService depotService;

    @Autowired
    PropService propService;

    @Test
    public void TestSave() {
        List<Long> depotIds = Lists.newArrayList(1502869573633515521L, 1502869574359130113L, 1502869574359130113L, 1502869574384295938L, 1502869574396878850L);
        for (int i = 0; i < 100; i++) {
            PropEntity prop = new PropEntity();
            prop.setPropCode("AAAAAA" + i);
            prop.setPropName("小刀" + i);
            prop.setPrice(new BigDecimal("1.1"));
            prop.setImg("http://wwww.baidu.com/" + i);
            prop.setRemark("测试" + i);
            prop.setCreateTime(new Date());
            List<DepotPropVO> list = Lists.newArrayList();
            for (Long depotId : depotIds) {
                DepotPropVO depotPropVO = new DepotPropVO();
                depotPropVO.setPropId(prop.getPropId());
                depotPropVO.setDepotId(depotId);
                depotPropVO.setStock(20);
                list.add(depotPropVO);
            }
            prop.setDepotProp(list);
            propService.save(prop);
        }
    }

    @Test
    public void TestDelete() {
    }
}
