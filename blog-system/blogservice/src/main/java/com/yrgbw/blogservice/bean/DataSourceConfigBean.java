package com.yrgbw.blogservice.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 通过配置属性类去获得配置文件中的信息。
 * 如下所示，@Configuration表明该类是一个配置类。
 * @PropertySource 注解是加载指定的配置文件，其中value值是配置文件的路径。encoding指定读取属性文件所使用的编码。
 * springboot提供了一个注解@ConfigurationProperties(prefix = "spring.datasource")。
 * 通过prefix指定前缀属性就会自动赋值。至此，该类就具有了配置文件中的值
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource(value={"classpath:config/dataSourceConfig.properties"},encoding = "UTF-8")
public class DataSourceConfigBean {
    private String type;
    private String driverClassName;
    private String platform;
    private String url;
    private String username;
    private String password;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private String filters;
    private boolean logSlowSql;
}

