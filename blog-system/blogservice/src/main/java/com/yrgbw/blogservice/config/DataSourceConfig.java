package com.yrgbw.blogservice.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.yrgbw.blogservice.bean.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    @Bean("mysql")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource mysqlDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("sqlServer")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource sqlServerDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据库配置
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(mysqlDataSource());
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("mysql", mysqlDataSource());
        dsMap.put("sqlServer", sqlServerDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
}
