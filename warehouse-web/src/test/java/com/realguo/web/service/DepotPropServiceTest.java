package com.realguo.web.service;

import com.realguo.web.entity.LendingRecordEntity;
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
    private PropService propService;

    @Autowired
    private LendingRecordService lendingRecordService;

    @Test
    public void TestSave() {
        List<Long> depotIds = Lists.newArrayList(1502869573633515521L, 1502869574359130113L, 1502869574371713025L, 1502869574384295938L, 1502869574396878850L);
        List<Long> crewIds = Lists.newArrayList(1500407682613096450L, 1500407682755702785L, 1500407682768285698L, 1502879469594701825L, 1502927208391106562L);
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
            // 出借
            for (int j = 0; j < depotIds.size(); j++) {
                LendingRecordEntity lendingRecord = new LendingRecordEntity();
                lendingRecord.setPropId(prop.getPropId());
                lendingRecord.setBorrowNum((j+1)*2);
                lendingRecord.setCrewId(crewIds.get(j));
                lendingRecord.setDepotId(depotIds.get(j));
                lendingRecord.setDailyRent(new BigDecimal((j+1)*10));
                lendingRecord.setRentalDays(j+1);
                lendingRecord.setRemark("出借记录"+j);
                lendingRecord.setOperator("admin");
                lendingRecordService.save(lendingRecord);
            }

        }
    }

    @Test
    public void TestDelete() {
    }
}
