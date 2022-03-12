package com.realguo.web.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.realguo.web.config.shiro.ShiroUtils;
import com.realguo.web.dao.SysUserDao;
import com.realguo.web.entity.SysUserEntity;
import com.realguo.web.service.SysUserRoleService;
import com.realguo.web.service.SysUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserEntity user) {
        //sha256加密
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setSalt(salt);
        user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
        this.insert(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserEntity user) {
        if(StringUtils.isBlank(user.getPassword())){
            user.setPassword(null);
        }else{
            user.setPassword(ShiroUtils.sha256(user.getPassword(), user.getSalt()));
        }
        this.updateById(user);

        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
    }
}
