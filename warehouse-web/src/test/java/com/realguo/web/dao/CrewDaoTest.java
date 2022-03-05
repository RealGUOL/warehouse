package com.realguo.web.dao;

import com.realguo.web.entity.CrewEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
}
