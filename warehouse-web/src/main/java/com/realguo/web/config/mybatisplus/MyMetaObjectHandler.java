package com.realguo.web.config.mybatisplus;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.realguo.web.config.shiro.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.UnavailableSecurityManagerException;

import java.util.Date;

@Slf4j
public class MyMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("新增的时候干点不可描述的事情");
        setFieldValByName("createTime", new Date(), metaObject);
        try {
            if (ShiroUtils.getUserEntity() != null) {
                setFieldValByName("operator", ShiroUtils.getUserEntity().getUsername(), metaObject);
            }
        } catch (UnavailableSecurityManagerException e) {
            System.out.println("定时任务不能由shiro管理，所以执行shiro方法会报错");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新的时候干点不可描述的事情");
        setFieldValByName("updateTime", new Date(), metaObject);
        try {
            if (ShiroUtils.getUserEntity() != null) {
                setFieldValByName("operator", ShiroUtils.getUserEntity().getUsername(), metaObject);
            }
        } catch (UnavailableSecurityManagerException e) {
            System.out.println("定时任务不能由shiro管理,所以执行shiro方法会报错");
        }
    }

}
