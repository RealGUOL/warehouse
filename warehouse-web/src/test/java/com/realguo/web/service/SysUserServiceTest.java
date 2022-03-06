package com.realguo.web.service;

import com.realguo.web.entity.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysUserServiceTest {
    @Autowired
    SysUserService sysUserService;

    @Test
    public void TestInsert() {
        SysUserEntity user = new SysUserEntity();
        user.setUsername("admin");
        user.setPassword("111111");
        user.setPhone("17621697883");
        user.setEmail("1101036063");
        user.setStatus(1);
        sysUserService.save(user);
    }

    @Test
    public void TestDelete() {
    }
}
