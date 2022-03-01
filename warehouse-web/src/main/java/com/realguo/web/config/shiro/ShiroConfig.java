package com.realguo.web.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author RealGUO
 *
 * 配置shiro
 */

@Configuration
public class ShiroConfig {

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean(SecurityManager securityManager){
        MethodInvokingFactoryBean bean = new MethodInvokingFactoryBean();
        bean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        bean.setArguments(securityManager);
        return bean;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * 开启shiro aop注解支持.
     * 使用代理方式;所以需要开启代码支持;
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * ShiroFilterFactoryBean
     *
     * @param defaultWebSecurityManager
     * @return Subject: the current user
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, Filter> filterss = bean.getFilters();
        filterss.put("authc", new ShiroLoginFilter());
        bean.setFilters(filterss);


        /**
         * 添加shiro的内置过滤器
         *
         * anon: 无需认证就可以访问
         * authc： 必须认证了才能访问
         * user：必须拥有记住我功能才能用
         * perms: 拥有对某个资源的权限才能访问
         * role:  拥有某个角色权限才能访问
         */

        Map<String, String> filters = new LinkedHashMap<>();
        filters.put("/user/login", "anon");
        filters.put("/user/register", "anon");
        filters.put("/index.html", "anon");
        filters.put("/captcha.jpg", "anon");
        // 放行swagger
        filters.put("/swagger-ui/*", "anon");
        filters.put("/swagger-ui/*", "anon");
        filters.put("/v2/api-docs", "anon");
        filters.put("/swagger-resources/**", "anon");
        filters.put("/webjars/**", "anon");
        // 拦截
        filters.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filters);
        return bean;

    }

    /**
     * DefaultWebSecurityManager
     *
     * @param userRealm
     * @return SecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * Realm: UserRealm
     *
     * @return UserRealm
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


}
