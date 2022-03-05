package com.realguo.web.config.page;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.realguo.web.config.shiro.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//@Component
@Slf4j
public class MyMetaObjectHandler extends MetaObjectHandler {

//	protected final static Logger logger = LoggerFactory.getLogger(AdminApplication.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("新增的时候干点不可描述的事情");
		setFieldValByName("createTime", new Date(), metaObject);
		try {
			if (ShiroUtils.getUserEntity() != null) {
				setFieldValByName("createBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
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
				setFieldValByName("updateBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
			}
		} catch (UnavailableSecurityManagerException e) {
			System.out.println("定时任务不能由shiro管理,所以执行shiro方法会报错");
		}
	}

}
