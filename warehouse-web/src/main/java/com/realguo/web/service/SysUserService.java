package com.realguo.web.service;

import com.baomidou.mybatisplus.service.IService;
import com.realguo.web.entity.SysUserEntity;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService extends IService<SysUserEntity> {

//	PageUtils queryPage(PageInfo pageInfo,SysUserModel sysUserModel);
	
	/**
	 * 查询用户的所有菜单ID
	 */
//	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 保存用户
	 */
	void save(SysUserEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
//	boolean updatePassword(Long userId, String password, String newPassword);
}
