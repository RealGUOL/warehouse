/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.realguo.web.controller;


import com.realguo.common.utils.R;
import com.realguo.common.validator.ValidatorUtils;
import com.realguo.web.entity.SysUserEntity;
import com.realguo.web.service.SysUserRoleService;
import com.realguo.web.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统用户
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
//	@Autowired
//	private SysDeptService sysDeptService;

//	/**
//	 * 所有用户列表
//	 */
//	@RequestMapping("/list")
//	@RequiresPermissions("sys:user:list")
//	public PageUtils list(JQPageInfo pageInfo,SysUserModel sysUserModel){
//		PageUtils page = sysUserService.queryPage(new PageInfo(pageInfo),sysUserModel);
//
//		return page;
//	}
	
//	/**
//	 * 获取登录的用户信息
//	 */
//	@RequestMapping("/info")
//	public R info(){
//		return R.ok().put("user", getUser());
//	}
//
//	/**
//	 * 修改登录用户密码
//	 */
//	@SysLog("修改密码")
//	@RequestMapping("/password")
//	public R password(String password, String newPassword){
//		Assert.isBlank(newPassword, "新密码不为能空");
//
//		//原密码
//		password = ShiroUtils.sha256(password, getUser().getSalt());
//		//新密码
//		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());
//
//		//更新密码
//		boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
//		if(!flag){
//			return R.error("原密码不正确");
//		}
//
//		return R.ok();
//	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.selectById(userId);

		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);

		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@RequestMapping("/register")
	public R register(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user);
		
		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@RequestMapping("/update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user);

		sysUserService.update(user);
		
		return R.ok();
	}
	
//	/**
//	 * 删除用户
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("sys:user:delete")
//	public R delete(@RequestBody Long[] userIds){
//		if(ArrayUtils.contains(userIds, 1L)){
//			return R.error("系统管理员不能删除");
//		}
//
//		if(ArrayUtils.contains(userIds, getUserId())){
//			return R.error("当前用户不能删除");
//		}
//
//		sysUserService.deleteBatchIds(Arrays.asList(userIds));
//
//		return R.ok();
//	}
}
