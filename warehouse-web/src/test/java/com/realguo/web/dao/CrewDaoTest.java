package com.realguo.web.dao;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.realguo.web.entity.CrewEntity;
import com.realguo.web.vo.CrewVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CrewDaoTest {
    @Autowired
    CrewDao crewDao;

    @Test
    public void TestInsert() {
        CrewEntity crew = new CrewEntity();
        crew.setCrewName("花儿乐队");
        crew.setPhone("17621697883");
        crew.setContact("刘陈陈");
        crew.setRemark("剧组");
        crew.setCreateTime(new Date());
        crewDao.insert(crew);

        CrewEntity crew1 = new CrewEntity();
        crew1.setCrewName("花儿乐队1");
        crew1.setPhone("17621697883");
        crew1.setContact("刘陈陈1");
        crew1.setRemark("剧组1");
        crew1.setCreateTime(new Date());
        crewDao.insert(crew1);


        CrewEntity crew2 = new CrewEntity();
        crew2.setCrewName("花儿乐队2");
        crew2.setPhone("17621697883");
        crew2.setContact("刘陈陈2");
        crew2.setRemark("剧组2");
        crew2.setCreateTime(new Date());
        crewDao.insert(crew2);

        CrewEntity crew3 = new CrewEntity();
        crew3.setCrewName("花儿乐队3");
        crew3.setPhone("17621697883");
        crew3.setContact("刘陈陈3");
        crew3.setRemark("剧组3");
        crew3.setCreateTime(new Date());
        crewDao.insert(crew3);
    }

    @Test
    public void testEW() {
        // https://baomidou.gitee.io/mybatis-plus-doc/#/wrapper
        EntityWrapper<CrewEntity> ew = new EntityWrapper<CrewEntity>();
        ew.setEntity(new CrewEntity());
        ew.where("user_name={0}", "'zhangsan'").and("id=1")
                .orNew("user_status={0}", "0").or("status=1")
                .notLike("user_nickname", "notvalue")
                .andNew("new=xx").like("hhh", "ddd")
                .andNew("pwd=11").isNotNull("n1,n2").isNull("n3")
                .groupBy("x1").groupBy("x2,x3")
                .having("x1=11").having("x3=433")
                .orderBy("dd").orderBy("d1,d2");
        System.out.println(ew.getSqlSegment());
        System.out.println("===================================================");

        Wrapper eq = Condition.create().setSqlSelect("sum(quantity)")
                .isNull("order_id")
                .eq("user_id", 1)
                .eq("type", 1)
                .in("status", new Integer[]{0, 1})
                .eq("product_id", 1)
                .eq("weal", 1);

        System.out.println(eq.getSqlSegment());
        System.out.println(eq.getSqlSelect());
        System.out.println(eq);
    }

    @Test
    public void testSelectByEW() {
        List<Map<String, Object>> maps = crewDao.selectMaps(new EntityWrapper<CrewEntity>()
                .setSqlSelect("crew_id, crew_name")
                .like("crew_name", "花儿"));
        System.out.println(maps);
    }

    @Test
    public void testTSQL11() {
        /*
         * 实体带查询使用方法  输出看结果
         */
        EntityWrapper<CrewEntity> ew = new EntityWrapper<CrewEntity>();
        ew.where("user_name={0}", "'zhangsan'").where("password = {0}", "123456");
        System.out.println(ew.getSqlSegment());
    }
}
