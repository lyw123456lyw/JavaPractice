package com.yrgbw.blogservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.yrgbw.blogservice.mapper")
@EnableSwagger2
public class BlogserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogserviceApplication.class, args);
    }

}
