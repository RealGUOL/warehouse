package com.realguo.web.dao;

import com.google.common.collect.Maps;
import com.realguo.web.entity.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class SysUserRoleDaoTest {
    @Autowired
    SysUserRoleDao sysUserRoleDao;

    @Test
    public void TestSelectById() {
        List<Long> longs = sysUserRoleDao.queryRoleIdList(1500407485195612162L);
        System.out.println(longs);
    }
}
