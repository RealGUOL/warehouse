package com.realguo.web.config.mybatisplus;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.toolkit.GlobalConfigUtils;
import com.realguo.web.config.mybatisplus.MyMetaObjectHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mybatis-plus配置
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.1.0 2018-02-05
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MyMetaObjectHandler();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        //获取mybatis-plus全局配置
        GlobalConfiguration globalConfig = GlobalConfigUtils.defaults();
        //mybatis-plus全局配置设置元数据对象处理器为自己实现的那个
        globalConfig.setMetaObjectHandler(new MyMetaObjectHandler());
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mybatisSqlSessionFactoryBean关联设置全局配置
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
        return mybatisSqlSessionFactoryBean.getObject();
    }
}
