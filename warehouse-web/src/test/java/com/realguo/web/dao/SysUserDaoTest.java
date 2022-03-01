package com.realguo.web.dao;

import com.google.common.collect.Maps;
import com.realguo.web.entity.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class SysUserDaoTest {
    @Autowired
    SysUserDao userDao;

    @Test
    public void TestSelectById() {
        SysUserEntity sysUserEntity = userDao.selectById("1");
        System.out.println(sysUserEntity);
    }

    @Test
    public void TestSelectByMap() {
        /*通过用户名查询数据库*/
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("username", "root");
        List<SysUserEntity> user = userDao.selectByMap(map);
        System.out.println(user);
    }

    @Test
    public void TestSelectOne() {
        /*通过用户名查询数据库*/
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setUserId(1L);
        SysUserEntity sysUserEntity1 = userDao.selectOne(sysUserEntity);
        System.out.println(sysUserEntity1);
    }
}
