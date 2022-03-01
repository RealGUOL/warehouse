package com.realguo.web.config.shiro;

import com.realguo.web.dao.SysUserDao;
import com.realguo.web.entity.SysUserEntity;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


/**
 * @author RealGUO
 *
 * 配置shiro Realm
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    SysUserDao sysUserDao;

    /**
     * 授权：为当前登录的Subject授予角色和权限（角色的权限信息集合）
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUserEntity user = (SysUserEntity)principalCollection.getPrimaryPrincipal();
        Long userId = user.getUserId();

        List<String> permsList;
//        // 如果缓存不存在就加入缓存
//        if(!cacheChannel.exists("permsList",userId.toString())) {
//            //系统管理员，拥有最高权限
//            if(userId == Constant.SUPER_ADMIN){
//                List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
//                permsList = new ArrayList<>(menuList.size());
//                for(SysMenuEntity menu : menuList){
//                    permsList.add(menu.getPerms());
//                }
//            }else{
//                permsList = sysUserDao.queryAllPerms(userId);
//            }
//            cacheChannel.set("permsList", userId.toString(), permsList);
//        }
//        else {
//
//            permsList = (List<String>) cacheChannel.get("permsList", userId.toString()).getValue();
//        }
        permsList = user.getRoleIdList();
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     *  认证
     * @param authenticationToken: controller中 login传来的参数
     * @return 返回给controller
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //查询用户信息
        SysUserEntity user = new SysUserEntity();
        user.setUsername(token.getUsername());
        user = sysUserDao.selectOne(user);

        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        /*密码认证，shiro自己完成*/
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
